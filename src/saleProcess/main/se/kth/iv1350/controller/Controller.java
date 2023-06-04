package saleProcess.main.se.kth.iv1350.controller;

import saleProcess.main.se.kth.iv1350.model.*;
import saleProcess.main.se.kth.iv1350.integration.*;

/**
 * This class is the main controller for the application.
 * It handles all requests that involve interacting with the model.
 *
 */
public class Controller {
    private Sale sale;
    private Register paymentRegister;
    private ExtrenalInventorySystem inventorySystem;
    private Payment totalPayment;
    private Printer printReceipt;
    private ExternalAccountingSystem acctSystem;
    private SaleDTO saleInfo;

    /**
     * Creates a new Controller instance.
     *
     * @param regCreator  The object used to get the payment register.
     * @param inventory   The external inventory system.
     * @param saleReceipt The printer used to print sale receipts.
     * @param accSystem   The external accounting system.
     */
    public Controller(RegisteryCreator regCreator, ExtrenalInventorySystem inventory, Printer saleReceipt,
            ExternalAccountingSystem accSystem) {
        this.paymentRegister = regCreator.getPaymentRegister();
        this.inventorySystem = inventory;
        this.printReceipt = saleReceipt;
        this.acctSystem = accSystem;

    }

    /**
     * Starts a new sale by creating a new Sale object.
     *
     * @return The new Sale object.
     */
    public Sale startNewSale() {
        sale = new Sale();
        return sale;
    }

    /**
     * Scans an item with the provided identifier and quantity.
     *
     * @param itemID       The identifier of the item.
     * @param itemQuantity The quantity of the item being scanned.
     * @return The information of the scanned item.
     */

    public ItemDTO scanItems(int itemID, int itemQuantity) {
        PurchaseItems checkItem = inventorySystem.getItemInfo(itemID);
        if (checkItem != null) {
            sale.registerItem(checkItem.getItemInfo(), itemQuantity);
            return checkItem.getItemInfo();
        }
        else {
            return null;
        }
    }

    /**
     * Ends the current sale by resetting related objects and variables.
     */
    public void endCurrentSale() {
        this.sale = null;
        this.totalPayment = null;
        this.saleInfo = null;
    }

    /**
     * Registers the payment amount and performs necessary operations related to the sale.
     *
     * @param amountPayment The amount of payment received from the customer.
     * @return The calculated change to be given back to the customer.
     */
    public double registerPayment(double amountPayment) {

        totalPayment = new Payment(amountPayment);
        sale.updateInformation(totalPayment);
        sale.registerPayment(totalPayment);
        paymentRegister.PaymentAmount(totalPayment);
        sale.createReceipt(printReceipt);
        acctSystem.UpdateAccountingSystem(saleInfo);
        inventorySystem.updateExtrenalInventorySystem(saleInfo);
        double change = sale.getSaleInfo().getChange();
        return change;
    }
}

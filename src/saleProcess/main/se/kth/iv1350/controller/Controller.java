package saleProcess.main.se.kth.iv1350.controller;

import saleProcess.main.se.kth.iv1350.model.*;
import saleProcess.main.se.kth.iv1350.integration.*;

public class Controller {
    private Sale sale;
    private Register paymentRegister;
    private ExtrenalInventorySystem inventorySystem;
    private Payment totalPayment;
    private Printer printReceipt;
    private ExternalAccountingSystem acctSystem;
    private SaleDTO saleInfo;

    public Controller(RegisteryCreator regCreator, ExtrenalInventorySystem inventory, Printer saleReceipt,
            ExternalAccountingSystem accSystem) {
        this.paymentRegister = regCreator.getPaymentRegister();
        this.inventorySystem = inventory;
        this.printReceipt = saleReceipt;
        this.acctSystem = accSystem;

    }

    public Sale startNewSale() {
        sale = new Sale();
        return sale;
    }

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

    public void endCurrentSale() {
        this.sale = null;
        this.totalPayment = null;
        this.saleInfo = null;
    }

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

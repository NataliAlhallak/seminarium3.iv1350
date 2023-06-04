package saleProcess.main.se.kth.iv1350.integration;

import saleProcess.main.se.kth.iv1350.model.*;

/**
 * This class represents the external inventory system.
 * It provides functionality to retrieve item information and update the external inventory system.
 */
public class ExtrenalInventorySystem {
    private PurchaseItems[] StoresInventory = new PurchaseItems[5];
    private PurchaseItems finalItem;

    /**
     * Creates an instance of ExternalInventorySystem.
     */
    public ExtrenalInventorySystem(){
    }

    /**
     * Initializes the list of store items.
     * Each item includes its name, identifier, price, and VAT rate.
     */
    private void storesItems(){
        StoresInventory[0] = new PurchaseItems(98762, new ItemDTO("Avocado", 22.0, 12.2));
        StoresInventory[1] = new PurchaseItems(98763, new ItemDTO("Milk", 33, 27.6));
        StoresInventory[2] = new PurchaseItems( 98764, new ItemDTO("Almond", 102, 33.3));
        StoresInventory[3] = new PurchaseItems( 98765, new ItemDTO("Apples", 43, 38.3));
        StoresInventory[4] = new PurchaseItems( 98768, new ItemDTO("Meat", 332, 99.9));
    }

    /**
     * Retrieves the information of an item with the specified item identifier.
     *
     * @param itemID The item identifier used to identify the item.
     * @return The information of the item.
     */
    public PurchaseItems getItemInfo(int itemID) {
        storesItems();
        for (PurchaseItems item : StoresInventory) {
            if (item.getItemIdenitifier() == itemID) {
                finalItem = item;

                return finalItem;
            }
            else {
                finalItem = null;
            }
        }
        return finalItem;
    }


    /**
     * Updates the external inventory system.
     *
     * @param saleInformation The SaleDTO object that contains information about the sale.
     */
        public void updateExtrenalInventorySystem (SaleDTO saleInformation){

        }
    }
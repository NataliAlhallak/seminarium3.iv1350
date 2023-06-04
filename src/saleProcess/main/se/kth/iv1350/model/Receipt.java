package saleProcess.main.se.kth.iv1350.model;

import java.time.LocalDateTime;

/**
 * The Receipt class represents a receipt for a sale.
 */
public class Receipt {
    private SaleDTO currentSale;
    private StringBuilder salesItem;
    private Sale sale;

    /**
     * Creates a new instance of Receipt.
     *
     * @param sales     The SaleDTO object that contains the sale information.
     * @param itemsList The StringBuilder object representing the list of items on the receipt.
     */
    public Receipt(SaleDTO sales, StringBuilder itemsList) {
        this.currentSale = sales;
        this.salesItem = itemsList;

    }


    /**
     * Gets the list of items on the receipt.
     *
     * @return The StringBuilder object representing the list of items.
     */
    private StringBuilder getItemsList() {
        salesItem = sale.itemsList();
        return salesItem;
    }

    private SaleDTO getCurrentSale() {
        return currentSale;
    }

    /**
     * Creates a string representation of the receipt.
     *
     * @return A well-formatted receipt string.
     */

    public String creatReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "---------The Receipt-------");
        endSection(builder);

        LocalDateTime saleTime = LocalDateTime.now();
        builder.append("Sales Date and Timer: ");
        appendLine(builder, saleTime.toString());
        endSection(builder);

        builder.append("Purchased Items: " + salesItem);

        builder.append("total Price : " + currentSale.getTotalPrice() + "\n");
        builder.append("------------------------------------------------------ \n");
        builder.append("Amount Paid : " + currentSale.getPayment() + "\n");
        builder.append("Change : " + currentSale.getChange());

        endSection(builder);
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}

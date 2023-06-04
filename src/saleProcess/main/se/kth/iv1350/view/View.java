package saleProcess.main.se.kth.iv1350.view;

import saleProcess.main.se.kth.iv1350.controller.*;

/**
 * The View class represents the user interface for the point of sale system.
 * It interacts with the Controller to facilitate sale processes and display information to the user.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance of the View class.
     *
     * @param contr The Controller instance to interact with.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Executes a sample sale process.
     * It demonstrates the flow of the sale process and handles exceptions.
     */
    public void sampleExecution() {
        System.out.println("Welcome to the store");
        contr.startNewSale();
        int itemId = 98762;
        int quantity = 6;


        System.out.println("New Scanned Item" + contr.scanItems(itemId, quantity));
        System.out.println("New Scanned Item" + contr.scanItems(98763, 1));

        contr.registerPayment(500);
        contr.endCurrentSale();
    }
}

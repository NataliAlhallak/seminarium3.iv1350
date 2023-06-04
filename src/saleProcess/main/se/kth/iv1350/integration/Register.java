package saleProcess.main.se.kth.iv1350.integration;
import saleProcess.main.se.kth.iv1350.model.*;

/**
 * The Register class is responsible for recording the amount of payment and keeping track of the store's amount of money.
 */
public class Register {
    private double storeAmount;
    /**
     * Creates an instance of Register.
     */
    public Register() {
    }

    /**
     * Records the amount of payment.
     *
     * @param amountPaid The Payment object that represents the amount paid.
     */
    public void PaymentAmount (Payment amountPaid){
        this.storeAmount += amountPaid.getAmountPayment();
    }

    /**
     * Returns the store's amount of money.
     *
     * @return The store's amount of money.
     */
    public double getStoreAmount (){
        return storeAmount;
    }
}

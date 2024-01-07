import java.util.ArrayList;

public class PrestoCard {
    
    // Instance variables
    private double balance;
    private String name;

    /**
     * Constructor for creating a new PrestoCard object with initial balance and name.
     *
     * @param balance the initial balance on the card.
     * @param name the name of the cardholder.
     */
    public PrestoCard(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    /**
     * Getter method for the balance on the card.
     *
     * @return the current balance on the card.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Getter method for the name of the cardholder.
     *
     * @return the name of the cardholder.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for updating the balance on the card.
     *
     * @param balance the new balance to be set on the card.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Setter method for updating the name of the cardholder.
     *
     * @param name the new name to be set for the cardholder.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to deduct fare from the card's balance when tapping on a transit system.
     *
     * @param fare the fare amount to be deducted from the card's balance.
     */
    public void tap(double fare) {
        if (balance >= fare) {
            balance -= fare;
            System.out.printf("Fare of $%.2f deducted. Remaining balance is $%.2f.%n", fare, balance);
        } else {
            System.out.printf("Error - Insufficient balance. Fare is $%.2f but the card has only $%.2f.%n", fare, balance);
        }
    }

    /**
     * Method to search for a card by the cardholder's name in an ArrayList of PrestoCard objects.
     *
     * @param cards the ArrayList of PrestoCard objects to search through.
     * @param name the name of the cardholder to search for.
     * @return the index of the first PrestoCard object with the specified name, or -1 if no such card is found.
     */
    public static int searchName(ArrayList<PrestoCard> cards, String name) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Method to add funds to the card's balance.
     *
     * @param amount the amount to be added to the card's balance.
     */
    public void topUp(double amount) {
        balance += amount;
        System.out.printf("$%.2f has been added to the card. Current balance is $%.2f.%n", amount, balance);
    }
}

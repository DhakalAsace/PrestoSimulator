// Name: Ashesh Dhakal
// Date: 4/19/2023
// App Name: Presto Simulator
// Description: This is an app that simulates a Presto card.

import java.util.Scanner;
import java.util.ArrayList;

public class PrestoSimulator {

    // Constants
    static final String SET_TITLE = "\033]0;%s\007";
    static final String CLEAR_TERMINAL = "\033c";
    static final String BANNER = """
    ==================
       PRESTO CARD
    ==================
    Program that simulates Presto cards
    """;

    static final int ONE_SECOND = 1000; // 1s is 1000ms
    static final double FIXED_FARE = 2.50;

    /**
     * A void function which stops code execution for one second
     */
    static void waitAsec() {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        // User input or text input

        Scanner scanner = new Scanner(System.in);

        System.out.printf(SET_TITLE, "Presto Simulator - Ashesh Dhakal"); // Setting the title

        // Creating an ArrayList
        ArrayList<PrestoCard> prestoCards = new ArrayList<>();
        prestoCards.add(new PrestoCard(5, "Ashesh"));
        prestoCards.add(new PrestoCard(15, "Lilly"));
        prestoCards.add(new PrestoCard(2, "Jimmy"));

        // Variables
        
        boolean running = true;// Will close the app when false
        
        String userCommand;// User command: quit, add, del, tap, topup
    
        String name;   // User name
        
        double price = 0;// Fare price
        
        boolean numeric;  // Numeric validation
        
        int index = 0;  // The user index

        do {
            // Starting with clearing the terminal
            System.out.println(CLEAR_TERMINAL);  

            // Printing the banner
            System.out.println(BANNER);

            // Printing the description
            System.out.println("Program that simulates Presto cards");

            // Displaying the number of current cards
            System.out.println("We currently have " + prestoCards.size() + " cards!");

            // Printing all the cards
            for (int count = 0; count < prestoCards.size(); count++) {

                // ID - NAME - BALANCE

                System.out.printf("%s - %s - $%.2f \n", count + 1, prestoCards.get(count).getName(),
                        prestoCards.get(count).getBalance());
            }

            // Asking for a user command

            System.out.print("\nEnter user command: ");

            userCommand = scanner.next();

            if (userCommand.equals("add")) {

                // Assigning the value of scanner.next() to the variable name

                name = scanner.next();

                // Converting string into a double
                try {
                    price = scanner.nextDouble();
                    numeric = true;
                } catch (Exception e) {
                    numeric = false;
                }

                // Error: price is not numeric

                if (!numeric)
                    System.out.println("Error - Invalid Price!");

                // When user input is valid, then add the card
                else
                    prestoCards.add(new PrestoCard(price, name));

            // If the user command is "del"
        } else if (userCommand.equals("del")) {

                // Assign the value of scanner.next() to the variable name
                name = scanner.next();
                
                // Search for the card by name and get its index
                int cardNameIndex = PrestoCard.searchName(prestoCards, name);
                
                // Check if the card was found or not
            if (cardNameIndex == -1) {
                    System.out.println("Card not found.");
            } else {
                    // If the card was found, remove it from the list
                    name = prestoCards.get(cardNameIndex).getName();
                    prestoCards.remove(cardNameIndex);
                    System.out.printf("Card '%s' has been removed.%n", name);
            }


        // If the user command is "tap"
        } else if (userCommand.equals("tap")) {

            // Assign the value of scanner.next() to the variable name
            name = scanner.next();

            // Search for the card by name and get its index
            int cardNameIndex = PrestoCard.searchName(prestoCards, name);

            // Check if the card was found or not
            if (cardNameIndex == -1) {
                System.out.println("Card not found.");
            } 
            else {
                // If the card was found, execute the tap function using the name
                name = prestoCards.get(cardNameIndex).getName();
                prestoCards.get(cardNameIndex).tap(FIXED_FARE);
                System.out.printf("Card '%s' has been tapped.%n", name);
            }


        // If the user command is "topup"

        } else if (userCommand.equals("topup")) {

        // assigning the value of scanner.next() to the variable name
        name = scanner.next();
        // finding the card index by the card name
        int cardNameIndex = PrestoCard.searchName(prestoCards, name);
        // converting the string into a double
        try {
            price = scanner.nextDouble();
            numeric = true;
        } catch (Exception e) {
            numeric = false;
        }

        // Converting from ID to index
        index--;

        // Error ID is not numeric OR out of bounds
        if (cardNameIndex == -1) {
            System.out.println("Card not found.");
        } else if (!numeric) {
            // error when entered price is not numeric OR out of bounds
            System.out.println("Error - Price please try again!");
        } else {
            // excuting the .topup cammand
            name = prestoCards.get(cardNameIndex).getName();
            prestoCards.get(cardNameIndex).topUp(price);
        }

        // If the user command is "quit"
        } else if (userCommand.equals("quit")) {
            running = false;

        // Invalid command
        } else {
            System.out.println("Invalid command!");
        }

        waitAsec(); // Wait for 1 second before clearing the screen again
    } while (running);

// Close the app

scanner.close(); 
}
}
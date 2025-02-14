
package cardGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardGame {

    private static ArrayList<Card> deckOfCards = new ArrayList<>();
    private static ArrayList<Card> playerCards = new ArrayList<>();

    public static void main(String[] args) {

        Scanner input = null;
        try {
            input = new Scanner(new File("cards.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            e.printStackTrace();
            return;
        }

        // Read the card data from file
        while (input.hasNext()) {
            String[] fields = input.nextLine().split(",");
            Card newCard = new Card(fields[0], fields[1].trim(),
                    Integer.parseInt(fields[2].trim()), fields[3]);
            deckOfCards.add(newCard);
        }
        input.close();

        shuffle();

        // Deal the player 5 cards
        for (int i = 0; i < 5; i++) {
            playerCards.add(deckOfCards.remove(0));
        }

        System.out.println("Your starting cards:");
        printPlayerCards();

        // New Feature: Allow user to draw a new card each round
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWould you like to draw a new card? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();

            if (response.equals("no")) {
                break;  // Exit loop when the user says "no"
            } else if (response.equals("yes")) {
                if (!deckOfCards.isEmpty()) {
                    Card newCard = deckOfCards.remove(0);
                    playerCards.add(newCard);
                    System.out.println("\nYou drew: " + newCard);
                    printPlayerCards();
                    System.out.println("Pairs found: " + checkFor2Kind());
                } else {
                    System.out.println("The deck is empty!");
                }
            } else {
                System.out.println("Invalid input. Type 'yes' or 'no'.");
            }
        }

        // Close scanner after exiting the loop
        scanner.close();
        System.out.println("Game Over!");
        scanner.close();
    }

    public static void shuffle() {
        Collections.shuffle(deckOfCards);
    }

    public static void printPlayerCards() {
        System.out.println("\nYour cards:");
        for (Card c : playerCards) {
            System.out.println(c);
        }
    }

    public static boolean checkFor2Kind() {
        for (int i = 0; i < playerCards.size(); i++) {
            for (int j = i + 1; j < playerCards.size(); j++) {
                if (playerCards.get(i).equals(playerCards.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }
}
package Module3;

import java.util.Scanner;
import java.io.*;

public class HashTablesChainingListHeadsTest {
    public static void main(String[] args) {
        char again;
        do {
            // Initialize the total word count
            int wordCount = 0;
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Hash Table Test\n\n");
            System.out.println("Enter size of hash table: ");
            int size = keyboard.nextInt();
            // validate to make sure the size is not too big.
            while (size > 3500){
                System.out.println("Size is too big. Choose a smaller number: ");
                size = keyboard.nextInt();
            }
            // Create a new hash table
            HashTable ht = new HashTable(size);
            System.out.println("Enter the hash function you'd like to use: (naive OR sophisticated) ");
            keyboard.nextLine();
            String hashFunction = keyboard.nextLine();
            while (!hashFunction.equalsIgnoreCase("naive") && !hashFunction.equalsIgnoreCase("sophisticated")){
                System.out.println("Invalid entry. Please enter 'naive' or 'sophisticated': ");
                hashFunction = keyboard.nextLine();
            }


            // Read words from a text file and insert into hash table
            try {
                File file = new File("ForbiddenFlight");
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNext()) {
                    wordCount++;
                    String word = fileScanner.next().toLowerCase(); // Convert to lowercase for case-insensitivity
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters from words
                    ht.insert(word, ht.get(word, hashFunction) + 1, hashFunction); // Increment count if word already exists
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }

            //print menu as long as the user wants to repeat
            char ch;
            do {
                System.out.println("\nHash Table Operations\n");
                System.out.println("1. View total word count and word count for a particular word");
                System.out.println("2. View words in descending order according to word count");
                System.out.println("3. View report on the internal structure of the hash table");
                System.out.println("4. Print hash table");
                System.out.println("5. Exit");

                //get the users choice
                int choice = keyboard.nextInt();
                //call the appropriate function based off users choice
                switch (choice) {
                    case 1:
                        System.out.println("Enter word:");
                        String word = keyboard.next().toLowerCase();
                        System.out.println("Word count: " + wordCount);
                        ht.ViewWordDetails(word, hashFunction);
                        break;
                    case 2:
                        ht.printWordsDescending();
                        break;
                    case 3:
                        ht.printReport();
                        break;
                    case 4:
                        ht.printHashTable();
                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Wrong Entry. Try again.\n");
                        break;
                }

                //ask the user if they want to see menu again
                System.out.println("\nDo you want to continue (Type y or n)");
                System.out.println();
                ch = keyboard.next().charAt(0);
            } while (ch == 'Y' || ch == 'y');
            //ask the user if they want to start again or quit
            System.out.println("\nDo you want to repeat and start over? (Type y or n)");
            System.out.println();
            again = keyboard.next().charAt(0);
        }while (Character.toLowerCase(again) == 'y');

    }
}


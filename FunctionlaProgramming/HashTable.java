package Module9HW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import Module3.MapEntry1;

public class HashTable implements MapInterface {
    private int TABLE_SIZE;
    private int size;
    private MapEntry1[] table;

    // Constructor to initialize the hash table
    public HashTable(int ts) {
        size = 0;
        TABLE_SIZE = ts;
        table = new MapEntry1[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }

    // Method to get the size of the hash table
    @Override
    public int getSize() {
        return size;
    }

    // Method to insert a key-value pair into the hash table
    public void insert(String key, int value, String hashFunctionName) {
        Function<String, Integer> selectedHashFunction = getHashFunction(hashFunctionName);
        int hash = selectedHashFunction.apply(key);
        if (isEmpty(hash)) {
            table[hash] = new MapEntry1(key, value);
            System.out.println("Inserted key: " + key + ", value: " + value + " at slot: " + hash);
        } else {
            MapEntry1 entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key)) {
                entry.value = value;
                System.out.println("Updated value of key: " + key + " to: " + value);
            } else {
                entry.next = new MapEntry1(key, value);
                System.out.println("Inserted key: " + key + ", value: " + value + " at slot: " + hash);
            }
        }
        size++;
        reportInsertion(key, value, hash); // show insertion operation
    }

    // Method to get the value associated with a key from the hash table
    @Override
    public int get(String key, String hashFunctionName) {
        Function<String, Integer> selectedHashFunction = getHashFunction(hashFunctionName);
        int hash = selectedHashFunction.apply(key);
        if (isEmpty(hash)) {
            System.out.println("Key: " + key + " not found in slot: " + hash);
            return 0;
        } else {
            MapEntry1 entry = table[hash];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry == null) {
                System.out.println("Key: " + key + " not found in slot: " + hash);
                return 0;
            } else {
                System.out.println("Value " + entry.value + " found for key: " + key + " in slot: " + hash);
                return entry.value;
            }
        }
    }

    @Override
    public boolean isEmpty(int hash) {
        return table[hash] == null;
    }

    // Method to report the insertion operation
    public void reportInsertion(String key, int value, int hash) {
        System.out.println("Inserted key: " + key + ", value: " + value + " at slot: " + hash);
    }

    // Method to print the hash table
    public void printHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            MapEntry1 entry = table[i];
            while (entry != null) {
                System.out.print(entry.value + " ");
                entry = entry.next;
            }
        }
    }

    private Function<String, Integer> getHashFunction(String hashFunctionName) {
        
        Map<String, Function<String, Integer>> hashFunctions = Map.of(
            "naive", k -> {
                // Naive hash function implementation
                int sum = 0;
                for (char ch : k.toCharArray()) {
                    sum += (int) ch;
                }
                return sum % TABLE_SIZE;
            },
            "sophisticated", this::sophisticatedHash // Using method reference
        );

        // Lookup and return the selected hash function based on its name
        return hashFunctions.get(hashFunctionName);
    }

    // Define the sophisticated hash function as a separate method
    private int sophisticatedHash(String k) {
        final int TABLE_SIZE = 128;
        int hash = 0;
        for (int i = 0; i < k.length(); i++) {
            hash = (hash * 31 + k.charAt(i)) % TABLE_SIZE;
        }
        return hash;
    }

 // Method to view word count and linked list length for a particular word
    public void ViewWordDetails(String word, String hashFunctionName) {
        if (word == null || word.isEmpty()) {
            System.out.println("Invalid word. Please provide a non-empty word.");
            return;
        }

        Function<String, Integer> selectedHashFunction = getHashFunction(hashFunctionName);
        int hash = selectedHashFunction.apply(word);

        if (table[hash] == null) {
            System.out.println("Word '" + word + "' not found.");
            return;
        }

        MapEntry1 entry = table[hash];
        int wordCount = 0;
        int linkedListLength = 0;

        while (entry != null) {
            linkedListLength++; // Increment linked list length for each node
            if (entry.key.equalsIgnoreCase(word)) {
                wordCount = entry.value; // Retrieve word count if word is found
                break;
            }
            entry = entry.next;
        }

        // Display word count and linked list length to the user
        if (wordCount > 0) {
            System.out.println("Word: " + word);
            System.out.println("Word Count: " + wordCount);
            System.out.println("Length of Linked List: " + linkedListLength);
        } else {
            System.out.println("Word '" + word + "' not found.");
        }
    }

    //Method to print words in descending order of count
    public void printWordsDescending() {
        Map<String, Integer> wordCountMap = new HashMap<>();
        // Populate word count map
        for (MapEntry1 entry : table) {
            while (entry != null) {
                wordCountMap.put(entry.key, entry.value);
                entry = entry.next;
            }
        }

        //Sort the map by value (word count) in descending order
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(wordCountMap.entrySet());
        entries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        //Print words in descending order of count
        System.out.println("Words in descending order of count:");
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        }
  //Method to print a report on the internal structure of the hash table
    public void printReport() {
        System.out.println("Report on the internal structure of the hash table:");
        System.out.println("Size of the array: " + TABLE_SIZE);
        System.out.println("Number of unused array slots: " + (getUnusedSlots()));
        System.out.println("Length of the linked list for each hash code:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            int listLength = 0;
            MapEntry1 entry = table[i];
            while (entry != null) {
                listLength++;
                entry = entry.next;
            }
            System.out.println("Bucket " + (i + 1) + ": " + listLength);
        }
    }
    //Method to calculate the number of unused slots in the hash table
    public int getUnusedSlots() {
        int filledSlots = 0;
        for (MapEntry1 entry : table) {
            if (entry != null) {
                filledSlots++;
            }
        }
        return TABLE_SIZE - filledSlots;
    }

   

	@Override
	public Iterator iterator() {
		
		return null;
	}

	@Override
	public boolean isFull() {
		return false;
	}
}

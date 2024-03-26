package Module3;

import java.util.*;

public class HashTable  implements MapInterface {
    private int TABLE_SIZE;
    private int size;
    private MapEntry1[] table;
    int counter;

    //Constructor to initialize the hash table
    public HashTable(int ts) {
        size = 0;
        counter = 0;
        TABLE_SIZE = ts;
        table = new MapEntry1[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
        	
            table[i] = null;
       
    }

    //Method to get the size of the hash table
    @Override
    public int getSize() {
        return size;
    }
    
    //Method to insert a key-value pair into the hash table
    public void insert(String key, int value, String hashFunction) {
        int hash;
        //Choose the appropriate hash function based on the input parameter
        if (hashFunction.equalsIgnoreCase("naive")) {
            hash = NaiveHash(key);
        } else {
            hash = sophisticated(key);
        }
        //If the slot is empty, create a new entry
        
        if (isEmpty(hash)) {
            table[hash] = new MapEntry1(key, value);
            System.out.println("Inserted key: " + key + ", value: " + value + " at slot: " + hash);
        }
        else {
            //If the slot is occupied, traverse the linked list to find the appropriate position
            MapEntry1 entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key)) {
                entry.value = value;
                System.out.println("Updated value of key: " + key + " to: " + value);
               
            }
            else {
                entry.next = new MapEntry1(key, value);
                System.out.println("Inserted key: " + key + ", value: " + value + " at slot: " + hash);
               
            }
           
            
            }
        //Increment the size of the hash table after insertion
        size++;
        reportInsertion(key, value, hash); //show insertion operation

    }
    @Override
    public boolean isEmpty(int hash) {
        return table[hash] == null;
    }

	//Method to report the insertion operation
    public void reportInsertion(String key, int value, int hash) {
        System.out.println("Inserted key: " + key + ", value: " + value + " at slot: " + hash);
    }

    //Method to get the value associated with a key from the hash table
    @Override
    public int get(String key, String hashFunction) {
        int hash;
        //Choose the appropriate hash function based on the input parameter
        if (hashFunction.equalsIgnoreCase("naive")){
            hash = NaiveHash(key);
        }
        else {
            hash = sophisticated(key);

        }
        //Traverse the linked list to find the key
        if (isEmpty(hash)) {
            System.out.println("Key: " + key + " not found in slot: " + hash);
            return 0;
        }
        else {
            MapEntry1 entry = table[hash];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            //Return the value if the key is found, otherwise return 0
            if (entry == null) {
                System.out.println("Key: " + key + " not found in slot: " + hash);
                return 0;
            } else {
                System.out.println("Value " + entry.value + " found for key: " + key + " in slot: " + hash);
                return entry.value;
            }
        }
    }

    //Method to print the hash table
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
    //method to calculate naive approach.
    public int NaiveHash(String key) {
        int sum = 0;
        for (char ch : key.toCharArray()) {
            sum += (int) ch;
        }
        return sum % TABLE_SIZE;
    }
    public int sophisticated(String key) {
        final int TABLE_SIZE = 128;
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash * 31 + key.charAt(i)) % TABLE_SIZE;
        }
        return hash;
    }

    //Method to view word count and linked list length for a particular word
    public void ViewWordDetails(String word, String hashFunction) {
        if (word == null || word.isEmpty()) {
            System.out.println("Invalid word. Please provide a non-empty word.");
            return;
        }

        int hash;
        //Choose the appropriate hash function based on the input parameter
        if (hashFunction.equalsIgnoreCase("naive")){
            hash = NaiveHash(word); //Calculate the hash for the given word
        }
        else {
            hash = sophisticated(word); //Calculate the hash for the given word
        }

        if (table[hash] == null) {
            System.out.println("Word '" + word + "' not found.");
            return;
        }

        //Search the linked list at the hashed index for the word
        MapEntry1 entry = table[hash];
        int wordCount = 0;
        int linkedListLength = 0;

        while (entry != null) {
            linkedListLength++; //Increment linked list length for each node
            if (entry.key.equalsIgnoreCase(word)) {
                wordCount = entry.value; //Retrieve word count if word is found
                break;
            }
            entry = entry.next;
        }

        //Display word count and linked list length to the user
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
//@override
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

    //Custom iterator implementation for iterating over linked entries
    private class HashTableIterator implements Iterator<MapEntry1> {
        private int currentIndex = 0;
        private MapEntry1 currentEntry = null;

        @Override
        public boolean hasNext() {
            while (currentIndex < TABLE_SIZE) {
                if (table[currentIndex] != null) {
                    currentEntry = table[currentIndex];
                    return true;
                }
                currentIndex++;
            }
            return false;
        }

        @Override
        public MapEntry1 next() {
            if (hasNext()) {
                MapEntry1 entry = currentEntry;
                currentEntry = currentEntry.next;
                return entry;
            }
            throw new NoSuchElementException();
        }
    }

  
    public Iterator<MapEntry1> iterator() {
        return new HashTableIterator();
    }
    
    
    public boolean isFull() {
        return false; // Hash table never gets full in this implementation
    }


}


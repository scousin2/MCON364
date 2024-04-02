package Module9HW;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HashTableTest {
    private HashTable table;

    @BeforeEach
    public void setUp() {
        // Initialize the HashTable with a table size of 128
        table = new HashTable(128);
    }
    @Test
    public void testGetUnusedSlotsWithEmptyTable() {
        // Ensure the table is empty initially
        assertEquals(128, table.getUnusedSlots());
    }
    @Test
    public void testGetUnusedSlotsWithFilledTable() {
        // Insert some key-value pairs into the table
        table.insert("key1", 10, "naive");
        table.insert("key2", 20, "naive");

        // Calculate the expected number of unused slots
        int expectedUnusedSlots = 128 - 2; // because 2 slots are filled
        //correct number of slots expected
        assertEquals(expectedUnusedSlots, table.getUnusedSlots());
    }


    @Test
    public void testInsertAndGet() {
        // Insert key-value pairs into the table
        table.insert("key1", 10, "naive");
        table.insert("key2", 20, "naive");

        // Retrieve the values for the keys
        int value1 = table.get("key1", "naive");
        int value2 = table.get("key2", "naive");

        //  correct values are retrieved
        assertEquals(10, value1);
        assertEquals(20, value2);
    }

    @Test
    public void testPrintHashTable() {
        // Insert key-value pairs into the table
        table.insert("key1", 10, "naive");
        table.insert("key2", 20, "naive");

        // Print the hash table
        table.printHashTable();
        
    }

    @Test
    public void testPrintWordsDescending() {
        // Insert key-value pairs into the table
        table.insert("word1", 5, "naive");
        table.insert("word2", 10, "naive");
        table.insert("word3", 15, "naive");

        // Print words in descending order of count
        table.printWordsDescending();
        
    }

}

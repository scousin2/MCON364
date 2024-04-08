package ExtraCredit;
import java.io.*;
import java.util.*;

public class AmazonOrderProcessor {
    private static final String FROM_AMAZON_FILE_PREFIX = "fromAmazon";
    private static final String TO_AMAZON_FILE_PREFIX = "toAmazon";
    private static final String JSON_EXTENSION = ".json";
    private static final String INVENTORY_FILE = "inventory.json";

    private static Queue<Order> ordersQueue = new PriorityQueue<>();
    private static Map<String, Product> inventory = new LinkedHashMap<>();

    public static void main(String[] args) {
        initializeInventory();
        int round = 1;
        while (!ordersQueue.isEmpty()) {
            processOrders(round);
            updateResponse(round);
            round++;
        }
        System.out.println("Business is closed. All stock depleted.");
    }

    private static void initializeInventory() {
        // Initialize inventory with sample products
        inventory.put("Nail Polish", new Product("Nail Polish", "Assorted nail polish colors", 7.99, 50));
        inventory.put("Eyeshadow Palette", new Product("Eyeshadow Palette", "15-shade eyeshadow palette", 19.99, 30));
        inventory.put("Blush", new Product("Blush", "Peach blush for a natural glow", 12.49, 40));
    }

    private static void processOrders(int round) {
        try (FileReader fileReader = new FileReader(FROM_AMAZON_FILE_PREFIX + round + JSON_EXTENSION);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            // Read orders from Amazon
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            String jsonContent = stringBuilder.toString();
            JSONArray ordersArray = new JSONArray(jsonContent);

            // Process each order
            for (int i = 0; i < ordersArray.length(); i++) {
                JSONObject orderObj = ordersArray.getJSONObject(i);
                String productName = orderObj.getString("product");
                int quantity = orderObj.getInt("quantity");

                // Process the order and update inventory
                if (inventory.containsKey(productName)) {
                    Order newOrder = new Order(productName, quantity);
                    ordersQueue.add(newOrder);
                } else {
                    System.out.println("Product " + productName + " is not available.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateResponse(int round) {
        JSONArray response = new JSONArray();
        for (Product product : inventory.values()) {
            JSONObject productObj = new JSONObject();
            productObj.put("name", product.getName());
            productObj.put("description", product.getDescription());
            productObj.put("price", product.getPrice());
            productObj.put("stock", product.getStock() > 0 ? product.getStock() : "No Stock");
            response.put(productObj);
        }

        // Write response to toAmazon.json file
        try (FileWriter file = new FileWriter(TO_AMAZON_FILE_PREFIX + round + JSON_EXTENSION)) {
            file.write(response.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Product {
        private String name;
        private String description;
        private double price;
        private int stock;

        public Product(String name, String description, double price, int stock) {
            this.name = name;
            this.description = description;
            this.price = price;
            this.stock = stock;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        public int getStock() {
            return stock;
        }

        public void reduceStock(int quantity) {
            this.stock -= quantity;
        }
    }

    private static class Order implements Comparable<Order> {
        private String productName;
        private int quantity;

        public Order(String productName, int quantity) {
            this.productName = productName;
            this.quantity = quantity;
        }

        @Override
        public int compareTo(Order o) {
            return Integer.compare(this.quantity, o.quantity);
        }
    }
}

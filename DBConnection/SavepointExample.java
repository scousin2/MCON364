package testDBConnection;

import java.sql.*;
import java.util.List;

public class SavepointExample {

    private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=PREMIERECO;integratedSecurity=true;encrypt=true;TrustServerCertificate=true";

    public static void performSavepointExample() {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL)) {
            connection.setAutoCommit(false);
            
            try {
                // savepoint created
                Savepoint savepoint = connection.setSavepoint("Savepoint1");
             
    			connection.commit();

                try (Statement statement = connection.createStatement()) {
                    // performing the action
                	//this actually changes teh names to sara whoever lives in fl if you take away the rollback.
                    statement.executeUpdate("UPDATE EMPLOYEE SET FNAME = 'SARA' WHERE EMP_STATE= 'FL' ");
                   
                    boolean rollbackRequired = true;
                    
                    if (rollbackRequired) {
                        // Rollback to the savepoint
                        connection.rollback(savepoint);
                        System.out.println("Rolled back to savepoint: " + savepoint.getSavepointName());
                    } else {
                        // Commit the transaction
                        connection.commit();
                        System.out.println("Transaction committed successfully.");
                    }
                } catch (SQLException e) {
                    System.out.println("Error during database operation: " + e.getMessage());
                    connection.rollback(savepoint);
                    System.out.println("Rolled back to savepoint: " + savepoint.getSavepointName());
                }
            } catch (SQLException e) {
                System.out.println("Error while setting savepoint: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error establishing connection: " + e.getMessage());
        }
    }
}


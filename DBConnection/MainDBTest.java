package testDBConnection;

import java.sql.Connection;
import testDBConnection.Query;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MainDBTest {

	public static void main(String[] args) {
		//connection of the db
	 final String DATABASE_URL =
			 "jdbc:sqlserver://localhost;" +
	        "databaseName=PREMIERECO;integratedSecurity=true;encrypt=true;TrustServerCertificate=true";
	 Connection dbConnection ;
	 try {
		 dbConnection = DriverManager.getConnection(DATABASE_URL);
		 dbConnection.setAutoCommit(false);
		 System.out.println("connected successfully");
		 dbConnection.close(); 
		 System.out.println("connection closed");
		 
	 }
	 
	 catch (SQLException sqlE) {
		 System.out.println("encountered a problem " + sqlE.getMessage());
	 }
     List<String[]> results = Query.readAllData();
  
     if (results.isEmpty()) {
         System.out.println("No data found.");
     } else {
    	 System.out.println();
    	 System.out.println("printing the data in employee table");
         
         for (int i = 0; i < results.get(0).length; i++) {
             System.out.print(results.get(0)[i] + "\t");
         }
         System.out.println(); 

         // Print the data
         for (int i = 1; i < results.size(); i++) {
             for (int j = 0; j < results.get(i).length; j++) {
                 System.out.print(results.get(i)[j] + "\t");
             }
             System.out.println(); 
         }
     }
     System.out.println();
     System.out.println("prinitng the table info");
     System.out.println();
     DatabaseQuery.printTableStructureAndData();
     System.out.println();
     System.out.println("employees who live in florida(using prepared statement-bind )");
     PreparedStatementDemo.executePreparedStatement("FL");
     System.out.println("employees who live in ny (using prepared statement-set different value)");
     PreparedStatementDemo.executePreparedStatement("NY");
     SavepointExample.performSavepointExample();


	}

}

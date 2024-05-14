package testDBConnection;
import java.sql.*;

public class DatabaseQuery {

    private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=PREMIERECO;integratedSecurity=true;encrypt=true;TrustServerCertificate=true";

    public static void printTableStructureAndData() {
        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            DatabaseMetaData metaData = connection.getMetaData();
            Statement statement = connection.createStatement();

            ResultSet tables = metaData.getTables(null, null, null, new String[]{"TABLE"});
            ////looping through the everything.
            while (tables.next()) {
            	 String tableName = tables.getString("TABLE_NAME");
                
                if (tableName.startsWith("trace_")) {
                    continue;
                }
               
                System.out.println("Table: " + tableName);

                ResultSet columns = metaData.getColumns(null, null, tableName, null);
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String dataType = columns.getString("TYPE_NAME");
                    System.out.println("\tColumn: " + columnName + ", Data Type: " + dataType);
                }
                columns.close();

                ResultSet data = statement.executeQuery("SELECT * FROM " + tableName);
                ResultSetMetaData rsMetaData = data.getMetaData();
                int columnCount = rsMetaData.getColumnCount();
                while (data.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(data.getString(i) + "\t");
                    }
                    System.out.println();
                }
                data.close();
            }
            tables.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package testDBConnection;

import java.sql.*;

public class PreparedStatementDemo {
    private static final String DATABASE_URL = "jdbc:sqlserver://localhost;databaseName=PREMIERECO;integratedSecurity=true;encrypt=true;TrustServerCertificate=true";

    public static void executePreparedStatement(String parameterValue) {
        try {
        	//createing the prepared statemnet.
            Connection connection = DriverManager.getConnection(DATABASE_URL);
            String sql = "SELECT * FROM EMPLOYEE WHERE EMP_STATE = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, parameterValue);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	
                System.out.println(resultSet.getString("FNAME"));
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

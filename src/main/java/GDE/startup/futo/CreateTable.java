
package kferi.Futoverseny;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    
    public static void main(String dataBaseName) {
        String jdbcUrl = "jdbc:h2:~/test"; // JDBC URL for H2 database
        String jdbcUsername = "sa"; // Database username
        String jdbcPassword = ""; // Database password (if any)

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS "+dataBaseName+" ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255),"
                    + "age INT,"
                    + "gender INT)";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

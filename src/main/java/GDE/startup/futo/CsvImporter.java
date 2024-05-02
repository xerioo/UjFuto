
package kferi.Futoverseny;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CsvImporter {

    public static void main(String csvFile, String dataBaseName) {
        String jdbcUrl = "jdbc:h2:~/test"; // JDBC URL for H2 database
        String jdbcUsername = "sa"; // Database username
        String jdbcPassword = ""; // Database password (if any)

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
             BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            String sql = "INSERT INTO "+dataBaseName+" (name, age, gender) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Skip header line if needed
            // br.readLine();

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                int gender = Integer.parseInt(data[2]);

                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, age);
                preparedStatement.setInt(3, gender);
                preparedStatement.executeUpdate();
            }

        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

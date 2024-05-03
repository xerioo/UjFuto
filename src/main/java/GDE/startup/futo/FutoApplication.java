package GDE.startup.futo;

import static GDE.startup.futo.CsvImporter.jdbcPassword;
import static GDE.startup.futo.CsvImporter.jdbcUrl;
import static GDE.startup.futo.CsvImporter.jdbcUsername;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FutoApplication {

        public static ArrayList<Result> results = new ArrayList<>();
        public static ArrayList<Runner> runners = new ArrayList<>();
        public static ArrayList<Competition> competitions = new ArrayList<>();
            
	public static void main(String[] args) {
		//SpringApplication.run(FutoApplication.class, args);
            CsvImporter.fillDatabase();
            CsvImporter.loadData();
	}
        
      
        

}

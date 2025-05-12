package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnUtil {

    public static Connection getConnection() {
        // Load db.properties from the classpath (src/main/resources)
        try (InputStream inputStream = DBConnUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (inputStream == null) {
                throw new RuntimeException("Unable to find db.properties");
            }

            // Load properties from the file
            Properties props = new Properties();
            props.load(inputStream);

            // Get connection details from properties
            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            // Establish connection
            return DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

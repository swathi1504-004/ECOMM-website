package util;

import java.sql.Connection;

public class DBTest {
    public static void main(String[] args) {
        Connection conn = DBConnUtil.getConnection();  // ✅ Correct usage
        if (conn != null) {
            System.out.println("✅ Database connection successful!");
        } else {
            System.out.println("❌ Failed to connect to the database.");
        }
    }
}

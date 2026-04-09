
import java.sql.*;

public class DBConnection {

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/library_db","root","virat.kohli@18");

        } catch (Exception e) {
            e.printStackTrace();
        }

      throw new RuntimeException("Unable to connect to database.");
    }
}
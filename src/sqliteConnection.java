import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sqliteConnection {
    public static Connection connector() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("studentregistration.db");
            return conn;
        } catch (Exception e) {
            return null;

        }
    }
}

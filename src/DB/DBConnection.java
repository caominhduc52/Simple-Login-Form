package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DBConstant.JDBC_DRIVER);
            connection = DriverManager.getConnection(DBConstant.JDBC_URL, DBConstant.USERNAME, DBConstant.PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlService {

    private String dbHost;
    private int dbPort;
    private String user;
    private String password;
    private String dbName;

    private Connection connection;

    public MySqlService() {
        dbHost = "localhost";
        user = "root";
        password = "";
        dbPort = 3306;
        dbName = "Product";
        connection = null;
    }

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName,
                    user,
                    password
            );
            System.out.println("MySQL is connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Statement getStatement() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }
}
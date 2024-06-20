import java.sql.*;

public class FetchProducts {
    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String JDBC_USER = "your_username";
    private static final String JDBC_PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Connect to the database
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 2. Create a statement object
            stmt = conn.createStatement();

            // 3. Execute a query to fetch all products
            String sql = "SELECT id, name, price_per_unit, active_for_sell FROM Product";
            rs = stmt.executeQuery(sql);

            // 4. Iterate through the result set and print each product
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double pricePerUnit = rs.getDouble("price_per_unit");
                boolean activeForSell = rs.getBoolean("active_for_sell");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price per Unit: " + pricePerUnit);
                System.out.println("Active for Sell: " + activeForSell);
                System.out.println("-----------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close all resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

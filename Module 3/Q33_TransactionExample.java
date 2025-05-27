import java.sql.*;

public class Q33_TransactionExample {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public static void transferMoney(int fromAccountId, int toAccountId, double amount) throws SQLException {
        Connection conn = DriverManager.getConnection(URL, USER, PASS);
        try {
            conn.setAutoCommit(false);

            String debitSql = "UPDATE accounts SET balance = balance - ? WHERE id = ?";
            try (PreparedStatement debitStmt = conn.prepareStatement(debitSql)) {
                debitStmt.setDouble(1, amount);
                debitStmt.setInt(2, fromAccountId);
                debitStmt.executeUpdate();
            }

            String creditSql = "UPDATE accounts SET balance = balance + ? WHERE id = ?";
            try (PreparedStatement creditStmt = conn.prepareStatement(creditSql)) {
                creditStmt.setDouble(1, amount);
                creditStmt.setInt(2, toAccountId);
                creditStmt.executeUpdate();
            }

            conn.commit();
            System.out.println("Transfer successful");
        } catch (SQLException e) {
            conn.rollback();
            System.out.println("Transfer failed, rolled back");
            throw e;
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    public static void main(String[] args) {
        try {
            transferMoney(1, 2, 100.0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
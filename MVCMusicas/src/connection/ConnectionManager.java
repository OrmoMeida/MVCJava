package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ConnectionManager {
    private Connection connection;
    private static ConnectionManager connectionManager;

    private ConnectionManager(String url, String user, String password) {
        try {
            this.connection = DriverManager.getConnection(url, user, password);
            disableSafeMode();
        } catch (SQLException e) {
            System.out.println("Erro nas credenciais." + e.getMessage());
            java.lang.System.exit(1);
        }
    }

    private ConnectionManager() {
        this("jdbc:mysql://143.106.241.3:3306/cl201290", "cl201290", "cl*24032006");
    }

    public static Connection getConnection() {
        if (connectionManager == null)
            connectionManager = new ConnectionManager();

        return connectionManager.connection;
    }

    private void disableSafeMode() throws SQLException {
        PreparedStatement smt = connection.prepareStatement("SET SQL_SAFE_UPDATES = 0");
        
        smt.execute();
        smt.close();
    }
}

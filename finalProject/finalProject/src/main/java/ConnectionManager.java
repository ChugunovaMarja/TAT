import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Maria on 03.12.2016.
 */
public class ConnectionManager {

    DatabaseConfig config = DatabaseConfig.getConfig();

    private static ConnectionManager connectionManager;

    public static ConnectionManager getConnectionManager() {
        if (connectionManager == null) {
            return connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    private ConnectionManager() {
    }


    public Connection openConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            // Handle SQLException if such has been thrown
        }
        return connection;
    }


    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle SQLException if such has been thrown
        }
    }
}

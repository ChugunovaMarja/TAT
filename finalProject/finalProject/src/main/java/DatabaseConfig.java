/**
 * Created by Maria on 03.12.2016.
 */
public class DatabaseConfig {

    private static final DatabaseConfig config = new DatabaseConfig();

    private final String driverClassName="jdbc";
    private final String url="jdbc:mysql://localhost:8889/wordpress";
    private final String username="root";
    private final String password="root";

    public static DatabaseConfig getConfig() {
        return config;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

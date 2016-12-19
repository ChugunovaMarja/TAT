import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Maria on 18.12.2016.
 */
public class DbWorker {

    private static final String[] DELETE_QUERY = new String[]{
            "DELETE FROM ",
            " WHERE user_login = ? "};
    private static final String[] INSERT_QUERY = new String[]{
            "INSERT INTO ",
            " (`user_login`, `user_pass`)" +
                    " VALUES (?, MD5(?))"};
    private static final String[] SELECT_COUNT_QUERY = new String[]{
            "SELECT COUNT(*) FROM "
    };

    private static final String USERS_DATABASE_NAME = "wp_users";
    private static DbWorker instance;
    private Connection connection;

    public static DbWorker getInstance() {
        if (instance == null) {
            instance = new DbWorker();
        }
        return instance;
    }

    public void addUserToDb(String userName, String password) {
        updateData(INSERT_QUERY[0] + USERS_DATABASE_NAME + INSERT_QUERY[1],
                new String[]{
                        userName,
                        password
                });
    }

    public void deleteUserFromDb(String userName) {
        updateData(DELETE_QUERY[0] + USERS_DATABASE_NAME + DELETE_QUERY[1],
                new String[]{userName});
    }

    private void updateData(String query, String[] params) {
        connection = ConnectionManager.getConnectionManager().openConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            for (int i = 0; i < params.length; ++i) {
                statement.setString(i + 1, params[i]);
            }
            statement.execute();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConnectionManager.getConnectionManager().closeConnection(connection);
        }
    }

    public int getNumberOfComments() {
        connection = ConnectionManager.getConnectionManager().openConnection();
        PreparedStatement statement = null;
        int number = 0;
        try {
            statement = connection.prepareStatement(
                    "SELECT COUNT(*) FROM wordpress.wp_comments");
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            number = resultSet.getInt(1);

        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        } finally {
            ConnectionManager.getConnectionManager().closeConnection(connection);
        }
        return number;
    }
}

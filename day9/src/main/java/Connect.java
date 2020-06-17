import java.sql.*;

public class Connect {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";

    private static final String URL_NAME = "root";
    private static final String PASSWORD = "root";

    public Connection connectDB() throws SQLException {
        Connection connection = DriverManager.getConnection (URL, URL_NAME, PASSWORD);
        return connection;
    }

    public PreparedStatement statement(String query) throws SQLException {
        PreparedStatement statement = connectDB ().prepareStatement (query);
        return statement;
    }

    public ResultSet resultSet(String query) throws SQLException {
        Statement statement = connectDB ().createStatement ();
        ResultSet resultSet = statement.executeQuery (query);
        return resultSet;
    }
}

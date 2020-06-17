import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Operation {
    static Connect connect = new Connect ();
    static Query query = new Query ();
    static Generator generator = new Generator ();

    public void dropTable() throws SQLException {
        connect.statement (Query.DROP_TABLE).executeUpdate ();
    }

    public void createTable() throws SQLException {
        connect.statement (Query.CREATE_TABLE).executeUpdate ();
    }

    public void insertUsers() throws SQLException {
        PreparedStatement statement = connect.statement (query.INSERT_USERS);
        for (int i = 0; i < 10; i++) {
            statement.setString (1, generator.loginGenerator ());
            statement.setString (2, generator.pwdGenerator ());
            statement.executeUpdate ();
        }
    }

    public void selectUsers(String query) {
        List<User> users = new ArrayList<> ();
        try {
            ResultSet resultSet = connect.resultSet (query);
            while (resultSet.next ()) {
                users.add (new User (resultSet.getInt (1),
                        resultSet.getString (2),
                        resultSet.getString (3)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace ();
        }
        users.forEach (user -> System.out.println (user.toString ()));
    }
}

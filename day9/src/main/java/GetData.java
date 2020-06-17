

import java.sql.*;

public class GetData {

    public static void main(String[] args) throws SQLException {
        Operation operation = new Operation ();
        Query query = new Query ();
        operation.dropTable ();
        operation.createTable ();
        operation.insertUsers ();
        operation.selectUsers (query.SELECT_USERS);
    }
}

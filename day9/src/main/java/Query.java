public class Query {
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS users";
    public static final String CREATE_TABLE = "CREATE TABLE users (\n" +
            " user_ID int NOT NULL AUTO_INCREMENT,\n" +
            " user_login varchar(255),\n" +
            " user_password char(40),\n" +
            " primary key (user_ID))";
    public static final String INSERT_USERS = "INSERT INTO users (user_login, user_password) VALUES (?, ?)";
    public static final String SELECT_USERS = "SELECT * FROM users";
}

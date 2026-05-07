import java.sql.*;

public class DatabaseConnection {
    Connection connection = null;
    WriteData writeData = new WriteData();

    private static String dbURL = "jdbc:mysql://localhost:3306/gamestop";
    private static String username = "root";
    private static String password = "ahmed_bekir0405";

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String newdbURL) {
        this.dbURL = newdbURL;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String newusername) {
        this.username = newusername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newpassword) {
        this.password = newpassword;
    }
}

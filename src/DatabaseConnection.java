import java.sql.*;

public class DatabaseConnection {
    Connection connection = null;
    WriteData writeData = new WriteData();

    private static String dbURL = "YOUR DATABSE URL";
    private static String username = "YOUR DATABASE USERNAME";
    private static String password = "YOUR DATABASE PASSWORD";

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

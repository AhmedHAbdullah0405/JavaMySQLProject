import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class OrdersDAO extends DatabaseConnection{
    DatabaseConnection databaseConnection = new DatabaseConnection();

    void selectOrders(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");

            while (resultSet.next()){
                System.out.println("OrderID: " + resultSet.getInt("orderID") + " \n"
                        + "First name: " + resultSet.getString("customerFirstName") + " \n"
                        + "Last Name: " + resultSet.getString("customerLastName") + "\n"
                        + "Game name: " + resultSet.getString("gameName") + " \n"
                        + "GameID: " + resultSet.getInt("gameID") + " \n"
                        + "Purchase Date: " + resultSet.getString("purchaseDate") + " \n"
                        + "Returned: " + resultSet.getBoolean("returned"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to load data from table 'orders' ");
        }
    }

    void createOrders(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            String createSQL = "INSERT into orders(orderID, customerFirstName, customerLastName, gameName, gameID, purchaseDate, returned) " +
                    "values (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(createSQL);

            writeData.writeDataIntoOrders(preparedStatement);
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " rows affected");
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Couldn't insert data to 'orders'");
        }
    }

    void updateOrders(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            String updateSQL = "UPDATE orders set customerFirstName = ?, customerLastname = ?, gameName = ?, purchaseDate = ?, returned = ?, gameID = ? WHERE orderID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            writeData.updateDataFromOrders(preparedStatement);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println(updatedRows + " rows affected");
            }else  {
                System.out.println("No orders with matching inputted ID");
            }

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to update data from table 'orders' ");
            e.printStackTrace();
        }
    }

    void deleteOrders(){
        try {
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            String deleteSQL = "DELETE FROM orders WHERE orderID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

            writeData.deleteDataFromOrders(preparedStatement);

            int deletedRowsAffected = preparedStatement.executeUpdate();

            if (deletedRowsAffected > 0 ){
                System.out.println(deletedRowsAffected + " rows affected");
            }else {
                System.out.println("No orders with inputted order ID found");
            }

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Couldn't delete order from table 'orders' ");
        }
    }
}

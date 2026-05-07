import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerDAO extends DatabaseConnection{
    DatabaseConnection databaseConnection = new DatabaseConnection();

    void selectCustomer(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                System.out.println("CustomerID: " + resultSet.getInt("customerID") + " \n"
                        + "First Name: " + resultSet.getString("customerFirstName") + " \n"
                        + "Last Name: " + resultSet.getString("customerLastName") + " \n"
                        + "Email: " + resultSet.getString("customerEmail") + " \n");
            }
            resultSet.close();
            statement.close();
            connection.close();
        }catch(Exception e){
            System.out.println("Failed to load data from table 'customer' ");
        }
    }

    void createCustomer(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            String createSQL = "INSERT INTO customer(customerID, customerFirstName, customerLastName, customerEmail) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(createSQL);

            writeData.writeDataIntoCustomer(preparedStatement);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " rows affected");

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to insert data into 'customer' ");
        }
    }


    void updateCustomer(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            String updateSQL = "UPDATE customer SET customerFirstName = ?, customerLastName = ?, customerEmail = ? WHERE customerID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            writeData.updateDataFromCustomer(preparedStatement);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println(updatedRows + " rows affected");
            }else  {
                System.out.println("No customer with matching inputted ID ");
            }

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to update data into 'customer' ");
        }

    }

    void deleteCustomer(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            String deleteSQL = "DELETE FROM customer WHERE customerID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

            writeData.deleteDataFromCustomer(preparedStatement);

            int deletedRowsAffected = preparedStatement.executeUpdate();

            if (deletedRowsAffected > 0 ){
                System.out.println(deletedRowsAffected + " rows affected");
            }else {
                System.out.println("No customer with inputted ID found");
            }

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to delete customer from database");
        }
    }
}

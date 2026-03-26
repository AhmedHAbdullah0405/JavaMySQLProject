import java.sql.*;

public class DatabaseConnection {
    Connection connection = null;

    private static final String dbURL = "jdbc:mysql://localhost:3306/gamestop";
    private static final String username = "root";
    private static final String password = "ahmed_bekir0405";

    WriteData writeData = new WriteData();

    void selectCustomer(){
        try{
            connection = DriverManager.getConnection(dbURL, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                System.out.println("CustomerID: " + resultSet.getInt("customerID") + "\n"
                        + "First Name: " + resultSet.getString("customerFirstName") + "\n"
                        + "Last Name: " + resultSet.getString("customerLastName") + "\n"
                        + "Email: " + resultSet.getString("customerEmail"));
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
            connection = DriverManager.getConnection(dbURL, username, password);

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
           connection = DriverManager.getConnection(dbURL, username, password);

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
            connection = DriverManager.getConnection(dbURL, username, password);

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

    void selectGame(){
        try{
            connection = DriverManager.getConnection(dbURL, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM videogames");

            while (resultSet.next()){
                System.out.println("GameID: " + resultSet.getInt("gameID") + " \n"
                        + "Game name: " + resultSet.getString("gameName") + " \n"
                        + "Game Description: " +  resultSet.getString("gameDesc") + " \n"
                        + "Game Genre: "+  resultSet.getString("gameGenre") + " \n" + "Player mode: " + resultSet.getString("playerMode") + " \n"
                        + "Price: " +  resultSet.getInt("price") + " \n" + "PEGI rating:  " + resultSet.getInt("PEGIrating") + " \n"
                        + "In stock:  " + resultSet.getInt("quantity"));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to load data from table 'videoGames' ");
        }

    }

    void createGame(){
        try{
            connection = DriverManager.getConnection(dbURL, username, password);

            String sql = "INSERT INTO videoGames(gameID, gameName, gameDesc, gameGenre, playerMode, price, PEGIrating, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            writeData.writeDataIntoVideoGames(preparedStatement);
            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println(rowsAffected + " rows affected");
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Couldn't insert data to 'videoGames'");
        }

    }

    void updateGame(){
        try{
            connection = DriverManager.getConnection(dbURL, username, password);

            String updateSQL = "UPDATE videogames set gameName = ?, gameDesc = ?, gameGenre = ?, playerMode = ?, price = ?, PEGIrating = ?, quantity = ? WHERE gameID = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            writeData.updateDataFromVideoGames(preparedStatement);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println(updatedRows + " rows affected");
            }else  {
                System.out.println("No game with matching inputted ID ");
            }

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to update data from table 'videogames' ");
        }
    }

    void deleteGame(){
        try{
            connection = DriverManager.getConnection(dbURL, username, password);

            String deleteSQL = "DELETE FROM videoGames WHERE gameID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);

            writeData.deleteDataFromVideoGames(preparedStatement);

            int deletedRowsAffected = preparedStatement.executeUpdate();

            if (deletedRowsAffected > 0 ){
                System.out.println(deletedRowsAffected + " rows affected");
            }else {
                System.out.println("No game with inputted game ID found");
            }

            preparedStatement.close();
            connection.close();
        }catch (Exception e){
            System.out.println("Failed to delete data from table 'videoGames' ");
        }
    }

    void selectOrders(){
        try{
            connection = DriverManager.getConnection(dbURL, username, password);

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
            connection = DriverManager.getConnection(dbURL, username, password);

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
            connection = DriverManager.getConnection(dbURL, username, password);

            String updateSQL = "UPDATE orders set customerFirstName = ?, customerLastname = ?, gameName = ?, purchaseDate = ?, returned = ?, gameID = ? WHERE orderID = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);

            writeData.updateDataFromOrders(preparedStatement);

            int updatedRows = preparedStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println(updatedRows + " rows affected");
            }else  {
                System.out.println("No orders with matching inputted ID");
            }
        }catch (Exception e){
            System.out.println("Failed to update data from table 'orders' ");
            e.printStackTrace();
        }
    }

    void deleteOrders(){
        try {
            connection = DriverManager.getConnection(dbURL, username, password);

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

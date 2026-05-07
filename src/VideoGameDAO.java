import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class VideoGameDAO extends DatabaseConnection{
    DatabaseConnection databaseConnection = new DatabaseConnection();

    void selectGame(){
        try{
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM videogames");

            while (resultSet.next()){
                System.out.println("GameID: " + resultSet.getInt("gameID") + " \n"
                        + "Game name: " + resultSet.getString("gameName") + " \n"
                        + "Game Description: " +  resultSet.getString("gameDesc") + " \n"
                        + "Game Genre: "+  resultSet.getString("gameGenre") + " \n" + "Player mode: " + resultSet.getString("playerMode") + " \n"
                        + "Price: " +  resultSet.getInt("price") + " \n" + "PEGI rating:  " + resultSet.getInt("PEGIrating") + " \n"
                        + "In stock:  " + resultSet.getInt("quantity") + " \n");
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
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

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
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

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
            connection = DriverManager.getConnection(databaseConnection.getDbURL(), databaseConnection.getUsername(), databaseConnection.getPassword());

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
}

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class WriteData {
    Scanner scanner = new Scanner(System.in);

    void writeDataIntoCustomer(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Enter customer info:  (ID, firstName, lastName, email) ");

        System.out.print("Customer ID: ");
        int customerID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter customer first name: ");
        String customerFirstName = scanner.nextLine();
        System.out.print("Enter customer last name: ");
        String customerLastName = scanner.nextLine();
        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

        preparedStatement.setInt(1,customerID);
        preparedStatement.setString(2, customerFirstName);
        preparedStatement.setString(3, customerLastName);
        preparedStatement.setString(4, customerEmail);

        preparedStatement.executeUpdate();
    }

    void writeDataIntoVideoGames(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Enter game info: (gameID, gameName, gameDesc, gameGenre, playerMode, price, PEGIrating, quantity)");

        System.out.print("Game ID: " );
        int gameID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter game name: ");
        String gameName = scanner.nextLine();
        System.out.print("Enter game description: ");
        String gameDesc = scanner.nextLine();
        System.out.print("Enter game genre: ");
        String gameGenre = scanner.nextLine();
        System.out.print("Enter game mode: ");
        String playerMode = scanner.nextLine();
        System.out.print("Enter game price: ");
        int price = scanner.nextInt();
        System.out.print("Enter PEGIrating: ");
        int PEGIrating = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        preparedStatement.setInt(1, gameID);
        preparedStatement.setString(2, gameName);
        preparedStatement.setString(3, gameDesc);
        preparedStatement.setString(4, gameGenre);
        preparedStatement.setString(5, playerMode);
        preparedStatement.setInt(6, price);
        preparedStatement.setInt(7, PEGIrating);
        preparedStatement.setInt(8, quantity);

        preparedStatement.executeUpdate();
    }

    void writeDataIntoOrders(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Enter order info: (orderID, customerFirstName, customerLastName, gameName, gameID, purchaseDate, returned)");

        System.out.print("Order ID: " );
        int orderID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("First Name: ");
        String customerFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String customerLastName = scanner.nextLine();
        System.out.print("Game Name: ");
        String gameName = scanner.nextLine();
        System.out.print("Game ID: ");
        int gameID = scanner.nextInt();
        System.out.print("Purchase Date: ");
        scanner.nextLine();
        String purchaseDate = scanner.nextLine();
        System.out.print("Returned: ");
        boolean returned = scanner.nextBoolean();

        preparedStatement.setInt(1, orderID);
        preparedStatement.setString(2, customerFirstName);
        preparedStatement.setString(3, customerLastName);
        preparedStatement.setString(4, gameName);
        preparedStatement.setInt(5, gameID);
        preparedStatement.setString(6, purchaseDate);
        preparedStatement.setBoolean(7, returned);

    }

    void updateDataFromVideoGames(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Which videogame info do you want to update? (gameName, gameDesc, gameGenre, playerMode, price, PEGIrating, quantity, gameID");

        System.out.println("Game Name: ");
        String gameName = scanner.nextLine();
        System.out.println("Game Description: ");
        String gameDesc = scanner.nextLine();
        System.out.println("Game Genre: ");
        String gameGenre = scanner.nextLine();
        System.out.println("Game Mode: ");
        String playerMode = scanner.nextLine();
        System.out.println("Game Price: ");
        int price = scanner.nextInt();
        System.out.println("PEGIrating: ");
        int PEGIrating = scanner.nextInt();
        System.out.println("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.println("Game ID: ");
        int gameID = scanner.nextInt();

        preparedStatement.setString(1, gameName);
        preparedStatement.setString(2, gameDesc);
        preparedStatement.setString(3, gameGenre);
        preparedStatement.setString(4, playerMode);
        preparedStatement.setInt(5, price);
        preparedStatement.setInt(6, PEGIrating);
        preparedStatement.setInt(7, quantity);
        preparedStatement.setInt(8, gameID);
    }

    void updateDataFromCustomer(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Who's customer info do you want to update?: (customerFirstName, customerLastName, Email, customerID)");

        System.out.println("First Name: ");
        String customerFirstName = scanner.nextLine();
        System.out.println("Last Name: ");
        String customerLastName = scanner.nextLine();
        System.out.print("Email: ");
        String customerEmail = scanner.nextLine();
        System.out.println("Customer ID: ");
        int customerID = scanner.nextInt();

        preparedStatement.setString(1, customerFirstName);
        preparedStatement.setString(2, customerLastName);
        preparedStatement.setString(3, customerEmail);
        preparedStatement.setInt(4, customerID);
    }

    void updateDataFromOrders(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Which order info do you want to update? (customerFirstName, customerLastName, gameName, purchaseDate, returned, gameID, orderID)");

        System.out.print("First Name: ");
        String customerFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String customerLastName = scanner.nextLine();
        System.out.print("Game Name: ");
        String gameName = scanner.nextLine();
        System.out.println("Purcahse Date: ");
        String purchaseDate = scanner.nextLine();
        System.out.print("Returned: ");
        boolean returned = scanner.nextBoolean();
        System.out.println("Game ID: ");
        int gameID = scanner.nextInt();
        System.out.println("Order ID: ");
        int orderID = scanner.nextInt();

        preparedStatement.setString(1, customerFirstName);
        preparedStatement.setString(2, customerLastName);
        preparedStatement.setString(3, gameName);
        preparedStatement.setString(4, purchaseDate);
        preparedStatement.setBoolean(5, returned);
        preparedStatement.setInt(6, gameID);
        preparedStatement.setInt(7, orderID);

    }

    void deleteDataFromCustomer(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Which customer do you want to remove?: (customerID)" );

        System.out.println("Customer ID: ");
        int customerID = scanner.nextInt();

        preparedStatement.setInt(1, customerID);

        preparedStatement.executeUpdate();
    }

    void deleteDataFromVideoGames(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Which game do you want to remove?: (gameID)" );

        System.out.println("Game ID: ");
        int gameID = scanner.nextInt();

        preparedStatement.setInt(1, gameID);

        preparedStatement.executeUpdate();
    }

    void deleteDataFromOrders(PreparedStatement preparedStatement) throws SQLException {
        System.out.println("Which order do you want to remove?: (orderID)" );

        System.out.println("Order ID: ");
        int orderID = scanner.nextInt();

        preparedStatement.setInt(1, orderID);

        preparedStatement.executeUpdate();
    }
}

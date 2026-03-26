import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;

        DatabaseConnection databaseConnection = new DatabaseConnection();

        while (userChoice != 13) {
            System.out.println("Welcome to online GameStop! What do you want to do?: ");
            System.out.println("1. Show all available games");
            System.out.println("2. Show orders");
            System.out.println("3. Create order");
            System.out.println("4. Update order");
            System.out.println("5. Delete order");
            System.out.println("6. Order a game");
            System.out.println("7. Modify a game");
            System.out.println("8. Return a game");
            System.out.println("9. Register as a customer");
            System.out.println("10. Update customer info");
            System.out.println("11. Delete customer info");
            System.out.println("12. Show customer info");
            System.out.println("13. Exit");

            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                scanner.nextLine();
            }else {
                String isValidInput = scanner.nextLine();
                System.out.println("Invalid input " + isValidInput + " Please try again.");
            }

            switch (userChoice) {
                case 1:
                    System.out.println("Here is all currently available games:");
                    databaseConnection.selectGame();
                    break;
                case 2:
                    System.out.println("Here are the current orders: ");
                    databaseConnection.selectOrders();
                    break;
                case 3:
                    System.out.println("Create an new order: ");
                    databaseConnection.createOrders();
                    break;
                case 4:
                    System.out.println("Update an order: ");
                    databaseConnection.updateOrders();
                    break;
                case 5:
                    System.out.println("Delete an order");
                    databaseConnection.deleteOrders();
                    break;
                case 6:
                    System.out.println("What games do you want to add?: ");
                    databaseConnection.createGame();
                    break;
                case 7:
                    System.out.println("What games do you want to modify?: ");
                    databaseConnection.updateGame();
                    break;
                case 8:
                    System.out.println("What games do you want to return?: ");
                    databaseConnection.deleteGame();
                    break;
                case 9:
                    System.out.println("Registered as customer");
                    databaseConnection.createCustomer();
                    break;
                case 10:
                    System.out.println("Customer info updated: ");
                    databaseConnection.updateCustomer();
                    break;
                case 11:
                    System.out.println("Customer removed from database");
                    databaseConnection.deleteCustomer();
                    break;
                case 12:
                    System.out.println("Here's the current customer info:");
                    databaseConnection.selectCustomer();
                    break;
                case 13:
                    System.out.println("Thank you for shopping at online GameStore!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        }

        scanner.close();

    }

}


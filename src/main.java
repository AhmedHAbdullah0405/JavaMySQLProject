import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;

        CustomerDAO customerDAO = new CustomerDAO();

        OrdersDAO ordersDAO = new OrdersDAO();

        VideoGameDAO videoGameDAO = new VideoGameDAO();

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
                    videoGameDAO.selectGame();
                    break;
                case 2:
                    System.out.println("Here are the current orders: ");
                    ordersDAO.selectOrders();
                    break;
                case 3:
                    System.out.println("Here are the current orders: ");
                    ordersDAO.selectOrders();

                    System.out.println(" ");

                    System.out.println("Create an new order: ");
                    ordersDAO.createOrders();
                    break;
                case 4:
                    System.out.println("Here are the current orders: ");
                    ordersDAO.selectOrders();

                    System.out.println(" ");

                    System.out.println("Update an order: ");
                    ordersDAO.updateOrders();
                    break;
                case 5:
                    System.out.println("Here are the current orders: ");
                    ordersDAO.selectOrders();

                    System.out.println(" ");

                    System.out.println("Delete an order");
                    ordersDAO.deleteOrders();
                    break;
                case 6:
                    System.out.println("Here is all currently available games:");
                    videoGameDAO.selectGame();

                    System.out.println(" ");

                    System.out.println("What games do you want to add?: ");
                    videoGameDAO.createGame();
                    break;
                case 7:
                    System.out.println("Here is all currently available games:");
                    videoGameDAO.selectGame();

                    System.out.println(" ");

                    System.out.println("What games do you want to modify?: ");
                    videoGameDAO.updateGame();
                    break;
                case 8:
                    System.out.println("Here is all currently available games:");
                    videoGameDAO.selectGame();

                    System.out.println(" ");

                    System.out.println("What games do you want to return?: ");
                    videoGameDAO.deleteGame();
                    break;
                case 9:
                    System.out.println("Here's the current customer info:");
                    customerDAO.selectCustomer();

                    System.out.println(" ");

                    System.out.println("Registered as customer");
                    customerDAO.createCustomer();
                    break;
                case 10:
                    System.out.println("Here's the current customer info:");
                    customerDAO.selectCustomer();

                    System.out.println(" ");

                    System.out.println("Customer info updated: ");
                    customerDAO.updateCustomer();
                    break;
                case 11:
                    System.out.println("Here's the current customer info:");
                    customerDAO.selectCustomer();

                    System.out.println(" ");

                    System.out.println("Customer removed from database");
                    customerDAO.deleteCustomer();
                    break;
                case 12:
                    System.out.println("Here's the current customer info:");
                    customerDAO.selectCustomer();
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


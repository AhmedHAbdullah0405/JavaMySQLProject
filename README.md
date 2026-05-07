Consolebased GameStop program in Java

A terminal-based program where the user is met with a menu, where they can modify the tables "videogames", "customer" and "orders" with full CRUD functionality. 
This system is connected to the database "gamestop" in mysql, where the data within the tables changes in realtime based on user input.

Features:
- Full Create, read, update and delete functionality
- Project manages multiple tables (Videogame, Customer and Order)
- Dynamic user input through terminal
- Database updates in real-time
- Input handling through the use of PreparedStatement, which also prevents SQL injection

Technologies used:
- Java
- MySQL
- JDBC

Structure:
- Main class handles with menu and user interaction
- DatabaseConnection class that stores private dbURL, password and username fields, where access is given through getters and setter methods
- CustomerDAO class for handling CRUD operations withint the "customer" table
- OrdersDAO class for handling CRUD operations withint the "orders" table
- VideoGamesDAO class for handling CRUD operations withint the "videogames" table
- All DAO classes inherit the getters and setters, plus the connection from the "DatabaseConnection" class.
- WriteData class for accepting CRUD inputs form user and sends it to the "CustomerDAO", "OrdersDAO" and "VideoGamesDAO" classes

How this project runs (In intelije IDE)
1. Clone the repository
2. Set up MySQL database (gamestop) with associated tables (videogames, customer, orders)
3. Change databse credentials to your own
4. Download the .jar-file form MySQLs websites
5. Add the .jar-file into the "libraries"-section of "Project Structure" (Upper-left corner -> Project Structure -> Libraries. Click on '+' and select the .jar-file)
6. Run the java main file

Documentation: 
A full report is also included in the project, which documents the developement process from a concept to a full project, bugs and issues and how i fixed them including details on how i implemented the code.

Challenges:
- Debugging MySQL connection issues
- Setting up methods that use PreparedStatement instead of Statement, to allow userinput to modify data within the tables
- Setting up the UPDATE methods for all three tables

Planned improvements: 
- Better input validation

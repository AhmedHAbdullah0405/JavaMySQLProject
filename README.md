Consolebased GameStop program in Java

A terminal-based program where the user is met with a menu, where they can the table "videogames", "customer" and "orders" with full CRUD functionality. 
This system is connected to the database "gamestop" in mysql, where the data within the tables changes in realtime based on user input

Features:
- Full Create, read, update and delete functionality
- Project manages multiple tables (Videogame, Customer and Order)
- Dynamic user input through terminal
- Databse updates in real-time
- Input handling through the use of PreparedStatement, which also prevents SQL injection

Technologies used:
- Java
- MySQL
- JDBC

Structure:
- Main class handles with meny and user interaction
- DatabaseConnection class handles all CRUD operations for all tables
- WriteData class for accepting CRUD inputs form user and send it to the DatabaseConnection class

How this project runs
1. Clone the repository
2. Set up MySQL database (gamestop) with associated tables (videogames, customer, orders)
3. Change databse credentials to you own
4. Run the java main file

Documentation: 
A full report will soon be included in the project, which documents the developemtn process from a concept to a full project, bugs and issues and how i fixed them including details on how i implemented the code.

Challenges:
- Debugging MySQL connection issues
- Setting up methods that use PreparedStatement instead of Statement, to allow userinput to modify data within the tables
- Setting up the UPDATE methods for all three tables

Planned improvements: 
- Better input validation
- Implementaion of OOP (Object-oriented programming)
- Improved UI in terminal

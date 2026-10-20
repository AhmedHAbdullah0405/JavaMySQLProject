CREATE DATABASE gameStop;

CREATE table videoGames(
	gameID int,
    gameName varchar(255),
    gameDesc varchar(255),
    gameGenre varchar(255),
    playerMode varchar(255),
    price double,
    PEGIrating int, 
    quantity int,
    primary key (gameID)
);

CREATE table customer(
	customerID int,
    customerFirstName varchar(255),
    customerLastName varchar(255),
    customerEmail varchar(255),
    primary key (customerID)
);

CREATE TABLE orders(
	orderID int,
    customerFristName varchar(255),
    customerLastName varchar(255),
    gameName varchar(255),
    gameID int,
    purchaseDate varchar(255),
    returned boolean,
    primary key (orderID)
);


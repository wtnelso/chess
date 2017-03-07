DROP DATABASE IF EXISTS `cs6400_sp17_team059`; 
CREATE DATABASE IF NOT EXISTS cs6400_sp17_team059 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

SET default_storage_engine=InnoDB;
SET FOREIGN_KEY_CHECKS=0;
USE cs6400_sp17_team059;

-- Tables 

CREATE TABLE user (

	email varchar(250) NOT NULL UNIQUE, 

	firstName varchar (50) NOT NULL,

	lastName varchar (100) NOT NULL,

	username varchar (30) NOT NULL UNIQUE,

	password varchar (30) NOT NULL,

	siteID varchar(60) NOT NULL,

	PRIMARY KEY (email)

);

CREATE TABLE client (

	clientID int(10) unsigned NOT NULL AUTO_INCREMENT,

	description varchar(100),

	firstName varchar(30) NOT NULL,

	lastName varchar(50) NOT NULL,
	phoneNum varchar(10),

	PRIMARY KEY (clientID)

);

CREATE TABLE clientLog (

	logEntryID int(10) unsigned NOT NULL AUTO_INCREMENT,

	entryDate date NOT NULL,

	site varchar(60) NOT NULL,

	service varchar(50) NOT NULL,

	notes varchar(100),

	fieldModif varchar(100),

	clientID int (10) unsigned NOT NULL,

	PRIMARY KEY (logEntryID)

);

CREATE TABLE site (

	siteID int(10) unsigned NOT NULL AUTO_INCREMENT,
	phoneNum varchar(10) NOT NULL,

	shortName varchar(50) NOT NULL,

	street varchar(50) NOT NULL,

	city varchar(50) NOT NULL,

	state varchar(20) NOT NULL,

	zipCode varchar(10) NOT NULL,

	PRIMARY KEY (siteID)

);

CREATE TABLE service (

	serviceID int(10) unsigned NOT NULL AUTO_INCREMENT,

	type varchar(30) NOT NULL,

	siteID int(10) unsigned NOT NULL,

	PRIMARY KEY (serviceID)

);

CREATE TABLE item (

	itemID int(10) unsigned NOT NULL AUTO_INCREMENT,

	name varchar(50) NOT NULL,

	amount int(10) unsigned NOT NULL,

	category varchar(30) NOT NULL,

	subCategory varchar(30) NOT NULL,

	storeageType varchar(30) NOT NULL,

	expDate date NOT NULL,

	serviceID int(10) unsigned NOT NULL,

	PRIMARY KEY (itemID)

);

CREATE TABLE request (

	requestID int(10) unsigned NOT NULL AUTO_INCREMENT,

	source int(10) unsigned NOT NULL,

	destination int(10) unsigned NOT NULL,

	item varchar(50) NOT NULL,

	amtRequested int(10) unsigned NOT NULL,

	status varchar(30) NOT NULL,

	amtProvided int(10) unsigned NOT NULL,

	serviceID int(10) unsigned NOT NULL,

	userID varchar(250) NOT NULL,
	PRIMARY KEY (requestID)

);

CREATE TABLE clientAccessible (

	clientAccesID int(10) unsigned NOT NULL AUTO_INCREMENT,

	description varchar(50) NOT NULL,

	hours varchar(50) NOT NULL,

	conditions varchar(50) NOT NULL,

	type varchar(30) NOT NULL,

	serviceID int(10) unsigned NOT NULL,

	PRIMARY KEY (clientAccesID)

);

CREATE TABLE soupKitchen (

	soupKitchenID int(10) unsigned NOT NULL AUTO_INCREMENT,

	seatsAvailable int(10) unsigned NOT NULL,

	totalSeats int(10) unsigned NOT NULL,

	clientAccesID int(10) unsigned NOT NULL,

	PRIMARY KEY (soupKitchenID)

);

CREATE TABLE shelter (

	shelterID int(10) unsigned NOT NULL AUTO_INCREMENT,

	clientAccessID int(10) unsigned,

	PRIMARY KEY (shelterID)

);

CREATE TABLE bunk (

	bunkID int(10) unsigned NOT NULL AUTO_INCREMENT,

	type varchar(30) NOT NULL,

	isAvaiable boolean NOT NULL,

	shelterID int(10) unsigned,

	PRIMARY KEY (bunkID)

);

CREATE TABLE room (

	roomID int(10) unsigned NOT NULL AUTO_INCREMENT,

	number varchar(10) NOT NULL,

	isAvaiable boolean NOT NULL,

	shelterID int(10) unsigned,

	PRIMARY KEY (roomID)

);


CREATE TABLE waitlist (

	waitlistID int(10) unsigned NOT NULL AUTO_INCREMENT,

	rank int(10) unsigned NOT NULL,

	entryDate date NOT NULL,
	endDate date DEFAULT NULL,

	endReason varchar(30) DEFAULT NULL,

	clientID int(10) unsigned NOT NULL,

	shelterID int(10) unsigned NOT NULL,

	PRIMARY KEY (waitlistID)

);

-- Constraints 
ALTER TABLE user
  
	ADD CONSTRAINT user_ibfk_1 FOREIGN KEY (siteID) REFERENCES site (siteID);

ALTER TABLE clientLog
	
	ADD CONSTRAINT clientLog_ibfk_1 FOREIGN KEY (site) REFERENCES site (siteID);
	ADD CONSTRAINT clientLog_ibfk_2 FOREIGN KEY (clientID) REFERENCES client (clientID);

ALTER TABLE service
    
	ADD CONSTRAINT service_ibfk_1 FOREIGN KEY (siteID) REFERENCES site (siteID);

ALTER TABLE item
    
	ADD CONSTRAINT item_ibfk_1 FOREIGN KEY (serviceID) REFERENCES service (serviceID);

ALTER TABLE request
    
	ADD CONSTRAINT request_ibfk_1 FOREIGN KEY (serviceID) REFERENCES service (serviceID);

ALTER TABLE clientAccessible
    
	ADD CONSTRAINT clientAccessible_ibfk_1 FOREIGN KEY (serviceID) REFERENCES service (serviceID);

ALTER TABLE soupKitchen
    
	ADD CONSTRAINT soupKitchen_ibfk_1 FOREIGN KEY (clientAccesID) REFERENCES clientAccessible (clientAccesID);

ALTER TABLE shelter
    
	ADD CONSTRAINT shelter_ibfk_1 FOREIGN KEY (shelterID) REFERENCES clientAccessible (clientAccesID);

ALTER TABLE bunk
    
	ADD CONSTRAINT bunk_ibfk_1 FOREIGN KEY (shelterID) REFERENCES shelter (shelterID);

ALTER TABLE room
    
	ADD CONSTRAINT room_ibfk_1 FOREIGN KEY (shelterID) REFERENCES shelter (shelterID);

ALTER TABLE waitlist
    
	ADD CONSTRAINT waitlist_ibfk_1 FOREIGN KEY (shelterID) REFERENCES shelter (shelterID);
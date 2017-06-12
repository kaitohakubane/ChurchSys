drop database ChurchSys;
create database ChurchSys;


use ChurchSys;

CREATE TABLE Church (
	
	churchId int NOT NULL AUTO_INCREMENT ,
    
	churchName nvarchar(255),
    
	longitude double,

	latitude double,
    
	tel nvarchar(50),
    
	mail nvarchar(255),
    
	startTime time ,
    
	endTime time,
    
	description nvarchar (255),

	streamLink nvarchar(255),
        
	streamStatus int,
    
	PRIMARY KEY (churchId)

);


create table User(
	
	userId int NOT NULL AUTO_INCREMENT,

   	accountId nvarchar(255),

 	password nvarchar (255),
 
	userName nvarchar(255),   	
    
	role varchar(50),
    
	tel nvarchar (20),
    
	certificate nvarchar(255),
	
	accountNum nvarchar(20),

	enabled bit,
    
	email nvarchar(255),
    
	primary key (userId)

);
create table Ability (

	abilityId int NOT NULL AUTO_INCREMENT,
    
	conductorId int,
    
	subId int,
    
	primary key (abilityId)

);

create table Subject (
	
	subId int NOT NULL AUTO_INCREMENT,
    
	subName nvarchar(255),
    
	categoryId int,
    
	primary key (subId)
   
 
);
create table Category(
	
	categoryId int NOT NULL AUTO_INCREMENT,
    
	categoryName nvarchar (255),
    
	primary key (categoryId)

);

create table Room (
	
	roomId int NOT NULL AUTO_INCREMENT,
    
	roomName nvarchar(50),
 
	churchId int,     
    
	roomStatus int,
    
	primary key(roomId)

);

create table Event(
	
	eventId int NOT NULL AUTO_INCREMENT,
    
	numOfSlot int,
    
	churchId int,
    
	eventStatus int,
    
	examDate date,
    
	subId int,
    
	typeId int,
    
	startDate date,
    
	decription nvarchar(255),
    
	primary key (eventId)

);
create table Type (
	
	typeId int NOT NULL AUTO_INCREMENT,
    
	description nvarchar(255),
    
	primary key (typeId)

);
create table Registration (
	
	regisId int NOT NULL AUTO_INCREMENT,
    
	eventId int,
    
	userId int,
    
	churchId int,  
    
	subId int,
       
	regisDate date,
    
	estTime time,
    
	regisStatus int,
    
	result int,
    
	message nvarchar (255),
    
	primary key (regisId)

);
CREATE table Post (
	
	postId int NOT NULL AUTO_INCREMENT,
    
	conductorId int,

	title nvarchar (255),    
    
	information nvarchar (255),
    
	isContribute bit,
    
	primary key (postId)

);
create table Slot (
	
	slotId int NOT NULL AUTO_INCREMENT,
	
	eventId int,
    
	roomId int,
    
	conductorId int,
    
	slotDate date,
    
	slotHourId int,
    
	primary key (slotId)
    

);
create table SlotHour(
	
	slotHourId int not null auto_increment,
    
	name nvarchar(255),
    
	startTime time,
    
	endTime time,
    
	primary key (slotHourId)

);
create table interaction (
	
	interactionId int not null auto_increment,
    
	churchId int,
    
	userId int,
    
	primary key (interactionId)

);
create table Question (

	
	quesId int NOT NULL AUTO_INCREMENT,
    
	conductorId int,
    
	userId int,
    
	information nvarchar(255),
    
	quesStatus nvarchar(255),
    
	subId int,    
    
	primary key (quesId)

);
create table Contribution(

	contributeId int NOT NULL AUTO_INCREMENT,
    
	userId int,
    
	postId int,	
    
	donate long,
        
	primary key (contributeId)

);
create table RoomCapable (

	roomCapId int NOT NULL AUTO_INCREMENT,
    
	roomId int,
    
	subId int,
    
	primary key (roomCapId)

);
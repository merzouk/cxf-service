drop database dbCxfJaxws;
create database dbCxfJaxws;

create table dbCxfJaxws.Account(
   id int NOT NULL AUTO_INCREMENT,
   login varchar(50) NOT NULL UNIQUE,
   password varchar(50) NOT NULL,
   date_now TIMESTAMP NOT NULL,
   primary key(id)
);

create table dbCxfJaxws.Cours(
   id int NOT NULL AUTO_INCREMENT,
   coursCode varchar(50) NOT NULL UNIQUE,
   primary key(id)
);

create table dbCxfJaxws.Inscription(
   id int NOT NULL AUTO_INCREMENT,
   email varchar(150) NOT NULL,
   cours varchar(150) NOT NULL,
   dateDuJour TIMESTAMP NOT NULL,
   primary key(id)
);

create table dbCxfJaxws.User(
   id int NOT NULL AUTO_INCREMENT,
   nom varchar(50) NOT NULL,
   prenom varchar(50) NOT NULL,
   date_now TIMESTAMP NOT NULL,
   email varchar(150) NOT NULL UNIQUE,
   primary key(id)
);


drop database dbCxfJaxwstest;
create database dbCxfJaxwstest ;

create table dbCxfJaxwstest.Account(
   id int NOT NULL AUTO_INCREMENT,
   login varchar(50) NOT NULL UNIQUE,
   password varchar(50) NOT NULL,
   date_now TIMESTAMP NOT NULL,
   primary key(id)
);
create table dbCxfJaxwstest.Cours(
   id int NOT NULL AUTO_INCREMENT,
   coursCode varchar(50) NOT NULL UNIQUE,
   primary key(id)
);

create table dbCxfJaxwstest.Inscription(
   id int NOT NULL AUTO_INCREMENT,
   email varchar(150) NOT NULL,
   cours varchar(150) NOT NULL,
   dateDuJour TIMESTAMP NOT NULL,
   primary key(id)
);

create table dbCxfJaxwstest.User(
   id int NOT NULL AUTO_INCREMENT,
   nom varchar(50) NOT NULL,
   prenom varchar(50) NOT NULL,
   date_now TIMESTAMP NOT NULL,
   email varchar(150) NOT NULL UNIQUE,
   primary key(id)
);

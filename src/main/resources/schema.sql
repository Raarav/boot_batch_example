create table if not exists person
(
    personId varchar(100) primary key,
    firstName varchar(200),
    lastName varchar(200),
    contact varchar(10),
    email varchar(100)
);
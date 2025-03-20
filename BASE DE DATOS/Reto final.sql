CREATE DATABASE FINALCHALLENGE;
USE FINALCHALLENGE;

CREATE TABLE USERS(
ID VARCHAR (20) NOT NULL PRIMARY KEY,
Nam_USERS VARCHAR (20),
passwords VARCHAR (30),
NAME_users VARCHAR(20),
SURNAME_USERS VARCHAR (20),
AGE INTEGER);

INSERT INTO USERS VALUES ('12345', 'Juan', 'password123', 'Juan', 'Pérez', 32),
('13579', 'Manolo', 'passwor234', 'Manolo', 'Aroan', 69),
('54321', 'Jon', 'password456', 'Jon', 'Cascadas',24);

CREATE TABLE CASES(
COD_CASES INT NOT NULL PRIMARY KEY,
NAME_CASES VARCHAR(40),
DESCRIPTION_CASES VARCHAR(300),
NUMBER_AGENT INTEGER,
NUMBER_CRIMINAL INTEGER);

INSERT INTO CASES VALUES (101, 'Robo a Mano Armada', 'Robo cusado por colombianos que usaron machetes en un local de elctronica', 12 , 3),
(333, 'Robo de vehiculo de lujo', 'Robo de guante blanco de un Audi deportivo', 9	, 2),
(000, 'Pelea de bandas', 'Un enfremtamiento sin cuartel de dos bandas enemigas', 38 , 12);

CREATE TABLE WORKS(
ID VARCHAR (20),
COD_CASES INT,
DATE_W DATE,
PRIMARY KEY(Id,COD_CASES),
FOREIGN KEY (ID) REFERENCES USERS(ID),
FOREIGN KEY (COD_CASES) REFERENCES CASES(COD_CASES)
);

INSERT INTO WORKS VALUES ('12345', 101, '2025-03-19'),
('13579', 333, '2025-01-29'),
('54321', 000, '2024-11-26');

CREATE TABLE CRIMINALS(
DNI CHAR(9) NOT NULL PRIMARY KEY,
NAME_CRIMINAL VARCHAR (20),
SURNAME_CRIMINAL VARCHAR(20),
EDAD INTEGER,
DESCRIPTION_CRIMINAL VARCHAR (300),
CRIMES VARCHAR (100));

INSERT INTO CRIMINALS VALUES ('12345678F', 'Carlos', 'Gomez', 35, 'Criminal involucrado en múltiples delitos de robo y asalto.', 'Robo, Asalto'),
('94863562K', 'Jamil', 'Kazar', 56, 'Criminal muy peligroso en busca y captura de manera urgente.', 'Homicidio, Aesinato, Allanamiento de morada, Delitos contra la libertad'),
('06835513P', 'Samir', 'Merik', 27, 'Criminal involucrado en múltiples delitos de asalto.', 'Violencia domestica, Violencia de Genero');

CREATE TABLE PARTICIPATE(
COD_CASES INT,
DNI CHAR (9),
PRIMARY KEY(COD_CASES,DNI),
FOREIGN KEY (COD_CASES) REFERENCES CASES(COD_CASES),
FOREIGN KEY (DNI) REFERENCES CRIMINALS(DNI)
);

INSERT INTO PARTICIPATE VALUES (101, '12345678F'),
(333, '94863562K'),
(000, '06835513P');

delimiter //
CREATE FUNCTION GetCriminalCount(CASE_ID INT)
RETURNS INT
DETERMINISTIC
BEGIN
    DECLARE criminal_count INT;
    SELECT COUNT(*) INTO criminal_count
    FROM PARTICIPATE
    WHERE COD_CASES = CASE_ID;
    RETURN criminal_count;
END;
delimiter ;

delimiter //
CREATE FUNCTION GetAgentName(CASE_ID INT)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE agent_name VARCHAR(20);
    SELECT U.NAM_USERS INTO agent_name
    FROM WORKS W
    JOIN USERS U ON W.ID = U.ID
    WHERE W.COD_CASES = CASE_ID
    LIMIT 1; 
	RETURN agent_name;
END;
delimiter ;

delimiter //
CREATE PROCEDURE GetCaseDetailsWithCriminals(IN CASE_ID INT)
BEGIN
    SELECT C.NAME_CASES, C.DESCRIPTION_CASES
    FROM CASES C
    WHERE C.COD_CASES = CASE_ID;
	SELECT CR.NAME_CRIMINAL, CR.SURNAME_CRIMINAL
    FROM PARTICIPATE P
    JOIN CRIMINALS CR ON P.DNI = CR.DNI
    WHERE P.COD_CASES = CASE_ID;
END;
delimiter ;

/*drop database FINALCHALLENGE;*/




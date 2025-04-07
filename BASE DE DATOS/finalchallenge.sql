CREATE DATABASE FINALCHALLENGE;
USE FINALCHALLENGE;

CREATE TABLE USERS(
ID VARCHAR (20) NOT NULL PRIMARY KEY,
Nam_USERS VARCHAR (20),/*Username*/
passwords VARCHAR (30),
NAME_users VARCHAR(20),/*Name of the user*/
SURNAME_USERS VARCHAR (20),
AGE_U INT);

INSERT INTO USERS VALUES ('12345', 'Juan', 'password123', 'Juan', 'Pérez', 32),
('13579', 'Manolo', 'passwor234', 'Manolo', 'Aroan', 69),
('54321', 'Jon', 'password456', 'Jon', 'Cascadas',24);

CREATE TABLE CASES(
COD_CASES INT NOT NULL PRIMARY KEY,
NAME_CASES VARCHAR(40),
DESCRIPTION_CASES VARCHAR(300),
NUMBER_AGENT INT,
NUMBER_CRIMINAL INT);

INSERT INTO CASES VALUES (101, 'Armed Robbery', 'Robbery caused by Colombians using machetes at electronics store', 12 , 3),
(333, 'Theft of luxury vehicle', 'White-collar theft of an Audi sports car', 9	, 2),
(000, 'Gang fight', 'An all-out confrontation between two opposing gangs', 38 , 12);

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
AGE INT,
DESCRIPTION_CRIMINAL VARCHAR (300),
CRIMES VARCHAR (100));

INSERT INTO CRIMINALS VALUES ('12345678F', 'Carlos', 'Gomez', 35, 'Criminal involved in multiple robbery and assault offences.', 'Robbery, Assault'),
('94863562K', 'Jamil', 'Kazar', 56, 'Very dangerous criminal urgently wanted.', 'Homicide, Murder, Breaking and entering, Offences against liberty'),
('06835513P', 'Samir', 'Merik', 27, 'Criminal involved in multiple assault offences.', 'Domestic violence, Gender-based violence');

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
/*1*/
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
END //
delimiter ;
/*2*/
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
END //
delimiter ;
/*3*/
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
END //
delimiter ;
/*4*/
delimiter //
CREATE PROCEDURE UpdateCriminalAge(IN DNI_CHAR CHAR(9), IN NEW_AGE INT)
BEGIN
	UPDATE CRIMINALS
	SET AGE = NEW_AGE
	WHERE DNI = DNI_CHAR;
	SELECT NAME_CRIMINAL, SURNAME_CRIMINAL, AGE
	FROM CRIMINALS
	WHERE DNI = DNI_CHAR;
END //
delimiter ;
/*5*/
delimiter //
CREATE PROCEDURE GetCriminalCases(IN DNI_CHAR CHAR(9))
BEGIN
	SELECT C.COD_CASES, C.NAME_CASES, C.DESCRIPTION_CASES
	FROM CASES C
	JOIN PARTICIPATE P ON C.COD_CASES = P.COD_CASES
	WHERE P.DNI = DNI_CHAR;
END //
delimiter ;
/*6*/
delimiter //
CREATE FUNCTION GetUserAgeById(USER_ID VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE user_age INT;
	SELECT AGE_U INTO user_age
	FROM USERS
	WHERE ID = USER_ID;
	RETURN user_age;
END //
delimiter ;
/*7*/
delimiter //
CREATE PROCEDURE GetCriminalsOlderThan(Min_AGE INT)
BEGIN
	DECLARE criminal_info VARCHAR(500);
	DECLARE done INT DEFAULT 0;
	DECLARE cur CURSOR FOR
    	SELECT NAME_CRIMINAL, SURNAME_CRIMINAL
    	FROM CRIMINALS
    	WHERE AGE > Min_AGE;/*La idea es que un age sea el de criminal y el otro el que nosotros ponemos*/
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
	OPEN cur;
	FETCH cur INTO criminal_info;
	CLOSE cur;
END //
delimiter ;
call GetCriminalsOlderThan()


/*8*/
delimiter //
CREATE FUNCTION GetTotalCrimesByCriminal (DNI CHAR(9))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE total_crimes INT DEFAULT 0;
	DECLARE error_message VARCHAR(255);
    	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
    	SET error_message = 'An unexpected error occurred. Please try again later.';
	BEGIN
    	SELECT COUNT(*) INTO total_crimes
    	FROM CRIMINALS
    	WHERE DNI = DNI;
    	IF total_crimes = 0 THEN
        	RETURN -1;
    	END IF;
	END;
	RETURN total_crimes;
END //
DELIMITER ;


/*drop database FINALCHALLENGE;*/


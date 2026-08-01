SHOW Databases;

CREATE DATABASE HealthClinicDB;
USE HealthClinicDB;

CREATE TABLE Doctor( 
DoctorID INT auto_increment PRIMARY KEY, 
FirstName  VARCHAR(50) NOT NULL, 
LastName VARCHAR(50) NOT NULL, 
Specialization VARCHAR(100) NOT NULL,
Phone VARCHAR(15) UNIQUE,
CreatedOn DATETIME DEFAULT current_timestamp );

SELECT * FROM Doctor;

INSERT INTO Doctor (FirstName, LastName, Specialization, Phone)
VALUES ('Krishna', 'S Lal', 'Cardiology', '+91  9876543210');

SELECT * FROM Doctor;

SELECT DoctorID, FirstName, LastName, Specialization
FROM Doctor
WHERE Specialization = 'Cardiology';


UPDATE Doctor SET Phone = '9876500099' WHERE DoctorID = 1;

SELECT * FROM Doctor;

DELETE FROM Doctor WHERE DoctorID = 1;

SELECT * FROM Doctor;
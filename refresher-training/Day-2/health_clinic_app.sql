SHOW databases;

CREATE DATABASE health_clinic;

USE health_clinic;

CREATE TABLE patient(
patient_id int auto_increment PRIMARY KEY,
name VARCHAR(100) NOT NULL,
phone VARCHAR(15),
dob DATE
);

INSERT INTO patient(name, phone, dob)
VALUES ('Krishna', '999999999', '2002-05-02'), 
('Ram', '888888888', '2003-11-01'), 
('Kriti', '98989898998', '2001-08-26'),
('Anjali', '98744558578', '2000-02-09');

SELECT* FROM patient;

UPDATE patient SET phone = '8989898989' WHERE name = 'Krishna';
SELECT ROW_COUNT();


CREATE TABLE doctor(
doctor_id INT auto_increment PRIMARY KEY,
name VARCHAR(100),
speciality VARCHAR(50)
);

INSERT INTO doctor(name, speciality) 
VALUES
('Dr. Anita', 'cardiology'),
('Dr. Anil',  'Nephrology'),
('Dr.Lekha', 'Dermatology'),
('Dr.Radha', 'Neurology'),
('Dr. Anurag', 'Orthopedic');


SELECT* FROM doctor;




CREATE TABLE appointment (
appointment_id INT auto_increment PRIMARY KEY,
patient_id INT NOT NULL,
doctor_id INT NOT NULL,
appointment_date DATETIME NOT NULL,
status VARCHAR(20) DEFAULT 'SCHEDULED',

FOREIGN KEY (patient_id) REFERENCES patient(patient_id),
FOREIGN KEY (doctor_id) REFERENCES doctor(doctor_id)
);

INSERT INTO appointment(patient_id, doctor_id, appointment_date, status)
VALUES (1, 4, '2026-09-25', 'Pending'), (2, 4, '2026-08-08', 'Scheduled'), (2,2, '2026-08-20', 'Scheduled'), (3,1, '2026-08-15', 'Pending');

SELECT * FROM appointment;




SELECT p.name AS patient, d.name AS doctor, a.appointment_date
FROM appointment a
JOIN patient p ON a.patient_id = p.patient_id
JOIN doctor d  ON a.doctor_id  = d.doctor_id
ORDER BY a.appointment_date;



CREATE TABLE department(
department_id INT auto_increment PRIMARY KEY,
department_name VARCHAR(50) NOT NULL
);

SELECT * FROM department;
SELECT* FROM doctor;

ALTER TABLE doctor ADD department_id INT;
ALTER TABLE doctor ADD FOREIGN KEY (department_id) REFERENCES department(department_id);

INSERT INTO department(department_name)VALUES('Cardiology department'),
('Nephrology department'),
('Dermatology department'),
('Neurology department'), 
('Orthopedic department');

UPDATE doctor SET department_id = 1 WHERE speciality = 'Cardiology';
UPDATE doctor SET department_id = 2 WHERE speciality = 'Nephrology';
UPDATE doctor SET department_id = 3 WHERE speciality = 'Dermatology';
UPDATE doctor SET department_id = 4 WHERE speciality = 'Neurology';
UPDATE doctor SET department_id = 5 WHERE speciality = 'Orthopedic';



UPDATE department SET department_name = 'Cardiology Department' WHERE department_id = 1;
SELECT d.name, d.specialty, dep.department_name
FROM doctor d JOIN department dep ON d.department_id = dep.department_id;




-- UNNORMALIZED FLAT TABLE

CREATE TABLE appointment_bad(
appt_id INT auto_increment PRIMARY KEY,
patient_name varchar(50),
patient_phone VARCHAR(15),
doctor_name VARCHAR(50),
doctor_speciality VARCHAR(50),
app_date DATETIME
);

INSERT INTO appointment_bad (patient_name, patient_phone, doctor_name, doctor_speciality, app_date)
VALUES('Krishna', '989898989', 'Dr.Anita', 'Cardiology', '2026-08-09  10:00:00'), 
('Anikha', '5555555555', 'Dr. Anil', 'Nephrology', '2026-08-12  11:30:00');

INSERT INTO appointment_bad (patient_name, patient_phone, doctor_name, doctor_speciality, app_date)
VALUES('Krishna', '989898989', 'Dr.Anil', 'Nephrology', '2026-05-06 10:30:00'), 
('Devika', '8888888888', 'Dr. Anita', 'Cardiology','2026-08-25 11:00:00');

SELECT * FROM appointment_bad;

SET SQL_SAFE_UPDATES = 0;
UPDATE appointment_bad SET patient_phone = '999999999' WHERE patient_name = 'Krishna';

SELECT ROW_COUNT();

--------------------------------------------------------------------------------


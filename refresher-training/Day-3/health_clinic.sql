USE health_clinic;

SHOW tables;

SELECT * FROM doctor;
SELECT * FROM patient;
SELECT * FROM appointment;

-- TABLE ALTERTAION FOR JOINING TABLE - patient & doctor

ALTER TABLE patient RENAME COLUMN name TO patient_name;

ALTER TABLE doctor RENAME COLUMN name TO doctor_name;

ALTER TABLE patient ADD doctor_id INT;

UPDATE patient
SET doctor_id = 4
WHERE patient_id IN (1, 2);

UPDATE patient
SET doctor_id = 2
WHERE patient_id = 3;

UPDATE patient
SET doctor_id = 1
WHERE patient_id = 4;

-- ----------JOIN----------
-- INNER JOIN

SELECT 
p.patient_id, p.patient_name, d.doctor_name, d.speciality
FROM patient p 
JOIN doctor d 
   ON p.doctor_id = d.doctor_id;
   
-- LEFT JOIN

SELECT 
d.doctor_name, d.speciality, p.patient_id, p.patient_name
FROM patient p
LEFT JOIN doctor d
   ON p.doctor_id = d.doctor_id;
   

-- RIGHT JOIN

SELECT 
p.patient_id, p.patient_name
FROM patient p
RIGHT JOIN doctor d
   ON p.doctor_id = d.doctor_id;

-- FULL OUTER JOIN

SELECT p.patient_id, p.patient_name, p.phone, p.dob,
d.doctor_id, d.doctor_name, d.speciality, d.department_id
FROM patient p
LEFT JOIN doctor d
ON p.doctor_id = d.doctor_id

UNION

SELECT p.patient_id, p.patient_name, p.phone, p.dob,
d.doctor_id, d.doctor_name, d.speciality, d.department_id
FROM patient p
RIGHT JOIN doctor d
ON p.doctor_id = d.doctor_id;

-- Cross Join

SELECT *
FROM patient
CROSS JOIN doctor;




-- multi table joins

SELECT p.patient_name AS patient, d.doctor_name AS doctor, a.appointment_date
FROM appointment a
JOIN patient p ON a.patient_id = p.patient_id
JOIN doctor d  ON a.doctor_id  = d.doctor_id
ORDER BY a.appointment_date;


-- Stored procedure

DELIMITER $$

CREATE PROCEDURE get_all_appointments()
BEGIN
    SELECT 
        p.patient_name AS patient,
        d.doctor_name AS doctor,
        a.appointment_date,
        a.status
    FROM appointment a
    JOIN patient p 
        ON a.patient_id = p.patient_id
    JOIN doctor d 
        ON a.doctor_id = d.doctor_id
    ORDER BY a.appointment_date;
END $$

DELIMITER ;

CALL get_all_appointments();

-- Trigger

CREATE TABLE visit_history (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT,
    patient_id INT,
    doctor_id INT,
    visit_date DATETIME,
    status VARCHAR(20),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

SELECT * FROM visit_history;

DELIMITER $$

CREATE TRIGGER after_appointment_completed
AFTER UPDATE ON appointment
FOR EACH ROW
BEGIN

    IF NEW.status = 'Completed'
       AND OLD.status <> 'Completed' THEN

        INSERT INTO visit_history(appointment_id, patient_id, doctor_id, visit_date, status)
        VALUES(NEW.appointment_id, NEW.patient_id, NEW.doctor_id, NEW.appointment_date, NEW.status);

    END IF;
END $$
DELIMITER ;


SELECT * FROM appointment;

UPDATE appointment SET status = 'completed' WHERE appointment_id = 2;

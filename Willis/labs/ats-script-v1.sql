CREATE DATABASE ATSDB;
USE ATSDB;

-- MODULE 1 FLIGHT ---

-- MODULE 2 PLANE --

-- MODULE 3 BOOKING --
DROP TABLE BOOKING;
CREATE TABLE BOOKING
(
	BOOKING_ID INT PRIMARY KEY,
    CUSTOMER_NAME VARCHAR (30),
    BOOKING_DATE DATE,
    DEPARTURE VARCHAR(50),
    DESTINATION VARCHAR(50),
    SEAT_NO VARCHAR(15),
    COST FLOAT(10,2)
);
INSERT INTO `ECOMZ`.`bookings`
(`booking_id`,
`costof_flight`,
`customer_name`,
`date_of_flight`,
`departure`,
`destination`,
`seat_no`)
VALUES
(1,
200,
'mr tan',
'12-12-2020',
'Japan',
'Singapore',
'e7');


INSERT INTO BOOKING (BOOKING_ID,CUSTOMER_NAME,BOOKING_DATE,DEPARTURE,DESTINATION,SEAT_NO,COST)
SELECT 1,'DAVID','2020-05-12','Singapore','Japan',1,1000.0
UNION ALL
SELECT 2,'JOSHUA','2021-06-12','Singapore','America',1,1000.0
UNION ALL
SELECT 3,'JEAN','2020-07-12','Singapore','Canada',1,1000.0
UNION ALL
SELECT 4,'EMILY','2020-09-12','Singapore','Italy',1,1000.0;

SELECT * FROM BOOKING;

UPDATE BOOKING SET BOOKING_DATE = '2021-05-12' WHERE BOOKING_ID = 1;
UPDATE BOOKING SET BOOKING_DATE = '2021-07-12' WHERE BOOKING_ID = 3;
UPDATE BOOKING SET BOOKING_DATE = '2021-09-12', Customer_name = 'johnny' WHERE BOOKING_ID = 4;
UPDATE BOOKING SET DESTINATION = 'INDONESIA' WHERE BOOKING_ID = 1;

DELETE FROM BOOKING WHERE BOOKING_ID = 9;

-- MODULE 4 AIRPORTS -- 
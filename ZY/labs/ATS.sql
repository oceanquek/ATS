USE ATS;
CREATE TABLE AIRPORT(
   AIRPORT_ID INT PRIMARY KEY AUTO_INCREMENT,
   CODE VARCHAR(10),
   NAME VARCHAR(50),
   COUNTRY_ID INT,
    -- FOREIGN KEY
    FOREIGN KEY(COUNTRY_ID) REFERENCES COUNTRY (COUNTRY_ID)
);

CREATE TABLE COUNTRY(
	COUNTRY_ID INT PRIMARY KEY AUTO_INCREMENT,
	COUNTRY_NAME VARCHAR(50),
	CITY VARCHAR(50),
	STATE VARCHAR(50)
);


INSERT INTO COUNTRY (COUNTRY_NAME,CITY,STATE)
 values
('Singapore', 'Singapore', 'Singapore'),
('China', 'Shang Hai', 'Shang Hai'),
('China', 'Bei Jing', 'Bei Jing'),
('United States', 'Los Angeles', 'California'),
('United States', 'Chicago', 'Illinois'),
('United States', 'San Diego', 'California');

select * from Country;
CREATE TABLE DRONE(
                      ID INT AUTO_INCREMENT PRIMARY KEY,
                      SERIAL_NUMBER INT NOT NULL ,
                      MODEL VARCHAR(255) NOT NULL ,
                      WEIGHT_LIMIT FLOAT NOT NULL ,
                      BATTERY_CAPACITY FLOAT NOT NULL ,
                      STATE VARCHAR(255) NOT NULL,
                      IS_ACTIVE VARCHAR(255) NOT NULL

);

CREATE TABLE MEDICATION(
                           ID INT AUTO_INCREMENT PRIMARY KEY,
                           NAME VARCHAR(255) NOT NULL ,
                           WEIGHT FLOAT NOT NULL ,
                           CODE VARCHAR(255) NOT NULL ,
                           IMAGE VARCHAR NOT NULL

);
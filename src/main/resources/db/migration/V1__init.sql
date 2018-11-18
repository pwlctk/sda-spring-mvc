--- recources->db->migration->V1__init.sql
CREATE TABLE CUSTOMER(
    ID INTEGER auto_increment NOT NULL,
    ADDRESS_LINE VARCHAR(255),
    CITY VARCHAR(255),
    EMAIL VARCHAR(255),
    FIRST_NAME VARCHAR(255),
    LAST_NAME VARCHAR(255),
    PHONE_NUMBER VARCHAR(255),
    ZIP_CODE VARCHAR(255),
    PRIMARY KEY (ID)
);

CREATE TABLE PRODUCT(
    ID INTEGER auto_increment NOT NULL,
    DESCRIPTION VARCHAR(255),
    Price INTEGER,
    imageUrl VARCHAR(255),
    PRIMARY KEY (ID)
);

INSERT INTO CUSTOMER(ADDRESS_LINE, CITY, EMAIL, FIRST_NAME, LAST_NAME ,PHONE_NUMBER, ZIP_CODE)
VALUES('Malmeda 111','Warszawa','test@example.com','Karol','Karolak','999 888 777','00-999'),
('Malmeda 222','Warszawa','test@example.com','Karol','Karolak','999 888 555','11-999'),
('Malmeda 333','Warszawa','test@example.com','Karol','Karolak','999 888 555','22-999'),
('Uboga 4','Warszawa','test@example.com','Karol','Karolak','999 888 555','33-999');

INSERT INTO PRODUCT(DESCRIPTION, Price, imageUrl)
VALUES('Stolik do kawy',10,'www.soliki.pl/stolik_do_kawy'),

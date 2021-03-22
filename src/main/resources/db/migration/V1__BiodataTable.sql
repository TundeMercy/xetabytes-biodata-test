CREATE TABLE biodata (
    id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(5) NOT NULL,
    phone_number VARCHAR(15),
    email VARCHAR(100),
    about VARCHAR(255)
);
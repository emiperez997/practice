DROP DATABASE practice_task;
 
CREATE DATABASE IF NOT EXISTS practice_task;

DROP TABLE users;

CREATE TABLE users (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NULL,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

INSERT INTO users(first_name, last_name, username, email, password)
VALUES 
("Emi", "Perez", "emiperez", "emi.perez997@gmail.com", "123456"),
("Yesi", "Perez", "yesiperez", "yessi.perez@gmail.com", "123456"),
("Facu", "Perez", "facuperez", "facu.perez@gmail.com", "123456"),
("Juan", "Perez", "juanperez", "juan.perez@gmail.com", "123456");

CREATE TABLE task (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    done BOOLEAN NOT NULL DEFAULT false,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO task(title, description, done, user_id)
VALUES
("Estudiar", "Estudiar en platzi", false, 1),
("Trabajar", "Trabajar en la pelu 8hs", false, 2),
("Ir al racimo", "Preparar la casa para el racimo", true, 3),
("Preparar la Palabra", "Armar la palabra para jóvenes", false, 3),
("Comer", "Comer alta pizza", false, 4);
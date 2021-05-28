CREATE DATABASE products_ex CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# +------------------+--------------+------+-----+---------+----------------+
# | Field            | Type         | Null | Key | Default | Extra          |
# +------------------+--------------+------+-----+---------+----------------+
# | id               | int(11)      | NO   | PRI | NULL    | auto_increment |
# | email            | varchar(255) | NO   | UNI | NULL    |                |
# | username         | varchar(255) | NO   |     | NULL    |                |
# | password         | varchar(60)  | NO   |     | NULL    |                |
# +------------------+--------------+------+-----+---------+----------------+

CREATE TABLE users (
    id INT(11) NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL DEFAULT '' UNIQUE,
    username VARCHAR(255) NOT NULL DEFAULT '',
    password VARCHAR(60) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);


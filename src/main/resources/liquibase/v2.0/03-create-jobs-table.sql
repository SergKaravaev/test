CREATE TABLE IF NOT EXISTS jobs (
id BIGINT NOT NULL AUTO_INCREMENT,
type_of_work VARCHAR(20) NOT NULL,
price FLOAT NOT NULL,
PRIMARY KEY(id));
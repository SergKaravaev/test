CREATE TABLE IF NOT EXISTS users_serv  (
id BIGINT NOT NULL AUTO_INCREMENT,
id_users BIGINT NOT NULL,
id_serv BIGINT NOT NULL,
work_employee VARCHAR(50),
PRIMARY KEY(id),
CONSTRAINT users_serv_ibfk_1 FOREIGN KEY (id_users) REFERENCES users(id),
CONSTRAINT users_serv_ibfk_2 FOREIGN KEY (id_serv) REFERENCES serv(id));

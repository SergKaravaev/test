CREATE TABLE IF NOT EXISTS users_services  (
id BIGINT NOT NULL AUTO_INCREMENT,
id_users BIGINT NOT NULL,
id_services BIGINT NOT NULL,
work_employee VARCHAR(50),
PRIMARY KEY(id),
CONSTRAINT users_services_ibfk_1 FOREIGN KEY (id_users) REFERENCES users(id),
CONSTRAINT users_services_ibfk_2 FOREIGN KEY (id_services) REFERENCES services(id));

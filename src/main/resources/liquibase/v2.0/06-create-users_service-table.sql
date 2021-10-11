CREATE TABLE IF NOT EXISTS users_service  (
id BIGINT NOT NULL AUTO_INCREMENT,
id_users BIGINT NOT NULL,
id_service BIGINT NOT NULL,
work_employee VARCHAR(50),
PRIMARY KEY(id),
CONSTRAINT employee_service_ibfk_1 FOREIGN KEY (id_users) REFERENCES users(id),
CONSTRAINT employee_service_ibfk_2 FOREIGN KEY (id_service) REFERENCES service(id));

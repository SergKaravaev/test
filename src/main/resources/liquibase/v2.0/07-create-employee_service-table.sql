CREATE TABLE IF NOT EXISTS employee_service  (
id BIGINT NOT NULL AUTO_INCREMENT,
id_employee BIGINT NOT NULL,
id_service BIGINT NOT NULL,
work_employee VARCHAR(50),
PRIMARY KEY(id),
CONSTRAINT employee_service_ibfk_1 FOREIGN KEY (id_employee) REFERENCES employee(id),
CONSTRAINT employee_service_ibfk_2 FOREIGN KEY (id_service) REFERENCES service(id));

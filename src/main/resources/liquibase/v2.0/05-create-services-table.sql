CREATE TABLE IF NOT EXISTS services (
id BIGINT NOT NULL AUTO_INCREMENT,
id_jobs BIGINT NOT NULL,
id_sto BIGINT NOT NULL,
# Comment
-- data DATE NOT NULL,
/* Comment */
services_price FLOAT NOT NULL,
PRIMARY KEY(id),
CONSTRAINT services_ibfk_1 FOREIGN KEY (id_jobs) REFERENCES jobs(id),
CONSTRAINT services_ibfk_2 FOREIGN KEY (id_sto) REFERENCES sto(id));

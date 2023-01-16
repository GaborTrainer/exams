CREATE TABLE IF NOT EXISTS ratings (
id BIGINT NOT NULL AUTO_INCREMENT,
nickname VARCHAR(50),
month INT,
task_nr int,
rating INT,
PRIMARY KEY (id))
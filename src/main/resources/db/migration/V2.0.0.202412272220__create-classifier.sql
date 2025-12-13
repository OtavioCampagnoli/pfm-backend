CREATE TABLE IF NOT EXISTS classifier(
    cla_id int NOT NULL AUTO_INCREMENT,
    value VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    label VARCHAR(100) NOT NULL,
    description VARCHAR(150) DEFAULT NULL,
    UNIQUE (value, type),
    PRIMARY KEY (cla_id)
);
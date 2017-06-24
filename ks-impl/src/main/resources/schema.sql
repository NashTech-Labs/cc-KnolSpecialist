DROP TABLE IF EXISTS technologies;

CREATE TABLE IF NOT EXISTS technologies (
t_id INT(5) PRIMARY KEY,
t_name VARCHAR(255) NOT NULL,
);

DROP TABLE IF EXISTS knolders;

CREATE TABLE IF NOT EXISTS knolders (
k_id INT(5) PRIMARY KEY,
k_name VARCHAR(255) NOT NULL,
k_desg VARCHAR(255) NOT NULL,
);

DROP TABLE IF EXISTS experts;

CREATE TABLE IF NOT EXISTS experts (
k_id INT(5) references knolders(k_id),
t_id INT(5) references technologies(t_id),
skill_level INT(5) NOT NULL,
);
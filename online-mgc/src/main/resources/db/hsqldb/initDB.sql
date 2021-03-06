
DROP TABLE users IF EXISTS;

DROP TABLE packages IF EXISTS;

DROP TABLE package_details IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  user_name VARCHAR(100),
  password  VARCHAR(100),
  user_role VARCHAR(50),
  fail_times INTEGER,
  is_locked BOOLEAN,
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

CREATE INDEX users_user_name ON users (user_name);

CREATE TABLE packages (
  id INTEGER IDENTITY PRIMARY KEY,
  package_name VARCHAR(100),
  production_name VARCHAR(100),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_by INTEGER DEFAULT NULL
);

CREATE INDEX packages_package_name ON packages (package_name);
CREATE INDEX packages_production_name ON packages (production_name);
CREATE INDEX packages_created_date ON packages (created_date);

CREATE TABLE package_details (
  id INTEGER IDENTITY PRIMARY KEY,
  package_id INTEGER,
  detail_date TIMESTAMP,
  installations INTEGER,
  activations INTEGER,
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_by INTEGER DEFAULT NULL
);

CREATE INDEX package_details_package_id ON package_details (package_id);
CREATE INDEX package_details_detail_date ON package_details (detail_date);
ALTER TABLE package_details ADD CONSTRAINT fk_package_details_package_id FOREIGN KEY (package_id) REFERENCES packages (id);



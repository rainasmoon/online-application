
DROP TABLE users IF EXISTS;

DROP TABLE packages IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  user_name VARCHAR(100),
  password  VARCHAR(100),
  user_role VARCHAR(50),
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
  installations INTEGER,
  activations INTEGER,
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER DEFAULT NULL,
  updated_by INTEGER DEFAULT NULL
);

CREATE INDEX packages_package_name ON packages (package_name);
CREATE INDEX packages_production_name ON packages (production_name);
CREATE INDEX packages_created_date ON packages (created_date);

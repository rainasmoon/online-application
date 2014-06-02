DROP TABLE applications IF EXISTS;
DROP TABLE users IF EXISTS;



CREATE TABLE applications (
  id INTEGER IDENTITY PRIMARY KEY,
  application_id VARCHAR(40),
  application_name  VARCHAR(100),
  application_platform  VARCHAR(10),
  application_package_name  VARCHAR(500),
  status  VARCHAR(10),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  email VARCHAR(100),
  password  VARCHAR(100),
  qq  VARCHAR(10),
  mobile  VARCHAR(500),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

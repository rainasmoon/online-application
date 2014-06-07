
DROP TABLE users IF EXISTS;

DROP TABLE applications IF EXISTS;
DROP TABLE app_parameters IF EXISTS;

DROP TABLE checks IF EXISTS;
DROP TABLE bonus IF EXISTS;

DROP TABLE sdks IF EXISTS;

DROP TABLE dictionary IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  email VARCHAR(100),
  password  VARCHAR(100),
  qq  VARCHAR(20),
  mobile  VARCHAR(20),
  contact_type VARCHAR(20),
  contact_name VARCHAR(100),
  contact_id_number VARCHAR(20),
  bank_name VARCHAR(100),
  province_id INTEGER,
  city_id INTEGER,
  branch_name VARCHAR(200),
  account_number VARCHAR(50),
  id_card_front_path VARCHAR(100),
  id_card_back_path VARCHAR(100),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);


CREATE TABLE applications (
  id INTEGER IDENTITY PRIMARY KEY,
  dianjoy_app_id VARCHAR(40),
  application_name  VARCHAR(100),
  application_platform  VARCHAR(10),
  application_package_name  VARCHAR(500),
  status  VARCHAR(50),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

CREATE TABLE app_parameters (
  id INTEGER IDENTITY PRIMARY KEY,
  application_id INTEGER,
  param_name  VARCHAR(100),
  param_value  VARCHAR(100),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

CREATE TABLE checks (
  id INTEGER IDENTITY PRIMARY KEY,
  contact_name VARCHAR(100),
  contact_id_number VARCHAR(20),
  bank_name VARCHAR(100),
  bank_address VARCHAR(200),
  account_number VARCHAR(50),  
  apply_amount DOUBLE,
  status VARCHAR(50),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

CREATE TABLE bonus (
  id INTEGER IDENTITY PRIMARY KEY,
  amount DOUBLE,
  reason VARCHAR(200),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INTEGER,
  updated_by INTEGER
);

CREATE TABLE sdks (
  id INTEGER IDENTITY PRIMARY KEY,
  platform VARCHAR(10),
  sdk_type VARCHAR(50),
  version VARCHAR(20),
  download_path VARCHAR(100)
);

CREATE TABLE dictionary (
  id INTEGER IDENTITY PRIMARY KEY,
  data_type VARCHAR(20),
  dictionary_key INTEGER,
  dictionary_value VARCHAR(200)
);

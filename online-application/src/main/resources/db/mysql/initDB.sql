CREATE DATABASE IF NOT EXISTS onlineapp;
GRANT ALL PRIVILEGES ON onlineapp.* TO pc@localhost IDENTIFIED BY 'pc';

USE onlineapp;

CREATE TABLE IF NOT EXISTS users (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100),  
  password  VARCHAR(100),
  qq  VARCHAR(20),
  mobile  VARCHAR(20),
  contact_type VARCHAR(20),
  contact_name VARCHAR(100),
  contact_id_number VARCHAR(20),
  bank_name VARCHAR(100),
  province_id INT(4),
  city_id INT(4),
  branch_name VARCHAR(200),
  account_number VARCHAR(50),
  id_card_front_path VARCHAR(100),
  id_card_back_path VARCHAR(100),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4),
  updated_by INT(4),  
  INDEX(email)
) engine=InnoDB CHARSET=utf8;


CREATE TABLE IF NOT EXISTS applications (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  dianjoy_app_id VARCHAR(40),
  application_name  VARCHAR(100),
  application_platform  VARCHAR(10),
  application_package_name  VARCHAR(500),
  status  VARCHAR(50),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,
  FOREIGN KEY (created_by) REFERENCES users(id),
  FOREIGN KEY (updated_by) REFERENCES users(id)
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS app_parameters (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  application_id INT(4),
  param_name  VARCHAR(100),
  param_value  VARCHAR(100),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,
  FOREIGN KEY (created_by) REFERENCES users(id),
  FOREIGN KEY (updated_by) REFERENCES users(id)
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS checks (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  contact_name VARCHAR(100),
  contact_id_number VARCHAR(20),
  bank_name VARCHAR(100),
  bank_address VARCHAR(200),
  account_number VARCHAR(50),  
  apply_amount DOUBLE,
  status VARCHAR(50),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,
  FOREIGN KEY (created_by) REFERENCES users(id),
  FOREIGN KEY (updated_by) REFERENCES users(id)
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS bonus (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  amount DOUBLE,
  reason VARCHAR(200),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,
  FOREIGN KEY (created_by) REFERENCES users(id),
  FOREIGN KEY (updated_by) REFERENCES users(id)
  ) engine=InnoDB CHARSET=utf8;


CREATE TABLE IF NOT EXISTS sdks (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  platform VARCHAR(10),
  sdk_type VARCHAR(50),
  version VARCHAR(20),
  download_path VARCHAR(100),
  download_name VARCHAR(500)
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS dictionary (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  data_type VARCHAR(20),
  dictionary_key INT(4) UNSIGNED,
  dictionary_value VARCHAR(200),
  INDEX(dictionary_key),
  FOREIGN KEY (dictionary_key) REFERENCES dictionary(id)
) engine=InnoDB CHARSET=utf8;


drop database if exists onlinemgc;

CREATE DATABASE IF NOT EXISTS onlinemgc;
GRANT ALL PRIVILEGES ON onlinemgc.* TO pc@localhost IDENTIFIED BY 'pc';

USE onlinemgc;

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


CREATE TABLE IF NOT EXISTS packages (
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
  INDEX(created_by),
  FOREIGN KEY (created_by) REFERENCES users(id),
  FOREIGN KEY (updated_by) REFERENCES users(id)
) engine=InnoDB CHARSET=utf8;


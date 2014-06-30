drop database if exists onlinemgc;

CREATE DATABASE IF NOT EXISTS onlinemgc;
GRANT ALL PRIVILEGES ON onlinemgc.* TO pc@localhost IDENTIFIED BY 'pc';

USE onlinemgc;

CREATE TABLE IF NOT EXISTS users (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_name VARCHAR(100),
  password  VARCHAR(100),
  user_role VARCHAR(50),
  fail_times INT(4) UNSIGNED,
  is_locked  TINYINT(1),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,  
  INDEX(user_name)
) engine=InnoDB CHARSET=utf8;


CREATE TABLE IF NOT EXISTS packages (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  package_name VARCHAR(100),
  production_name VARCHAR(100),  
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,
  INDEX(package_name),
  INDEX(production_name),
  INDEX(created_date)
 ) engine=InnoDB CHARSET=utf8;
 
 CREATE TABLE IF NOT EXISTS package_details (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  package_id INT(4) UNSIGNED,
  detail_date TIMESTAMP,
  installations INT(4) UNSIGNED,
  activations INT(4) UNSIGNED,
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(4) UNSIGNED,
  updated_by INT(4) UNSIGNED,
  INDEX(package_id),
  INDEX(detail_date),
  FOREIGN KEY (package_id) REFERENCES packages(id)
 ) engine=InnoDB CHARSET=utf8;


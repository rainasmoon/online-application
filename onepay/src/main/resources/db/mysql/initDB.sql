drop database if exists onepayapp;

CREATE DATABASE IF NOT EXISTS onepayapp;
GRANT ALL PRIVILEGES ON onepayapp.* TO pc@localhost IDENTIFIED BY 'bsnpb6p';

USE onepayapp;

CREATE TABLE IF NOT EXISTS users (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100),
  phone VARCHAR(100),
  password VARCHAR(100),
  nick_name VARCHAR(100),
  sell_amount INT(8),
  buy_amount INT(8),
  total_amount INT(8),
  account INT(8),
  freeze_account INT(8),
  level TINYINT UNSIGNED,
  credit INT(8),
  is_email_confirmed BOOLEAN,
  is_phone_confirmed BOOLEAN,
  create_date TIMESTAMP,
  UNIQUE (email),
  UNIQUE (phone),
  INDEX(email),
  INDEX(phone),
  INDEX(total_amount)
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS products (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  original_price INT(8) UNSIGNED,
  price INT(8) UNSIGNED,
  owner_id INT(8) UNSIGNED,
  current_bider_id INT(8) UNSIGNED,
  sale_model TINYINT UNSIGNED,
  status TINYINT UNSIGNED,
  end_date TIMESTAMP,
  aging TINYINT UNSIGNED,
  description VARCHAR(600),
  create_date TIMESTAMP  
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS pictures (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  product_id INT(8) UNSIGNED,
  pic_path VARCHAR(100),
  create_date TIMESTAMP
  
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS tags (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  obj_id INT(8) UNSIGNED,
  name VARCHAR(100),
  tag_type TINYINT UNSIGNED,
  create_date TIMESTAMP,
  index(name)
  
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS bidlogs (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(8) UNSIGNED,
  product_id INT(8) UNSIGNED,
  price INT(8) UNSIGNED,
  create_date TIMESTAMP
  
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS orders (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  saler_id INT(8) UNSIGNED,
  buyer_id INT(8) UNSIGNED,
  product_id INT(8) UNSIGNED,
  price INT(8) UNSIGNED,
  sender_name VARCHAR(100),
  sender_phone VARCHAR(100),
  sender_address VARCHAR(200),
  sender_postcode VARCHAR(100),
  receiver_name VARCHAR(100),
  receiver_phone VARCHAR(100),
  receiver_address VARCHAR(200),
  receiver_postcode VARCHAR(100),
  sender_stars TINYINT UNSIGNED,
  receiver_stars TINYINT UNSIGNED,
  status TINYINT UNSIGNED,
  create_date TIMESTAMP
 ) engine=InnoDB CHARSET=utf8;
 CREATE TABLE IF NOT EXISTS yunorders (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(8) UNSIGNED,
  dealer_id INT(8) UNSIGNED,
  model TINYINT UNSIGNED,
  trade_way TINYINT UNSIGNED,
  amount INT(8) UNSIGNED,
  price INT(8) UNSIGNED,
  status TINYINT UNSIGNED,
  verify_code VARCHAR(100),
  description VARCHAR(600),
  create_date TIMESTAMP
 ) engine=InnoDB CHARSET=utf8;
 
  CREATE TABLE  IF NOT EXISTS accountlogs (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(8) UNSIGNED,
  change_amount INT(8),
  balance INT(8),
  account_log_type TINYINT UNSIGNED,
  description VARCHAR(600),
  create_date TIMESTAMP
) engine=InnoDB CHARSET=utf8;

CREATE TABLE reset_password_applications (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  login_account VARCHAR(100),
  description VARCHAR(600),
  password1 VARCHAR(100),
  password2 VARCHAR(100),
  password3 VARCHAR(100),
  receive_reset_email VARCHAR(100), 
  create_date TIMESTAMP
)engine=InnoDB CHARSET=utf8;

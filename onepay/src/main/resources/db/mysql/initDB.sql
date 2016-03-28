drop database if exists onepayapp;

CREATE DATABASE IF NOT EXISTS onepayapp;
GRANT ALL PRIVILEGES ON onepayapp.* TO pc@localhost IDENTIFIED BY 'pc';

USE onepayapp;

CREATE TABLE IF NOT EXISTS users (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100),  
  password  VARCHAR(100),
  qq  VARCHAR(20),
  mobile  VARCHAR(20),
  contact_type VARCHAR(20),
  contact_name VARCHAR(100),
  contact_id_number VARCHAR(20),
  bank_name VARCHAR(100),
  province_id INT(8) UNSIGNED,
  city_id INT(8) UNSIGNED,
  branch_name VARCHAR(200),
  account_number VARCHAR(50),
  id_card_front_path VARCHAR(100),
  id_card_back_path VARCHAR(100),
  created_date  TIMESTAMP,
  updated_date  TIMESTAMP,
  created_by INT(8) UNSIGNED,
  updated_by INT(8) UNSIGNED,  
  UNIQUE (email),
  INDEX(email)
) engine=InnoDB CHARSET=utf8;

CREATE TABLE IF NOT EXISTS users (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(100),
  phone VARCHAR(100),
  password VARCHAR(100),
  nick_name VARCHAR(100),
  sell_amount INT(8) UNSIGNED,
  buy_amount INT(8) UNSIGNED,
  total_amount INT(8) UNSIGNED,
  account INT(8) UNSIGNED,
  freeze_account INT(8) UNSIGNED,
  level INT(8) UNSIGNED,
  credit INT(8) UNSIGNED,
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
  sale_model INT(8) UNSIGNED,
  status INT(8) UNSIGNED,
  end_date TIMESTAMP,
  aging INT(8) UNSIGNED,
  description VARCHAR(100),
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
  tag_type INT(8) UNSIGNED,
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
  sender_address VARCHAR(100),
  sender_postcode VARCHAR(100),
  receiver_name VARCHAR(100),
  receiver_phone VARCHAR(100),
  receiver_address VARCHAR(100),
  receiver_postcode VARCHAR(100),
  sender_stars INT(8) UNSIGNED,
  receiver_stars INT(8) UNSIGNED,
  status INT(8) UNSIGNED,
  create_date TIMESTAMP
 ) engine=InnoDB CHARSET=utf8;
 CREATE TABLE IF NOT EXISTS yunorders (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(8) UNSIGNED,
  dealer_id INT(8) UNSIGNED,
  model INT(8) UNSIGNED,
  trade_way INT(8) UNSIGNED,
  amount INT(8) UNSIGNED,
  price INT(8) UNSIGNED,
  status INT(8) UNSIGNED,
  verify_code VARCHAR(100),
  description VARCHAR(100),
  create_date TIMESTAMP
 ) engine=InnoDB CHARSET=utf8;

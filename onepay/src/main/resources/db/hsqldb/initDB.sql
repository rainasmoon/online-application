DROP TABLE users IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE pictures IF EXISTS;
DROP TABLE tags IF EXISTS;

DROP TABLE bidlogs IF EXISTS;

DROP TABLE orders IF EXISTS;
DROP TABLE yunorders IF EXISTS;

DROP TABLE accountlogs IF EXISTS;

DROP TABLE accesslogs IF EXISTS;

DROP TABLE reset_password_applications IF EXISTS;


CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  email VARCHAR(100),
  phone VARCHAR(100),
  password VARCHAR(100),
  nick_name VARCHAR(100),
  sell_amount INTEGER,
  buy_amount INTEGER,
  total_amount INTEGER,
  account INTEGER,
  freeze_account INTEGER,
  level INTEGER,
  credit INTEGER,
  is_email_confirmed BOOLEAN,
  is_phone_confirmed BOOLEAN,
  create_date TIMESTAMP
);

CREATE TABLE products (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(100),
  original_price INTEGER,
  price INTEGER,
  owner_id INTEGER,
  current_bider_id INTEGER,
  sale_model INTEGER,
  status INTEGER,
  end_date TIMESTAMP,
  aging INTEGER,
  description VARCHAR(600),
  create_date TIMESTAMP
);

CREATE TABLE pictures (
  id INTEGER IDENTITY PRIMARY KEY,
  product_id INTEGER,
  pic_path VARCHAR(100),
  create_date TIMESTAMP
  
);

CREATE TABLE tags (
  id INTEGER IDENTITY PRIMARY KEY,
  obj_id INTEGER,
  name VARCHAR(100),
  tag_type INTEGER,
  create_date TIMESTAMP
  
);

CREATE TABLE bidlogs (
  id INTEGER IDENTITY PRIMARY KEY,
  user_id INTEGER,
  product_id INTEGER,
  price INTEGER,
  create_date TIMESTAMP
  
);

CREATE TABLE orders (
  id INTEGER IDENTITY PRIMARY KEY,
  saler_id INTEGER,
  buyer_id INTEGER,
  product_id INTEGER,
  price INTEGER,
  sender_name VARCHAR(100),
  sender_phone VARCHAR(100),
  sender_address VARCHAR(100),
  sender_postcode VARCHAR(100),
  receiver_name VARCHAR(100),
  receiver_phone VARCHAR(100),
  receiver_address VARCHAR(100),
  receiver_postcode VARCHAR(100),
  sender_stars INTEGER,
  receiver_stars INTEGER,
  status INTEGER,
  create_date TIMESTAMP
 );
 CREATE TABLE yunorders (
  id INTEGER IDENTITY PRIMARY KEY,
  user_id INTEGER,
  dealer_id INTEGER,
  model INTEGER,
  trade_way INTEGER,
  amount INTEGER,
  price INTEGER,
  status INTEGER,
  verify_code VARCHAR(100),
  description VARCHAR(600),
  create_date TIMESTAMP
 );
 
 CREATE TABLE accountlogs (
  id INTEGER IDENTITY PRIMARY KEY,
  user_id INTEGER,
  change_amount INTEGER,
  balance INTEGER,
  account_log_type INTEGER,
  description VARCHAR(600),
  create_date TIMESTAMP
);

CREATE TABLE reset_password_applications (
  id INTEGER IDENTITY PRIMARY KEY,
  login_account VARCHAR(100),
  description VARCHAR(600),
  password1 VARCHAR(100),
  password2 VARCHAR(100),
  password3 VARCHAR(100),
  receive_reset_email VARCHAR(100), 
  ip_address VARCHAR(100), 
  user_agent VARCHAR(100), 
  create_date TIMESTAMP
);

CREATE TABLE accesslogs (
  id INTEGER IDENTITY PRIMARY KEY,
  user_id INTEGER,
  ip VARCHAR(60),
  client VARCHAR(600),
  url VARCHAR(600),
  cookie_id VARCHAR(60),
  session_id VARCHAR(60),
  create_date TIMESTAMP
);

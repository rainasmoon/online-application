DROP TABLE users IF EXISTS;
DROP TABLE products IF EXISTS;
DROP TABLE pictures IF EXISTS;
DROP TABLE tags IF EXISTS;

DROP TABLE bidlogs IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  email VARCHAR(100),
  phone VARCHAR(100),
  password VARCHAR(100),
  nick_name VARCHAR(100),
  sell_amount INTEGER,
  buy_amount INTEGER,
  total_amount INTEGER,
  level INTEGER,
  credit INTEGER
);

CREATE TABLE products (
  id INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(100),
  price INTEGER,
  owner_id INTEGER,
  current_bider_id INTEGER,
  sale_model INTEGER,
  date_from TIMESTAMP,
  date_to TIMESTAMP,
  aging INTEGER,
  description VARCHAR(100)
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
  tag_type INTEGER
  
);

CREATE TABLE bidlogs (
  id INTEGER IDENTITY PRIMARY KEY,
  user_id INTEGER,
  product_id INTEGER,
  price INTEGER,
  create_date TIMESTAMP
  
);

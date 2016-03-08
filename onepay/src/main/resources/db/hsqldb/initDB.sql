DROP TABLE users IF EXISTS;
DROP TABLE tags IF EXISTS;

CREATE TABLE users (
  id INTEGER IDENTITY PRIMARY KEY,
  email VARCHAR(100),
  phone VARCHAR(100),
  password VARCHAR(100),
  nick_name VARCHAR(100),
  sell_amount INTEGER,
  buy_amount INTEGER,
  total_amount INTEGER,
  level INTEGER
);

CREATE TABLE tags (
  id INTEGER IDENTITY PRIMARY KEY,
  obj_id INTEGER,
  name VARCHAR(100),
  tag_type VARCHAR(100)
  
);


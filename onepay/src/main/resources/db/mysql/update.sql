alter table users add is_email_confirmed BOOLEAN;
alter table users add is_phone_confirmed BOOLEAN;

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

alter table reset_password_applications add ip_address VARCHAR(100);
alter table reset_password_applications add user_agent VARCHAR(100);


--8.16


CREATE TABLE  IF NOT EXISTS feedbacks (
  id INT(8) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  user_id INT(8) UNSIGNED,
  name VARCHAR(100),
  content VARCHAR(600),
  email VARCHAR(100),
  phone VARCHAR(100),
  ip VARCHAR(60),
  client VARCHAR(600),  
  create_date TIMESTAMP
) engine=InnoDB CHARSET=utf8;




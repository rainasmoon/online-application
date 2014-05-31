DROP TABLE applications IF EXISTS;



CREATE TABLE applications (
  id         INTEGER IDENTITY PRIMARY KEY,
  application_id VARCHAR(30),
  created_date  DATE,
  application_name  VARCHAR(30),
  application_platform  VARCHAR(30),
  application_package_name  VARCHAR(30),
  status  VARCHAR(30),
);



mysql> CREATE DATABASE testdb;


mysql> CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'test623';


mysql> USE testdb;


mysql> GRANT ALL ON testdb.* TO 'testuser'@'localhost';

mysql> quit;


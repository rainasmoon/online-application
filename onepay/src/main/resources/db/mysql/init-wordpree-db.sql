-- 100, 200, 600, 60
drop database if exists wordpress;

CREATE DATABASE IF NOT EXISTS wordpress;
GRANT ALL PRIVILEGES ON wordpress.* TO wp@localhost IDENTIFIED BY 'bsnpb6p';

USE wordpress;
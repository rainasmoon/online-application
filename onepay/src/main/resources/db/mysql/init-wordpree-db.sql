-- 100, 200, 600, 60
drop database if exists wordpress;

CREATE DATABASE IF NOT EXISTS wordpress DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
GRANT ALL PRIVILEGES ON wordpress.* TO wp@localhost IDENTIFIED BY 'bsnpb6p';

USE wordpress;
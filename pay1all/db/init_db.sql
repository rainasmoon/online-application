drop database if exists online_db;

CREATE DATABASE IF NOT EXISTS online_db;
GRANT ALL PRIVILEGES ON online_db.* TO pc@localhost IDENTIFIED BY 'pc';
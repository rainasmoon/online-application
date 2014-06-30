USE onlinemgc;

INSERT IGNORE INTO users VALUES (1, 'manager', 'test', 'manager', 0, 0, '2013-09-07','2010-09-07', 1, 1);
INSERT IGNORE INTO users VALUES (2, 'user', 'test', 'user', 0, 0, '2013-09-07','2010-09-07', 1, 1);

INSERT IGNORE INTO packages VALUES (1, 'djz_21.apk', '大家赚', '2013-09-07','2010-09-07', 1, 1);

INSERT IGNORE INTO package_details VALUES (1, 1, '2013-09-07', 1000, 2000, '2013-09-07','2010-09-07', 1, 1);
INSERT IGNORE INTO package_details VALUES (2, 1, '2013-09-07', 1500, 2500, '2013-09-07','2010-09-07', 1, 1);
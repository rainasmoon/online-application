USE onepayapp;

INSERT IGNORE INTO users values(1, 'test@test.c', '1', '1', '测试账户', 0, 0, 0, 100, 0, 0, 0, null);
INSERT IGNORE INTO users values(2, 'test@test.c', '2', '2', '测试账户2', 0, 0, 0, 0, 0, 0, 0, null);

INSERT IGNORE INTO products values(1, '测试商品', 1, 1, 1, 1, 1, 1, null, 10, '测试的第一个商品', null);
INSERT IGNORE INTO products values(2, '测试商品2', 1, 1, 1, 1, 2, 1, null, 10, '测试的第2个商品', null);
INSERT IGNORE INTO products values(3, '测试商品3', 1, 1, 1, 1, 3, 1, null, 10, '测试的第3个商品', null);

INSERT IGNORE INTO orders values(1, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 1, null);
INSERT IGNORE INTO orders values(2, 2, 1, 2, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 2, null);
INSERT IGNORE INTO orders values(3, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 3, null);
INSERT IGNORE INTO orders values(4, 2, 1, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 4, null);
INSERT IGNORE INTO orders values(5, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 5, null);
INSERT IGNORE INTO orders values(6, 1, 2, 3, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 6, null);
INSERT IGNORE INTO orders values(7, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 7, null);
INSERT IGNORE INTO orders values(8, 1, 2, 3, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 8, null);
INSERT IGNORE INTO orders values(9, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 9, null);
INSERT IGNORE INTO orders values(10, 1, 2, 2, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 10, null);
INSERT IGNORE INTO orders values(11, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 11, null);
INSERT IGNORE INTO orders values(12, 1, 2, 1, 100, 'test', '10086', 'earth', '100010', 'test', '10086', 'earth', '100010', 5, 5, 12, null);

INSERT IGNORE INTO yunorders values(1, 1, 2, 1, 1, 100, 100, 1, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(2, 1, 2, 2, 1, 100, 100, 2, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(3, 1, 2, 1, 1, 100, 100, 3, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(4, 1, 2, 2, 1, 100, 100, 4, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(5, 1, 2, 1, 1, 100, 100, 5, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(6, 1, 2, 2, 1, 100, 100, 6, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(7, 1, 2, 1, 1, 100, 100, 7, 'verifysamplecode', 'this is a test yun order', null);
INSERT IGNORE INTO yunorders values(8, 1, 2, 2, 1, 100, 100, 8, 'verifysamplecode', 'this is a test yun order', null);


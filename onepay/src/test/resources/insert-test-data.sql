delete from users;
delete from pictures;
delete from tags;
delete from products;

INSERT INTO users VALUES (1, 'test@test.cn', '13912345555', '123', 'funnyMe', 100, 200, 500, 1000, 1, 500, null);
insert into pictures values (1, 1, 'testPicPath', null);

INSERT INTO tags VALUES (1, 1, '测试', 0, null);
insert into products values(1, '测试商品', 1, 1, 1, 1, 1, 1, null, 10, '测试的第一个商品', null);

commit;



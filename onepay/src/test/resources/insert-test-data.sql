delete from users;
delete from pictures;
delete from tags;
delete from products;

INSERT INTO users VALUES (1, 'test@test.cn', '13912345555', '123', 'funnyMe', 100, 200, 500, 1, 500);
insert into pictures values (1, 1, 'testPicPath', null);

INSERT INTO tags VALUES (1, 1, '测试', '测试');
insert into products values(1, '测试商品', 1, 0, null, 1, 10, '测试的第一个商品');

commit;



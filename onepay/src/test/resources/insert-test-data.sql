delete from users;
delete from pictures;

INSERT INTO users VALUES (1, 'test@test.cn', '13912345555', '123', 'funnyMe', 100, 200, 500, 1);
insert into pictures values (1, 1, 'testPicPath', null);

commit;



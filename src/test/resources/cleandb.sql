delete from user;
insert into user
values (1, 'test', 'password123'),
       (2, 'person', 'lalala'),
       (3, 'JANEDOE', 'secret'),
       (4, 'donaldduck', 'quack');

delete from user_role;
insert into user_role
values (1, 'admin', 1),
       (2, 'user', 1),
       (3, 'user', 2),
       (4, 'user', 3),
       (5, 'user', 4);
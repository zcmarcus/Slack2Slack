delete from user;
insert into user
values (1, 'test', 'password123'),
       (2, 'person', 'lalala'),
       (3, 'JANEDOE', 'secret'),
       (4, 'donaldduck', 'quack');

delete from user_role;
insert into user_role
values (1, 'admin', 1, 'test'),
       (2, 'user', 1, 'test'),
       (3, 'user', 2, 'person'),
       (4, 'user', 3, 'JANEDOE'),
       (5, 'user', 4, 'donaldduck');

delete from template;
INSERT INTO `template`
VALUES (1,'Basic','https://cdn0.iconfinder.com/data/icons/customicondesignoffice5/256/examples.png', 'Sue', 'Sueserson', 'TestUser', 'suesueserson@gmail.com', 2);

delete from channel;
INSERT INTO channel
VALUES (1, 'general', 'General class-wide information', 'Information pertaining to the entire class', 1),
       (2, 'week-1', 'Week 1 content', 'Questions, tips, and tricks related to week 1 assignments', 1),
       (3, 'week-2', 'Week 2 content', 'Questions, tips, and tricks related to week 2 assignments', 1);
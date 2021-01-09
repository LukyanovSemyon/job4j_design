insert into users(name, roles_id) values ('a', 1);
insert into roles(name) values ('s');
insert into rules(name) values ('d');
insert into items(name, users_id, state_id, category_id) values ('f', 1, 1, 1);
insert into comments(name, items_id) values ('g', 1);
insert into attachments(name, items_id) values ('h', 1);
insert into state(name) values ('j');
insert into category(name) values ('k');
insert into roles_rules(roles_id, rules_id) values (1, 1);

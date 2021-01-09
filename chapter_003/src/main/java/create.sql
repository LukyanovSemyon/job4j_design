create table users (
                       id serial primary key,
                       name varchar(2000),
                       roles_id int references roles(id)
);
create table roles (
                       id serial primary key,
                       name varchar(2000)
);
create table rules (
                       id serial primary key,
                       name varchar(2000)
);
create table items (
                       id serial primary key,
                       name varchar(2000),
                       users_id int references users(id),
                       state_id int references state(id),
                       category_id int references category(id)
);
create table comments (
                          id serial primary key,
                          name varchar(2000),
                          items_id int references items(id)
);
create table attachments (
                             id serial primary key,
                             name varchar(2000),
                             items_id int references items(id)
);
create table state (
                       id serial primary key,
                       name varchar(2000)
);
create table category (
                          id serial primary key,
                          name varchar(2000)
);
create table roles_rules (
                          id serial primary key,
                          roles_id int references roles(id),
                          rules_id int references rules(id)
);

create table house (
                       id serial primary key,
                       street varchar(2000),
                       number int
);
create table person (
                       id serial primary key,
                       name varchar(2000),
                       landlord bool,
                       house_id int references house(id)
);
insert into house(street, number) values ('a', 2);
insert into house(street, number) values ('a', 3);
insert into house(street, number) values ('a', 5);
insert into house(street, number) values ('b', 1);
insert into house(street, number) values ('b', 2);

insert into person(name, house_id, landlord) values ('aa', 1, true);
insert into person(name, house_id, landlord) values ('bb', 2, true);
insert into person(name, house_id, landlord) values ('cc', 2, false);
insert into person(name, house_id, landlord) values ('dd', 3, true);
insert into person(name, house_id, landlord) values ('ee', 4, false);
insert into person(name, house_id, landlord) values ('ff', 5, false);
insert into person(name) values ('rr');
select * from person join house h on person.house_id = h.id;
select hh.name, h.street, h.number from person as hh join house h on hh.house_id = h.id;
select hh.name as Имя, h.street as Улица, h.number as НомерДома from person as hh join house h on hh.house_id = h.id;
select hh.name as Имя, h.street as Улица, h.number as НомерДома, hh.landlord as Собственник from person as hh join house h on hh.house_id = h.id;

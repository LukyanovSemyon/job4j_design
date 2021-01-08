create database films;
create table films(
    id serial primary key,
    name varchar(200),
    area text,
    budget money
);
insert into films(name , area, budget) values('Оно', 'США', '35');
select * from films;
update films set budget = 36;
select * from films;
delete from films;
select * from films;

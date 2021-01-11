create table product(
                        id serial primary key,
                        name varchar(255),
                        type_id int references type(id),
                        expired_date timestamp,
                        price float
);
create table type(
                       id serial primary key,
                       name varchar(255)
);

insert into product(name, type_id, expired_date, price) values ('сыр1', 1, '09.04.2021', 199.9);
insert into product(name, type_id, expired_date, price) values ('сыр2', 1, '09.05.2021', 189.9);
insert into product(name, type_id, expired_date, price) values ('молоко1', 2, '20.01.2021', 99.9);
insert into product(name, type_id, expired_date, price) values ('молоко2', 2, '05.07.2021', 89.9);
insert into product(name, type_id, expired_date, price) values ('мороженное1', 3, '02.03.2021', 299.9);
insert into product(name, type_id, expired_date, price) values ('мороженное2', 3, '07.02.2021', 319.9);

insert into type(name) values ('СЫР');
insert into type(name) values ('МОЛОКО');
insert into type(name) values ('МОРОЖЕННОЕ');

select * from product join type t on product.type_id = t.id where t.name = 'СЫР';
select * from product where name like '%мороженное%';
select * from product where expired_date < current_date + interval '1 month';
select name, price from product where price = (select max(price) from product);
select t.name, count(p.name) from product as p join type as t on p.type_id = t.id where t.name = 'СЫР' group by t.name;
select t.name, product.name  from product join type t on product.type_id = t.id where t.name = 'СЫР' or t.name = 'МОЛОКО';
select p.name, count(p.type_id) from product as p group by p.name having count(p.type_id) < 10;
select t.name, product.name from product join type t on product.type_id = t.id;
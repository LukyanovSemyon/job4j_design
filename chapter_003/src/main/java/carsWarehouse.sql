create database carsWarehouse;
create table carBody(
                        id serial primary key,
                        name varchar(255)
);
create table engine(
                       id serial primary key,
                       name varchar(255)
);
create table transmission(
                             id serial primary key,
                             name varchar(255)
);
create table car(
                      id serial primary key,
                      name varchar(255),
                      model varchar(255),
                      carBody_id int references carBody(id),
                      engine_id int references engine(id),
                      transmission_id int references transmission(id)
);
insert into carBody(name) values ('hatchback');
insert into carBody(name) values ('sedan');
insert into carBody(name) values ('estate');

insert into engine(name) values ('gasoline');
insert into engine(name) values ('diesel');
insert into engine(name) values ('electric');

insert into transmission(name) values ('manual');
insert into transmission(name) values ('automatic');

insert into car(name, model, carBody_id, engine_id, transmission_id) values ('Lada', 'Granta', 3, 1, 1);
insert into car(name, model, carBody_id, engine_id, transmission_id) values ('Lada', 'Vesta', 1, 1, 2);
insert into car(name, model, carBody_id, engine_id, transmission_id) values ('Kia', 'Rio', 2, 2, 2);
insert into car(name, model, carBody_id, engine_id, transmission_id) values ('Volkswagen', 'Polo', 2, 1, 1);
insert into car(name, model, carBody_id, engine_id, transmission_id) values ('Hyundai', 'Solaris', 1, 1, 1);

select c.name as brand, c.model, cb.name as body, e.name as engine, t.name as transmission
from car c
         inner join carbody cb on cb.id = c.carbody_id
         inner join engine e on e.id = c.engine_id
         inner join transmission t on t.id = c.transmission_id order by c.name;


select cb.name as notUse
from car c
         inner join carbody cb on cb.id <> c.carbody_id where c.model = 'Vesta'
union
select e.name
from car c
         inner join engine e on e.id <> c.engine_id where c.model = 'Vesta'
union
select t.name
from car c
         inner join transmission t on t.id <> c.transmission_id where c.model = 'Vesta';


select c.name as brand, c.model, cb.name as notUse
from car c
         inner join carbody cb on cb.id <> c.carbody_id
union
select c.name as brand, c.model, e.name as notUse
from car c
         inner join engine e on e.id <> c.engine_id
union
select c.name as brand, c.model, t.name as notUse
from car c
         inner join transmission t on t.id <> c.transmission_id;

create table devices(
                        id serial primary key,
                        name varchar(255),
                        price float
);
create table people(
                       id serial primary key,
                       name varchar(255)
);
create table devices_people(
                               id serial primary key,
                               device_id int references devices(id),
                               people_id int references people(id)
);

insert into devices(name, price) values ('device1', 35274);
insert into devices(name, price) values ('device2', 15424);
insert into devices(name, price) values ('device3', 22727);
insert into devices(name, price) values ('device4', 4121);
insert into devices(name, price) values ('device5', 5857);

insert into people(name) values ('name1');
insert into people(name) values ('name2');
insert into people(name) values ('name3');
insert into people(name) values ('name4');
insert into people(name) values ('name5');

insert into devices_people(device_id, people_id) values (1, 1);
insert into devices_people(device_id, people_id) values (1, 3);
insert into devices_people(device_id, people_id) values (1, 5);
insert into devices_people(device_id, people_id) values (2, 2);
insert into devices_people(device_id, people_id) values (2, 3);
insert into devices_people(device_id, people_id) values (2, 5);
insert into devices_people(device_id, people_id) values (3, 2);
insert into devices_people(device_id, people_id) values (3, 3);
insert into devices_people(device_id, people_id) values (4, 1);
insert into devices_people(device_id, people_id) values (4, 4);
insert into devices_people(device_id, people_id) values (5, 5);

select avg(price) from devices;

select p.name, avg(d.price) from devices_people as ss join people as p on ss.people_id = p.id join devices as d on ss.device_id = d.id
group by p.name;

select p.name, avg(d.price) from devices_people as ss join people as p on ss.people_id = p.id join devices as d on ss.device_id = d.id
group by p.name
having avg(d.price) > 5000;
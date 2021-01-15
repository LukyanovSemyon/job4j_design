create table departments(
                            id serial primary key,
                            name varchar(255)
);
create table employees(
                          id serial primary key,
                          name varchar(255),
                          departments_id int references departments(id)
);

insert into departments(name) values ('A1');
insert into departments(name) values ('B1');
insert into departments(name) values ('B2');
insert into departments(name) values ('C');

insert into employees(name, departments_id) values ('AAA', 2);
insert into employees(name, departments_id) values ('ABA', 1);
insert into employees(name, departments_id) values ('ACA', 1);
insert into employees(name, departments_id) values ('ADA', 2);
insert into employees(name, departments_id) values ('AEA', 3);
insert into employees(name, departments_id) values ('AFA', 3);
insert into employees(name, departments_id) values ('AGA', 1);
insert into employees(name) values ('BBB');


select e.name as employees, d.name as departments
from employees e
    left join departments d
        on d.id = e.departments_id;

select e.name as employees, d.name as departments
from employees e
    right join departments d
        on d.id = e.departments_id;

select e.name as employees, d.name as departments
from employees e
    full join departments d
        on d.id = e.departments_id;

select e.name as employees, d.name as departments
from employees e
    cross join departments d;


select e.name as employees, d.name as departments
from employees e
    left join departments d
        on d.id = e.departments_id
where e.departments_id is null;


select e.name as employees, d.name as departments
from employees e
    left join departments d
        on d.id = e.departments_id;

select e.name as employees, d.name as departments
from departments d
    right join employees e
        on d.id = e.departments_id;



create table teens(
                      id serial primary key,
                      name varchar(255),
                      gender varchar(1)
);

insert into teens(name, gender) values ('М1', 'М');
insert into teens(name, gender) values ('М2', 'М');
insert into teens(name, gender) values ('М3', 'М');
insert into teens(name, gender) values ('М4', 'М');
insert into teens(name, gender) values ('М5', 'М');
insert into teens(name, gender) values ('Ж1', 'Ж');
insert into teens(name, gender) values ('Ж2', 'Ж');
insert into teens(name, gender) values ('Ж3', 'Ж');
insert into teens(name, gender) values ('Ж4', 'Ж');
insert into teens(name, gender) values ('Ж5', 'Ж');

select w.name as W, m.name as M
from teens m
    cross join teens w
where m.gender <> w.gender and m.gender <> 'Ж';

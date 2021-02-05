create table company
(
    id integer not null ,
    name character varying,
    constraint company_pkey primary key (id)
);
create table person
(
    id integer not null ,
    name character varying,
    company_id integer,
    constraint person_pkey primary key (id)
);
insert into company(id, name) VALUES (1, 'aaaa');
insert into company(id, name) VALUES (2, 'bbbb');
insert into company(id, name) VALUES (3, 'cccc');
insert into company(id, name) VALUES (4, 'dddd');
insert into company(id, name) VALUES (5, 'eeee');

insert into person(id, name, company_id) VALUES (1, 'sad', 1);
insert into person(id, name, company_id) VALUES (2, 'sd', 1);
insert into person(id, name, company_id) VALUES (3, 'csd', 1);
insert into person(id, name, company_id) VALUES (4, 'erf', 2);
insert into person(id, name, company_id) VALUES (5, 'grt', 2);
insert into person(id, name, company_id) VALUES (6, 'qeg', 2);
insert into person(id, name, company_id) VALUES (7, 'ger', 2);
insert into person(id, name, company_id) VALUES (8, 'vw', 3);
insert into person(id, name, company_id) VALUES (9, 'sabrtd', 3);
insert into person(id, name, company_id) VALUES (10, 'wrtb', 4);
insert into person(id, name, company_id) VALUES (11, 'luig', 5);
insert into person(id, name, company_id) VALUES (12, 'rsthdb', 5);

select p.name person, c.name company
from person p join company c
    on p.company_id = c.id
where company_id <> 5;

select c.name company, count(p.company_id) staff
from company c join person p
    on c.id = p.company_id
group by c.name
order by count(p.company_id)
    desc limit 1;

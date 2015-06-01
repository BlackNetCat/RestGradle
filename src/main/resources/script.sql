create table testdb.person
(
id int unsigned not null auto_increment,
full_name varchar(255) not null,
age int unsigned not null,
primary key (id)
);

insert into person (full_name, age)
values ("Scarlett Johanson", 34);
insert into person (full_name, age)
values ("Bruce Willis", 47);
insert into person (full_name, age)
values ("Чак Норрис", 50);
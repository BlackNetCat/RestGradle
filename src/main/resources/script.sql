create table testdb.person
(
id int unsigned not null auto_increment,
full_name varchar(255) not null,
age int unsigned not null,
primary key (id)
);

insert into person (full_name, age)
values ("Scala Johanson", 24);
insert into person (full_name, age)
values ("Mona Lisa Harddrive", 47);
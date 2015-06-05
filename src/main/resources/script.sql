create table testdb.person
(
id int unsigned not null auto_increment,
full_name varchar(255) not null,
age int unsigned not null,
primary key (id)
)CHARACTER set utf8;


create table testdb.address
(
  id int unsigned not null auto_increment,
  street varchar(255) not null,
  city varchar(255) not null,
  id_person int unsigned not null,
  primary key (id),
  foreign key (id_person) references person(id)
)CHARACTER set utf8;

create table testdb.phone_number
(
  id int unsigned not null auto_increment,
  num varchar(255) not null,
  id_person int unsigned not null,
  primary key (id),
  foreign key (id_person) references person(id)
)CHARACTER set utf8;

insert into person (full_name, age)
values ("Scarlett Johanson", 34);
insert into person (full_name, age)
values ("Bruce Willis", 47);
insert into person (full_name, age)
values ("Чак Норрис", 50);

insert into address (street, city, id_person )
values ("5 ave", "New York", 1);

insert into phone_number ( num, id_person )
values ("+380555 55 55", 1);
create table settlers (
id bigint not null auto_increment,
name_of_settler varchar(250),
amount_of_tobacco int,
expected_income int,
primary key (id))
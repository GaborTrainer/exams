create table products(
id bigint auto_increment,
product_name varchar(255),
price bigint,
stock bigint,
constraint pk_products primary key(id)
);
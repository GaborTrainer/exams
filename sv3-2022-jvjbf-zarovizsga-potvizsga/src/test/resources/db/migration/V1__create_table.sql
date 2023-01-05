create table orders(
    id bigint not null auto_increment,
    product_name varchar(50),
    product_count int,
    price_per_product int,
    primary key(id))
create table customers
(
    id    serial primary key,
    name  varchar(255) not null,
    email varchar(255) not null,
    age   int          not null
)
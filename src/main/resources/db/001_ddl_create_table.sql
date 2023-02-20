
create table products
(
    id    uuid not null primary key,
    name  varchar(128),
    count int,
    unit  varchar(128),
    type  varchar(256)
);

create table animals
(
    id          uuid not null primary key,
    name        varchar(128),
    type        varchar(128),
    is_predator boolean
);

create table consumption_norm
(
    id         uuid not null primary key,
    animal_id  uuid,
    product_id uuid,
    size       float
);


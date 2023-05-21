create table if not exists product (
    id bigint not null auto_increment primary key,
    name varchar(100) not null,
    price decimal (13, 2) not null default 0.00,
    created_at datetime not null default current_timestamp(),
    updated_at datetime not null default current_timestamp()
);

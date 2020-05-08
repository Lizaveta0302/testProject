create table supervisor (
    supervisor_id int8 not null,
    name varchar(255) not null,
    last_name varchar(255) not null,
    patronymic varchar(255) not null,
    phone varchar(255) not null,
    city varchar(255) not null,
    primary key (supervisor_id)
);

create table type_hike(
    type_hike_id int8 not null,
    types varchar(255),
    primary key (type_hike_id)
);

create table hike(
    hike_id int8 not null,
    name varchar(255),
    price int8 not null,
    description  varchar(255),
    seats int8,
    type_id int8 not null,
    primary key (hike_id)
);

create table distribution_supervisor(
    distribution_supervisor_id int8 not null,
    hike_id bigint not null references hike,
    supervisor_id bigint not null references supervisor,
    primary key (distribution_supervisor_id)
);

alter table if exists hike
    add constraint type_id_fk
    foreign key (type_id) references type_hike;





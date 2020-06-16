create table user_reservation (
                         hike_id int8 not null references hike,
                         user_id int8 not null references usr,
                         primary key (hike_id, user_id)
);
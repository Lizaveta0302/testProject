alter table usr drop constraint usr_supervisor_id_fkey;
alter table distribution_supervisor drop constraint distribution_supervisor_hike_id_fkey;
alter table distribution_supervisor drop constraint distribution_supervisor_supervisor_id_fkey;

alter table distribution_supervisor
	add constraint distribution_supervisor_hike_id_fkey
		foreign key (hike_id) references hike
			on update cascade on delete cascade;

alter table distribution_supervisor
	add constraint distribution_supervisor_supervisor_id_fkey
		foreign key (supervisor_id) references supervisor
			on update cascade on delete cascade;

alter table usr
	add constraint usr_supervisor_id_fkey
		foreign key (supervisor_id) references supervisor
			on update cascade on delete cascade;
alter table if exists usr
	add column if not exists supervisor_id bigint references supervisor(supervisor_id)
			on update cascade on delete set null;

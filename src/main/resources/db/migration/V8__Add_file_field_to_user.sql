alter table if exists usr
	add column if not exists file_id bigint references file_model(id)
			on update cascade on delete set null;

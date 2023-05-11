create schema if not exists alarm;

create table if not exists alarm.tbl_proposition(
	id serial primary key,
	organization varchar(128) not null,
	proposition varchar(128) not null,
	unique(organization, proposition)
);

create index if not exists ix_tbl_proposition_proposition on alarm.tbl_proposition (proposition);
create index if not exists ix_tbl_proposition_organization on alarm.tbl_proposition (organization);



create schema if not exists alarm;

create table if not exists alarm.tbl_severity
(
    id serial primary key,
    severity varchar(64) not null,
    display_order integer not null,
    constraint tbl_severity_unique_key unique (severity)
);

insert into alarm.tbl_severity(severity, display_order)
    values ('Critical', 1) on conflict ("severity") do nothing;
insert into alarm.tbl_severity(severity, display_order)
    values ('High', 2) on conflict ("severity") do nothing;
insert into alarm.tbl_severity(severity, display_order)
    values ('Medium', 3) on conflict ("severity") do nothing;
insert into alarm.tbl_severity(severity, display_order)
    values ('Low', 4) on conflict ("severity") do nothing;
insert into alarm.tbl_severity(severity, display_order)
    values ('Very Low', 5) on conflict ("severity") do nothing;

create table if not exists alarm.tbl_alarm
(
    id serial primary key,
    name varchar(128) not null,
    severity_id integer,
    product_type_id integer,
    constraint tbl_alarm_name_product_type_id_unique_key
        unique (name, product_type_id),
    constraint fk_tbl_product_type_id_tbl_alarm_product_type_id
        foreign key (product_type_id)
        references product.tbl_product_type (id),
    constraint fk_tbl_severity_id_tbl_alarm_severity_id
        foreign key (severity_id)
        references alarm.tbl_severity (id)
);

--For the story 210615 Device connectivity configuration service - DB scripts creation readonly column is added on 08/02/2022
ALTER TABLE IF EXISTS alarm.tbl_alarm
ADD COLUMN IF NOT EXISTS readonly boolean DEFAULT FALSE;

--To perform soft delete alarms instead of hard.
ALTER TABLE IF EXISTS alarm.tbl_alarm
ADD COLUMN IF NOT EXISTS is_deleted boolean DEFAULT FALSE;

--Remove alarm name unique contraint to allow soft delete
ALTER TABLE IF EXISTS alarm.tbl_alarm
DROP CONSTRAINT IF EXISTS tbl_alarm_name_product_type_id_unique_key;

create index if not exists ix_tbl_alarm_name
    on alarm.tbl_alarm (name);

create index if not exists ix_tbl_alarm_name_product_type_id
    on alarm.tbl_alarm (name, product_type_id);

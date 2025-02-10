CREATE TABLE IF NOT EXISTS store_employee (
	id_ bigint primary key NOT NULL,
	lastname varchar(100) NOT NULL,
	firstname varchar(100) NOT NULL,
	patronymic varchar(100) NOT NULL,
	birth_date timestamp NOT NULL,
	position_id int8 NOT NULL,
	gender bool NOT NULL,
	CONSTRAINT store_employee_pkey PRIMARY KEY (id_)
);

CREATE TABLE IF NOT EXISTS counter (
	name varchar(75) NOT NULL,
	currentid int8 NULL,
	CONSTRAINT counter_pkey PRIMARY KEY (name)
);

CREATE TABLE IF NOT EXISTS purchase (
    id bigint primary key,
    electroitem_id bigint,
    purchase_date timestamp,
    type_id bigint,
    shop_id bigint
);

CREATE TABLE IF NOT EXISTS shop (
    shop_id bigint primary key,
    shop_name varchar(250),
    address text
);

CREATE TABLE IF NOT EXISTS electro_shop (
    shop_id bigint,
    electroitem_id bigint,
    count int,
    primary key(shop_id, electroitem_id)
);

CREATE TABLE IF NOT EXISTS electro_item (
    id bigserial primary key,
    name varchar(150),
    electrotype_id bigint,
    price bigint,
    count int,
    archive bool,
    description text
);

CREATE TABLE IF NOT EXISTS purchase_type (
    id bigint,
    name varchar(150)
);

CREATE TABLE IF NOT EXISTS posititon_type (
    id bigint primary key,
    name varchar(150)
);

CREATE TABLE IF NOT EXISTS electro_employee (
    employee_id bigint,
    electrotype_id bigint,
    primary key(employee_id, electrotype_id)
);

CREATE TABLE IF NOT EXISTS electro_type (
    id bigint primary key,
    name varchar(150)
);


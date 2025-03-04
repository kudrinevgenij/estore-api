CREATE TABLE IF NOT EXISTS position_type (
    id bigserial primary key,
    name varchar(150)
);

CREATE TABLE IF NOT EXISTS employee (
	id bigserial primary key NOT NULL,
	lastname varchar(100) NOT NULL,
	firstname varchar(100) NOT NULL,
	patronymic varchar(100) NOT NULL,
	birth_date timestamp NOT NULL,
	position_id bigint references position_type(id) NOT NULL,
	gender bool NOT NULL
);

CREATE TABLE IF NOT EXISTS electro_type (
    id bigserial primary key,
    name varchar(150)
);

CREATE TABLE IF NOT EXISTS electro_item (
    id bigserial primary key,
    name varchar(150),
    electrotype_id bigint references electro_type(id),
    price bigint,
    count int,
    archive bool,
    description text
);

CREATE TABLE IF NOT EXISTS purchase_type (
    id bigserial primary key,
    name varchar(150)
);

CREATE TABLE IF NOT EXISTS shop (
   id bigserial primary key,
    shop_name varchar(250),
    address text
);

CREATE TABLE IF NOT EXISTS purchase (
    id bigserial primary key,
    electroitem_id bigint references electro_item(id),
    purchase_date timestamp,
    type_id bigint references purchase_type(id),
    shop_id bigint references shop(id),
    employee_id bigint references employee(id)
);

CREATE TABLE IF NOT EXISTS electro_shop (
    id bigserial primary key,
    shop_id bigint references shop(id),
    electroitem_id bigint references electro_item(id),
    count int
);

CREATE TABLE IF NOT EXISTS electro_employee (
    id bigserial primary key,
    employee_id bigint references employee(id),
    electrotype_id bigint references electro_type(id)
);
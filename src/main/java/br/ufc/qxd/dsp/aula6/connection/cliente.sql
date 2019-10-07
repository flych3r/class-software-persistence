create table cliente (
	id serial primary key,
	nome varchar(200),
	cpf varchar(15)
);

create table telefone(
	id serial primary key,
	ddd integer,
	numero integer,
	cliente_id integer,
	constraint cliente_id foreign key (cliente_id) references cliente(id)
);

create table endereco(
	id serial primary key,
	rua varchar(100),
	numero integer,
	bairro varchar(100),
	cidade varchar(100)
);

create table cliente_endereco(
	cliente_id integer,
	endereco_id integer,
	primary key(cliente_id, endereco_id),
	constraint cliente_id foreign key (cliente_id) references cliente(id),
	constraint endereco_id foreign key (endereco_id) references endereco(id)
);


















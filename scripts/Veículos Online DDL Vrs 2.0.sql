create database veiculoson with encoding 'utf8';
\c veiculoson;


create table usuario (
	id serial primary key,
	email character varying(100) not null unique,
	senha character varying(100) not null,
	cpf character varying(11) unique,
	tipo character varying(3) default 'USR'check (tipo in ('USR', 'ADM')),
	telefone character varying(11),
	endereco character varying(100) unique,
	conta character varying(10),
	agencia character varying(10),
	banco character varying(3),
	nome character varying(100) not null,
	status character varying(9) default 'Ativo' check (status in('Bloqueado', 'Ativo')),
	unique (conta, agencia, banco)
);

create table anuncio (
	usuario_id integer not null references usuario(id) on update cascade on delete cascade,
	id serial primary key,
	nota double precision default 0,
	titulo character varying(220) not null,
	descricao text,
	laudo_veicular character varying(100),
	formas_pagamento character varying(220) check (formas_pagamento in ('Financiamento', 'Dinheiro')),
	status character varying(12) default 'Em Avaliacao' check (status in ('Em Avaliacao', 'Ativo', 'Pausado', 'Excluido')),
	portas integer not null check (portas in ('2', '3', '4')),
	quantidade_donos integer not null,
	final_placa character varying(1) not null,
	cor character varying(10) not null,
	motor character varying(10) not null,
	ano integer not null,
	combustivel character varying(20) not null check (combustivel in ('Gasolina', 'Etanol', 'Flex','Diesel')),
	kilometragem integer not null,
	cambio character varying(20) not null check (cambio in ('Manual', 'Automatico')),
	modelo character varying(20) not null,
	marca character varying(20) not null,
	preco decimal default 0,
	data_hora_criacao timestamp without time zone not null,
	data_hora_compra timestamp without time zone,
	taxa_compra double precision default 5,
	protocolo_compra serial unique
);

create table foto_anuncio (
	id serial primary key,
	anuncio_id integer not null references anuncio(id) on update cascade on delete cascade,
	nome_foto character varying(100) not null,
	unique(anuncio_id, nome_foto)
);

create table notificacao (
	id serial primary key,
	usuario_id integer references usuario(id)  on update cascade on delete cascade,
	anuncio_id integer references anuncio(id) on update cascade on delete cascade,
	data_hora timestamp without time zone,
	descricao text not null,
	unique(usuario_id, anuncio_id, data_hora)
);

create table chat (
	id serial primary key,
	usuario_id integer not null references usuario(id)	on update cascade on delete cascade,
	anuncio_id integer not null references anuncio(id) on update cascade on delete cascade,
	data_hora timestamp without time zone not null,
	unique(usuario_id, anuncio_id)
);

create table mensagem (
	id serial primary key,
	chat_id integer references chat(id) on update cascade on delete cascade,
	usuario_id integer not null references usuario(id) on update cascade on delete cascade,
	data_hora timestamp without time zone not null,
	texto text not null,
	unique(chat_id, data_hora, texto)
);

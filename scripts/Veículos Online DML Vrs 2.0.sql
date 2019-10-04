--USUÁRIOS
insert into usuario (email, senha, cpf, tipo, conta, agencia, banco, nome, endereco, telefone) 
values ('email0@email.com', '123654', '12345666711', default, '1234', '13345', '201', 'Joao Bonham', 'rua da minha casa, 44, jardim santo antonio, santa rita do sapucai, minas gerais', '35988090703');

insert into usuario (email, senha, cpf, tipo, conta, agencia, banco, nome) 
values ('email1@email.com', '123456', '12345678911', 'USR', '1234', '123', '201', 'Thiago Pagina');

insert into usuario (email, senha, cpf, conta, agencia, banco, nome) 
values ('email2@email.com', 'abcdef', '32145678911', '2334', '323', '101', 'Roberto Planta');

insert into usuario (email, senha, cpf, conta, agencia, banco, nome) 
values ('email3@email.com', '123def', '53215678911', '24234-5', '1875-9', '101',  'Joao Paulo Jonas');

insert into usuario (email, nome, senha)
values('exemplo@email.com', 'Joao', '123123');

insert into usuario (email, nome, senha)
values('exemplo1@email.com', 'Maria', '123123');


--ADMINISTRADORES (USUÁRIOS)
insert into usuario (email, senha, cpf, tipo, nome) 
values ('rodrigo@gmail.com', '123123', '11122233311', 'ADM', 'Rodrigo C. Daflon');
insert into usuario (email, senha, cpf, tipo, nome) 
values ('wellington@gmail.com', '123123', '11133233311', 'ADM', 'Wellington');


--TABELA ANUNCIO
insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (2, 'Fusca usado', 'fusquinha antigo conservado', 'Financiamento', 2, 1, '9', 'Verde',
 '1.0', '1950', 65500, 'Gasolina', 'Manual', 'sei nao', 'Volkswagen', 2000, now(), 'Ativo', 2);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (2, 'Fusca meia boca', 'fusquinha antigo conservado', 'Financiamento', 2, 1, '2', 'Azul',
 '1.0', '1960', 85500, 'Gasolina', 'Manual', 'Conversível', 'Volkswagen', 5000, now(), 'Ativo', 9);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (3, 'Fiat Uno', 'conservado', 'Financiamento', 4, 4, '1', 'Preto',
 '1.0', '1956', 45500, 'Gasolina', 'Manual', 'sei nao', 'Volkswagen', 12500, now(), 'Ativo', 7);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (1, 'Chevrolet 1.0', 'pra vender rápido, também troco', 'Financiamento', 4, 2, '7', 'Branco',
 '2.0', '1963', 25500, 'Gasolina', 'Manual', 'Sedan', 'Chevrolet', 15000, now(), 'Ativo', 6);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (4, 'Honda Civic conservado', 'somente venda', 'Dinheiro', 4, 1, '6', 'Cinza',
 '1.0', '2000', 100500, 'Flex', 'Automatico', 'Sedan', 'Honda', 30000, now(), 'Ativo', 6);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (4, 'Celta 1.0 completo', 'completo, ar condicionado, trava elétrica, vidro elétrico, alarme, som, direção hidráulica...', 'Financiamento', 2, 1, '0', 'Preto',
 '1.0', '1997', 200500, 'Gasolina', 'Manual', 'Ret', 'Chevrolet', 13300, now(), 'Ativo', 10);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, status, nota)
values (6, 'Fiat Mobi', 'Completo', 'Financiamento', 2, 1, '1', 'Vermelho',
 '1.0', '2018', 98500, 'Gasolina', 'Automatico', 'Ret', 'Fiat', 35000, now(), 'Ativo', 8);

insert into anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa,
cor, motor, ano, kilometragem, combustivel, cambio, modelo, marca, preco, data_hora_criacao, nota)
values (5, 'Brasília', 'vanda ou troca', 'Financiamento', 4, 2, '7', 'Amarela',
 '1.0', '1973', 335500, 'Gasolina', 'Manual', 'Sedan', 'Volkswagen', 1500, now(), 4);


--TABLE NOTIFICACAO
insert into notificacao (data_hora, descricao)
	values(now(), 'Exemplo de Notificação Padrão: Bem-Vindo!');

insert into notificacao (usuario_id, anuncio_id, data_hora, descricao)
	values(2, 1, now(), 'Você recebeu uma nova mensagem!');

insert into notificacao (usuario_id, anuncio_id, data_hora, descricao)
	values(6, 1, now(), 'Novo Anúncio Cadastrado, o usuário aguarda sua avaliação, avalie-o!');

insert into notificacao (usuario_id, anuncio_id, data_hora, descricao)
	values(7, 1, now(), 'Novo Anúncio Cadastrado, o usuário aguarda sua avaliação, avalie-o!');

insert into notificacao (usuario_id, anuncio_id, data_hora, descricao)
	values(5, 1, now(), 'Novo Anúncio Cadastrado, o usuário aguarda sua avaliação, avalie-o!');

insert into notificacao (usuario_id, anuncio_id, data_hora, descricao)
	values(2, 1, now(), 'Anúncio aprovado pelos Administradores da Veículos Online! Agora outros usuários já podem acessá-lo!');


--TABELA FOTO_ANUNCIO
insert into foto_anuncio (anuncio_id, nome_foto)
	values (1, 'foto_interior');

insert into foto_anuncio (anuncio_id, nome_foto)
	values (1, 'foto_de_frente');

insert into foto_anuncio (anuncio_id, nome_foto)
	values (1, 'foto_das_rodas');


--TABLE CHAT
insert into chat (usuario_id, anuncio_id, data_hora)
	values(1, 3, now());
insert into chat (usuario_id, anuncio_id, data_hora)
	values(5, 3, now());


--TABLE MENSAGEM
insert into mensagem (chat_id, usuario_id, data_hora, texto)
	values(1, 1, now(), 'olá estou interessado em comprar seu fusca! me liga.');
insert into mensagem (chat_id, usuario_id, data_hora, texto)
	values(1, 3, now(), 'olá, tudo bem? fala por aqui mesmo nao tenho telefone.');
insert into mensagem (chat_id, usuario_id, data_hora, texto)
	values(1, 1, now(), 'olá ainda esta vendendo o carro?');
insert into mensagem (chat_id, usuario_id, data_hora, texto)
	values(1, 3, now(), 'olá, tudo bem? estou negociando ele agora mesmo com um interessado, quem da mai$$? kkk');
insert into mensagem (chat_id, usuario_id, data_hora, texto)
	values(2, 5, now(), 'olá, acabei de ver o anuncio, tenho interesse');

INSERT INTO USUARIO(nome_completo, cpf, username, password, email, telefone, idade) VALUES('Matheus Bruggemann Vieira', '01014310903',  'nofti', '$2a$10$RAJQjkcvTe39wSm8lLs/B.izMdO2ncT6tV/L/Y66eCeIUZHFn4zZi', 'matheusbvieira@hotmail.com', '48991466677', '19');
INSERT INTO USUARIO(nome_completo, cpf, username, password, email, telefone, idade) VALUES('Matheus Bruggemann Vieiraa', '01014310904',  'noft', '$2a$10$RAJQjkcvTe39wSm8lLs/B.izMdO2ncT6tV/L/Y66eCeIUZHFn4zZi', 'matheusbvieira@hotmal.com', '48991466677', '19');

INSERT INTO `endereco` (`bairro`, `cep`, `complemento`, `numero`, `rua`) VALUES ('Campeche', '88063160', NULL, 114, 'Rua das corticeiras');

INSERT INTO `evento` (`capacidade_pessoas`, `categoria`, `data`, `nome`, `preco`, `criador_id`, `endereco_id`) VALUES (400, 'FESTA', '2000-11-28 22:00:00.000000', 'Aniversario', NULL, 1, 1);
INSERT INTO `evento` (`capacidade_pessoas`, `categoria`, `data`, `nome`, `preco`, `criador_id`, `endereco_id`) VALUES (400, 'FESTA', '2000-11-28 22:00:00.000000', 'Rave', NULL, 1, 1);
INSERT INTO `evento` (`capacidade_pessoas`, `categoria`, `data`, `nome`, `preco`, `criador_id`, `endereco_id`) VALUES (400, 'FESTA', '2000-11-28 22:00:00.000000', 'Warung', NULL, 1, 1);

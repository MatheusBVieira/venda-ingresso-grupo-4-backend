INSERT INTO USUARIO(nome, sobrenome, cpf, password, email, telefone) VALUES('Matheus', 'Bruggemann Vieira', '01014310903', '$2a$10$RAJQjkcvTe39wSm8lLs/B.izMdO2ncT6tV/L/Y66eCeIUZHFn4zZi', 'matheusbvieira@hotmail.com', '48991466677');
INSERT INTO USUARIO(nome, sobrenome, cpf, password, email, telefone) VALUES('Matheus', 'Bruggemann Vieiraa', '01014310904', '$2a$10$RAJQjkcvTe39wSm8lLs/B.izMdO2ncT6tV/L/Y66eCeIUZHFn4zZi', 'matheusbvieira@hotmal.com', '48991466677');

INSERT INTO `endereco` (`nome_local`, `bairro`, `cidade`,`estado`, `cep`, `complemento`, `numero`, `rua`) VALUES ('Local maneiro','Campeche','Florianopolis','SC', '88063160', NULL, 114, 'Rua das corticeiras');

INSERT INTO `data_evento` (`horario_inicio`, `horario_fim`, `data_inicio`, `data_fim`) VALUES ('11:00', '12:00', '2000-11-28 22:00:00.000000', '2000-11-28 22:00:00.000000');

INSERT INTO `evento` (`capacidade_pessoas`, `categoria`, `nome`, `preco`, `criador_id`, `endereco_id`, `data_evento_id`, `descricao`) VALUES (400, 'FESTA', 'Aniversario', 100, 1, 1, 1, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer');
INSERT INTO `evento` (`capacidade_pessoas`, `categoria`, `nome`, `preco`, `criador_id`, `endereco_id`, `data_evento_id`, `descricao`) VALUES (400, 'FESTA', 'Rave', 120, 1, 1, 1, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer');
INSERT INTO `evento` (`capacidade_pessoas`, `categoria`, `nome`, `preco`, `criador_id`, `endereco_id`, `data_evento_id`, `descricao`) VALUES (400, 'FESTA', 'Warung', 30, 1, 1, 1, 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industrys standard dummy text ever since the 1500s, when an unknown printer');

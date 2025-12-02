CREATE SCHEMA IF NOT EXISTS `biblioteca_db` DEFAULT CHARACTER SET utf8mb4 ;
USE `biblioteca_db` ;

-- -----------------------------------------------------
-- Tabela `pessoa` (Herança)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pessoa` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL UNIQUE,
  `email` VARCHAR(255) UNIQUE,
  `telefone` VARCHAR(20),
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `endereco` (Relacionamento 0..1)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `endereco` (
  `pessoa_id` BIGINT NOT NULL, -- Chave estrangeira e primária
  `rua` VARCHAR(255),
  `numero` INT,
  `complemento` VARCHAR(255),
  `bairro` VARCHAR(255),
  `cidade` VARCHAR(255),
  `estado` VARCHAR(255),
  `cep` VARCHAR(10),
  PRIMARY KEY (`pessoa_id`),
  FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `usuario` (Herança de Pessoa)
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario` (
  `pessoa_id` BIGINT NOT NULL, -- Chave estrangeira e primária
  `matricula` VARCHAR(50) NOT NULL UNIQUE,
  `data_cadastro` DATE,
  `tipo` VARCHAR(50),
  PRIMARY KEY (`pessoa_id`),
  FOREIGN KEY (`pessoa_id`) REFERENCES `pessoa` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `biografia` TEXT,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL UNIQUE,
  `descricao` VARCHAR(255),
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `livro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livro` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(255) NOT NULL,
  `isbn` VARCHAR(20) NOT NULL UNIQUE,
  `editora` VARCHAR(100),
  `ano_publicacao` DATE, -- Alterado para DATE para refletir a classe Livro (Date anoPublicacao)
  `qtd_paginas` INT,
  `idioma` VARCHAR(50),
  `categoria_id` BIGINT NOT NULL, -- Relacionamento: Livro pertence a 1 Categoria [cite: 174]
  PRIMARY KEY (`id`),
  FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`)
    ON DELETE RESTRICT -- Não permite excluir categoria com livros associados
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela de Junção `livro_autor` (Muitos para Muitos)
-- Relacionamento: Livro N <--> N Autor (escrito_por) [cite: 173]
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `livro_autor` (
  `livro_id` BIGINT NOT NULL,
  `autor_id` BIGINT NOT NULL,
  PRIMARY KEY (`livro_id`, `autor_id`),
  FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
    ON DELETE CASCADE,
  FOREIGN KEY (`autor_id`) REFERENCES `autor` (`id`)
    ON DELETE CASCADE
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `exemplar`
-- Relacionamento: Livro 1 <--> N Exemplar (possui) [cite: 181]
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `exemplar` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `codigo_barra` VARCHAR(100) NOT NULL UNIQUE,
  `estado` VARCHAR(50),
  `status_disponibilidade` VARCHAR(50),
  `livro_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
    ON DELETE RESTRICT
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `emprestimo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `emprestimo` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_retirada` DATE NOT NULL,
  `data_devolucao_prevista` DATE,
  `data_devolucao_real` DATE,
  `multa` DECIMAL(10, 2),
  `status` VARCHAR(50),
  `usuario_id` BIGINT NOT NULL, -- Empréstimo 1 --> 1 Usuário [cite: 191]
  `exemplar_id` BIGINT NOT NULL, -- Empréstimo 1 --> 1 Exemplar [cite: 190]
  PRIMARY KEY (`id`),
  FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`pessoa_id`)
    ON DELETE RESTRICT,
  FOREIGN KEY (`exemplar_id`) REFERENCES `exemplar` (`id`)
    ON DELETE RESTRICT
) ENGINE = InnoDB;

-- -----------------------------------------------------
-- Tabela `reserva`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `reserva` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data_reserva` DATE NOT NULL,
  `status` VARCHAR(50),
  `usuario_id` BIGINT NOT NULL, -- Reserva 1 --> 1 Usuário [cite: 198]
  `livro_id` BIGINT NOT NULL, -- Reserva 1 --> 1 Livro [cite: 197]
  PRIMARY KEY (`id`),
  FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`pessoa_id`)
    ON DELETE RESTRICT,
  FOREIGN KEY (`livro_id`) REFERENCES `livro` (`id`)
    ON DELETE RESTRICT
) ENGINE = InnoDB;
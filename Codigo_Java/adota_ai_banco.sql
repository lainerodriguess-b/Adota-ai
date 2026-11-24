DROP DATABASE IF EXISTS adota_ai;
CREATE DATABASE adota_ai
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;
USE adota_ai;

-- ---------------------------------------------------------------------
-- VACINA  (classe Vacina: nome, fabricante, lote)
-- Uma vacina (um lote) pode ser aplicada em vários animais.
-- ---------------------------------------------------------------------
CREATE TABLE vacina (
    codigo      INT          NOT NULL AUTO_INCREMENT,
    nome        VARCHAR(60)  NOT NULL,
    fabricante  VARCHAR(60)  NOT NULL,
    lote        VARCHAR(30)  NOT NULL,
    PRIMARY KEY (codigo),
    UNIQUE KEY uq_vacina (nome, fabricante, lote)
);

-- ---------------------------------------------------------------------
-- ANIMAL  (classe abstrata Animal + Cachorro + Gato numa tabela só)
-- sexo, foto_url e descricao vêm do formulário da página ONG.html.
-- "adotado" NÃO é guardado aqui: ele é calculado pela tabela adocao
-- (ver vw_animais), assim nunca fica um valor desatualizado.
-- ---------------------------------------------------------------------
CREATE TABLE animal (
    codigo        INT           NOT NULL AUTO_INCREMENT,
    nome          VARCHAR(60)   NOT NULL,
    especie       ENUM('Cachorro','Gato') NOT NULL,
    idade         INT           NOT NULL,               -- em anos
    sexo          ENUM('Fêmea','Macho') NULL,
    foto_url      VARCHAR(255)  NULL,
    descricao     VARCHAR(500)  NULL,
    adestrado     BOOLEAN       NULL,                   -- só Cachorro
    temperamento  VARCHAR(40)   NULL,                   -- só Gato
    data_cadastro TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (codigo),
    CONSTRAINT ck_animal_idade CHECK (idade >= 0),
    CONSTRAINT ck_animal_tipo CHECK (
        (especie = 'Cachorro' AND adestrado IS NOT NULL AND temperamento IS NULL)
     OR (especie = 'Gato'     AND temperamento IS NOT NULL AND adestrado IS NULL)
    )
);

-- ---------------------------------------------------------------------
-- CARTEIRA_VACINA  (ArrayList<Vacina> carteiraVacinas do Animal)
-- Tabela de ligação N:N entre animal e vacina.
-- ---------------------------------------------------------------------
CREATE TABLE carteira_vacina (
    animal_codigo   INT  NOT NULL,
    vacina_codigo   INT  NOT NULL,
    data_aplicacao  DATE NULL,
    PRIMARY KEY (animal_codigo, vacina_codigo),
    CONSTRAINT fk_cv_animal FOREIGN KEY (animal_codigo)
        REFERENCES animal (codigo) ON DELETE CASCADE,   -- apagou o animal, apaga a carteira
    CONSTRAINT fk_cv_vacina FOREIGN KEY (vacina_codigo)
        REFERENCES vacina (codigo) ON DELETE RESTRICT   -- não apaga vacina em uso
);

-- ---------------------------------------------------------------------
-- ADOTANTE  (classe Adotante)
-- email: está na lista de classes e no site, mas FALTA no Adotante.java.
-- ---------------------------------------------------------------------
CREATE TABLE adotante (
    codigo     INT            NOT NULL AUTO_INCREMENT,
    nome       VARCHAR(100)   NOT NULL,
    idade      INT            NOT NULL,
    cpf        CHAR(11)       NOT NULL,                -- só números
    renda      DECIMAL(10,2)  NOT NULL,
    endereco   VARCHAR(200)   NOT NULL,
    email      VARCHAR(120)   NOT NULL,
    telefone   VARCHAR(15)    NOT NULL,
    PRIMARY KEY (codigo),
    UNIQUE KEY uq_adotante_cpf   (cpf),
    UNIQUE KEY uq_adotante_email (email),
    CONSTRAINT ck_adotante_idade CHECK (idade >= 18),  -- critério de adoção: maior de idade
    CONSTRAINT ck_adotante_renda CHECK (renda >= 0),
    CONSTRAINT ck_adotante_cpf   CHECK (cpf REGEXP '^[0-9]{11}$')
);

-- ---------------------------------------------------------------------
-- ADOCAO  (classe Adocao; o conjunto de linhas é o Historico)
-- situacao usa os mesmos valores do Adocao.java.
--
-- Regra do ONG.registrarAdocao() feita pelo próprio banco:
--   um animal só pode ter UMA adoção "Em andamento" ou "Concluída".
--   A coluna animal_ativo só tem valor nesses dois casos, e é UNIQUE.
--   Adoções "Cancelada" ficam NULL e podem se repetir à vontade.
-- ---------------------------------------------------------------------
CREATE TABLE adocao (
    codigo           INT   NOT NULL AUTO_INCREMENT,
    animal_codigo    INT   NOT NULL,
    adotante_codigo  INT   NOT NULL,
    data             DATE  NOT NULL,
    situacao         ENUM('Em andamento','Concluída','Cancelada')
                           NOT NULL DEFAULT 'Em andamento',
    animal_ativo     INT GENERATED ALWAYS AS (
                         CASE WHEN situacao IN ('Em andamento','Concluída')
                              THEN animal_codigo END
                     ) STORED,
    PRIMARY KEY (codigo),
    UNIQUE KEY uq_adocao_animal_ativo (animal_ativo),
    CONSTRAINT fk_adocao_animal FOREIGN KEY (animal_codigo)
        REFERENCES animal (codigo) ON DELETE RESTRICT,   -- não some do histórico
    CONSTRAINT fk_adocao_adotante FOREIGN KEY (adotante_codigo)
        REFERENCES adotante (codigo) ON DELETE RESTRICT
);

-- =====================================================================
-- VIEWS (consultas prontas)
-- =====================================================================

-- Animais com "adotado" e a "Disponibilidade" que o site mostra.
CREATE VIEW vw_animais AS
SELECT
    a.codigo, a.nome, a.especie, a.idade, a.sexo, a.foto_url, a.descricao,
    a.adestrado, a.temperamento,
    EXISTS (SELECT 1 FROM adocao d
            WHERE d.animal_codigo = a.codigo AND d.situacao = 'Concluída') AS adotado,
    CASE
        WHEN EXISTS (SELECT 1 FROM adocao d
                     WHERE d.animal_codigo = a.codigo AND d.situacao = 'Concluída')
            THEN 'Adotado'
        WHEN EXISTS (SELECT 1 FROM adocao d
                     WHERE d.animal_codigo = a.codigo AND d.situacao = 'Em andamento')
            THEN 'Em processo de adoção'
        ELSE 'Disponível'
    END AS disponibilidade
FROM animal a;

-- Histórico de adoções (o que a classe Historico guarda).
CREATE VIEW vw_historico AS
SELECT
    d.codigo        AS codigo_adocao,
    d.data,
    d.situacao,
    an.codigo       AS codigo_animal,
    an.nome         AS animal,
    an.especie,
    ad.nome         AS adotante,
    ad.cpf,
    ad.email
FROM adocao d
JOIN animal   an ON an.codigo = d.animal_codigo
JOIN adotante ad ON ad.codigo = d.adotante_codigo;

-- =====================================================================
-- DADOS DE TESTE (os mesmos do Main.java)
-- =====================================================================
INSERT INTO vacina (nome, fabricante, lote) VALUES
    ('Antirrábica',  'ASTRA',     'L001'),   
    ('V10',          'SAGE',      'L002'),   
    ('Antirrábica',  'BRIMSTONE', 'L003'),   
    ('Gripe Canina', 'Viper',     'L004');   

INSERT INTO animal (nome, especie, idade, sexo, adestrado, temperamento) VALUES
    ('Aisha',  'Cachorro', 3, 'Fêmea', TRUE, NULL),             
    ('Stella', 'Gato',     2, 'Fêmea', NULL, 'Brincalhão'),     -- 2
    ('Tecna',  'Gato',     1, 'Fêmea', NULL, 'Não informado');  -- 3 (construtor sem temperamento)

INSERT INTO carteira_vacina (animal_codigo, vacina_codigo) VALUES
    (1, 1), (1, 2), (1, 4),   -- Aisha
    (2, 3);                   -- Stella

INSERT INTO adotante (nome, idade, cpf, renda, endereco, email, telefone) VALUES
    ('Ana Ju', 18, '12345678900', 2500.00, 'Rua Toquio, 100', 'anaju@email.com', '62940028922');

-- registrarAdocao(1, "12345678900", "11/11/2026")
INSERT INTO adocao (animal_codigo, adotante_codigo, data)
VALUES (1, (SELECT codigo FROM adotante WHERE cpf = '12345678900'), '2026-11-11');

-- permitirAdocao(1)
UPDATE adocao SET situacao = 'Concluída'
WHERE codigo = 1 AND situacao = 'Em andamento';


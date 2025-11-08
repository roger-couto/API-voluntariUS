-- Tabela de Usuários
CREATE TABLE usuarios (
                          id BIGSERIAL PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          senha VARCHAR(255) NOT NULL,
                          telefone VARCHAR(20)
);

-- Tabela de Eventos
CREATE TABLE eventos (
                         id BIGSERIAL PRIMARY KEY,
                         titulo VARCHAR(100) NOT NULL,
                         descricao TEXT,
                         data_evento TIMESTAMP NOT NULL,
                         local VARCHAR(200) NOT NULL,
                         max_voluntarios INTEGER NOT NULL,
                         usuario_id BIGINT NOT NULL,
                         status VARCHAR(20) DEFAULT 'ATIVO',
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- Tabela de Inscrições
CREATE TABLE inscricoes (
                            id BIGSERIAL PRIMARY KEY,
                            voluntario_id BIGINT NOT NULL,
                            evento_id BIGINT NOT NULL,
                            data_inscricao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            status VARCHAR(20) DEFAULT 'CONFIRMADA',
                            observacoes TEXT,
                            FOREIGN KEY (voluntario_id) REFERENCES usuarios(id),
                            FOREIGN KEY (evento_id) REFERENCES eventos(id),
                            UNIQUE (voluntario_id, evento_id)
);
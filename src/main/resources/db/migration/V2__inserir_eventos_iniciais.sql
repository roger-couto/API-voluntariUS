-- Assumindo usuario_id = 1 como organizador.
-- Tabela: id, titulo, descricao, data_evento, local, max_voluntarios, usuario_id, status, created_at

INSERT INTO eventos (id, titulo, descricao, data_evento, local, max_voluntarios, usuario_id, status, created_at) VALUES
                                                                                                                     (
                                                                                                                         11,
                                                                                                                         'Limpeza de Praia Nacional',
                                                                                                                         'Ação de conscientização e coleta de lixo em uma praia local.',
                                                                                                                         '2025-12-10 08:00:00',
                                                                                                                         'Praia Central',
                                                                                                                         50,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         12,
                                                                                                                         'Caminhada de Conscientização',
                                                                                                                         'Evento para levantar fundos e divulgar a causa da saúde mental.',
                                                                                                                         '2026-01-05 10:00:00',
                                                                                                                         'Parque Municipal',
                                                                                                                         200,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         13,
                                                                                                                         'Dia da Criança no Abrigo',
                                                                                                                         'Atividades lúdicas e recreativas em um orfanato.',
                                                                                                                         '2026-02-02 14:00:00',
                                                                                                                         'Abrigo Municipal Sol',
                                                                                                                         15,
                                                                                                                         1,
                                                                                                                         'FECHADO', -- Evento com inscrições fechadas
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         14,
                                                                                                                         'Distribuição de Livros Didáticos',
                                                                                                                         'Organização e entrega de material em escolas rurais.',
                                                                                                                         '2026-02-20 09:30:00',
                                                                                                                         'Depósito Central',
                                                                                                                         30,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         15,
                                                                                                                         'Maratona de Programação Solidária',
                                                                                                                         'Desenvolvimento de sites para pequenas ONGs (evento online).',
                                                                                                                         '2026-03-01 19:00:00',
                                                                                                                         'Online / Plataforma Zoom',
                                                                                                                         10,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         16,
                                                                                                                         'Reciclagem de Eletroeletrônicos',
                                                                                                                         'Ponto de coleta e separação de lixo eletrônico.',
                                                                                                                         '2026-03-15 11:00:00',
                                                                                                                         'Estacionamento do Shopping',
                                                                                                                         45,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         17,
                                                                                                                         'Campanha do Quilo do Pet',
                                                                                                                         'Arrecadação de ração para abrigos de animais da cidade.',
                                                                                                                         '2026-04-01 16:00:00',
                                                                                                                         'Petshop Amigo Fiel',
                                                                                                                         12,
                                                                                                                         1,
                                                                                                                         'FECHADO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         18,
                                                                                                                         'Jardinagem Comunitária',
                                                                                                                         'Criação e manutenção de um jardim em área pública.',
                                                                                                                         '2026-04-10 07:30:00',
                                                                                                                         'Terreno baldio vizinho',
                                                                                                                         25,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         19,
                                                                                                                         'Ronda Noturna de Apoio',
                                                                                                                         'Distribuição de água e cobertores para pessoas em situação de rua.',
                                                                                                                         '2026-05-05 20:00:00',
                                                                                                                         'Centro (Região da Rodoviária)',
                                                                                                                         8,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     ),
                                                                                                                     (
                                                                                                                         20,
                                                                                                                         'Oficina de Culinária Saudável',
                                                                                                                         'Aulas para famílias de baixa renda sobre alimentação nutritiva.',
                                                                                                                         '2026-05-25 15:30:00',
                                                                                                                         'Cozinha Comunitária',
                                                                                                                         18,
                                                                                                                         1,
                                                                                                                         'ABERTO',
                                                                                                                         NOW()
                                                                                                                     );
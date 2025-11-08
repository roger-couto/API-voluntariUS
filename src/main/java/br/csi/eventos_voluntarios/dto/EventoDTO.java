package br.csi.eventos_voluntarios.dto;

import br.csi.eventos_voluntarios.model.Evento;

import java.time.LocalDateTime;

public record EventoDTO(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataEvento,
        String local,
        Integer maxVoluntarios,
        Long organizadorId,
        String organizadorNome,
        String status,
        LocalDateTime createdAt
) {
    public EventoDTO(Evento evento) {
        this(
                evento.getId(),
                evento.getTitulo(),
                evento.getDescricao(),
                evento.getDataEvento(),
                evento.getLocal(),
                evento.getMaxVoluntarios(),
                evento.getUsuario().getId(),
                evento.getUsuario().getNome(),
                evento.getStatus(),
                evento.getCreatedAt()
        );
    }
}
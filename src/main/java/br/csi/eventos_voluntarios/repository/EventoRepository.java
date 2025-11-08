package br.csi.eventos_voluntarios.repository;

import br.csi.eventos_voluntarios.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findByUsuarioId(Long usuarioId);
}
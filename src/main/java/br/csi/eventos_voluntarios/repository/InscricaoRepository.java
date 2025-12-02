// src/main/java/br/csi/eventos_voluntarios/repository/InscricaoRepository.java

package br.csi.eventos_voluntarios.repository;

import br.csi.eventos_voluntarios.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
    List<Inscricao> findByUsuarioId(Long usuarioId);
    List<Inscricao> findByEventoId(Long eventoId);
    Optional<Inscricao> findByUsuarioIdAndEventoId(Long usuarioId, Long eventoId);

    int countByEventoId(Long eventoId);
}
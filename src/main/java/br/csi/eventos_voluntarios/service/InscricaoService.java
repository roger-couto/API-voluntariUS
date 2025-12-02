package br.csi.eventos_voluntarios.service;

import br.csi.eventos_voluntarios.model.Evento;
import br.csi.eventos_voluntarios.model.Inscricao;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.repository.EventoRepository;
import br.csi.eventos_voluntarios.repository.InscricaoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InscricaoService {

    private final InscricaoRepository inscricaoRepository;
    private final EventoRepository eventoRepository;

    @Transactional
    public Inscricao inscrever(Long idEvento, Usuario usuario) {
        // 1. Validar se o evento existe
        Evento evento = eventoRepository.findById(idEvento)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado."));

        // 2. Validar se o usuário é o organizador
        if (evento.getUsuario().getId().equals(usuario.getId())) {
            throw new ValidationException("O organizador não pode se inscrever no próprio evento.");
        }

        // 3. Validar se já está inscrito
        if (inscricaoRepository.findByUsuarioIdAndEventoId(usuario.getId(), idEvento).isPresent()) {
            throw new ValidationException("Usuário já inscrito neste evento.");
        }

        // 4. Validar se há vagas (Agora que getMaxVoluntarios compila)
        int inscritos = inscricaoRepository.countByEventoId(idEvento);
        Integer maxVoluntarios = evento.getMaxVoluntarios();

        if (maxVoluntarios != null && inscritos >= maxVoluntarios) {
            throw new ValidationException("Evento lotado.");
        }

        // 5. Criar e salvar inscrição
        Inscricao inscricao = new Inscricao();
        inscricao.setUsuario(usuario);
        inscricao.setEvento(evento);
        inscricao.setStatus("CONFIRMADA");

        return inscricaoRepository.save(inscricao);
    }

    @Transactional
    public void cancelarInscricao(Long idEvento, Usuario usuario) {
        Inscricao inscricao = inscricaoRepository.findByUsuarioIdAndEventoId(usuario.getId(), idEvento)
                .orElseThrow(() -> new EntityNotFoundException("Inscrição não encontrada."));

        inscricaoRepository.delete(inscricao);
    }

    public List<Inscricao> getInscricoesPorUsuario(Long usuarioId) {
        return inscricaoRepository.findByUsuarioId(usuarioId);
    }

    public List<Inscricao> getInscritosPorEvento(Long eventoId) {
        return inscricaoRepository.findByEventoId(eventoId);
    }
}
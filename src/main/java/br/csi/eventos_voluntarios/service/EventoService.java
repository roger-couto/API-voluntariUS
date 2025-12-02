package br.csi.eventos_voluntarios.service;

import br.csi.eventos_voluntarios.dto.EventoCadastroDTO;
import br.csi.eventos_voluntarios.dto.EventoDTO;
import br.csi.eventos_voluntarios.model.Evento;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.repository.EventoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    @Transactional
    public EventoDTO criarEvento(EventoCadastroDTO dto, Usuario organizador) {
        Evento evento = new Evento();
        evento.setTitulo(dto.titulo());
        evento.setDescricao(dto.descricao());
        evento.setDataEvento(dto.dataEvento());
        evento.setLocal(dto.local());
        evento.setMaxVoluntarios(dto.maxVoluntarios());
        evento.setUsuario(organizador);

        // 🔥 CORREÇÃO: FRONT ESPERA "ABERTO"
        evento.setStatus("ABERTO");

        Evento salvo = eventoRepository.save(evento);
        return new EventoDTO(salvo);
    }

    @Transactional(readOnly = true)
    public List<EventoDTO> listarEventos() {
        return eventoRepository.findAll().stream()
                .map(EventoDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EventoDTO getEventoById(Long id) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Evento não encontrado"));
        return new EventoDTO(evento);
    }

    @Transactional(readOnly = true)
    public List<EventoDTO> listarEventosPorOrganizador(Long organizadorId) {
        return eventoRepository.findByUsuarioId(organizadorId).stream()
                .map(EventoDTO::new)
                .collect(Collectors.toList());
    }
}

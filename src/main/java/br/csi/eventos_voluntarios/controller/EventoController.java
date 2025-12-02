package br.csi.eventos_voluntarios.controller;

import br.csi.eventos_voluntarios.dto.EventoCadastroDTO;
import br.csi.eventos_voluntarios.dto.EventoDTO;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.service.EventoService;
import br.csi.eventos_voluntarios.service.InscricaoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@AllArgsConstructor
public class EventoController {

    private final EventoService eventoService;
    private final InscricaoService inscricaoService;

    @PostMapping
    public ResponseEntity<EventoDTO> criarEvento(
            @RequestBody @Valid EventoCadastroDTO dto,
            @AuthenticationPrincipal Usuario usuario,
            UriComponentsBuilder uriBuilder
    ) {
        EventoDTO novoEvento = eventoService.criarEvento(dto, usuario);
        URI location = uriBuilder.path("/eventos/{id}").buildAndExpand(novoEvento.id()).toUri();
        return ResponseEntity.created(location).body(novoEvento);
    }

    @PostMapping("/{idEvento}/inscricao")
    public ResponseEntity<String> inscrever(
            @PathVariable Long idEvento,
            @AuthenticationPrincipal Usuario usuario
    ) {
        inscricaoService.inscrever(idEvento, usuario);
        return ResponseEntity.ok()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("Inscrição realizada com sucesso.");
    }

    @DeleteMapping("/{idEvento}/inscricao")
    public ResponseEntity<String> cancelarInscricao(
            @PathVariable Long idEvento,
            @AuthenticationPrincipal Usuario usuario
    ) {
        inscricaoService.cancelarInscricao(idEvento, usuario);
        return ResponseEntity.ok()
                .header("Content-Type", "text/plain; charset=UTF-8")
                .body("Inscrição cancelada com sucesso.");
    }

    @GetMapping
    public ResponseEntity<List<EventoDTO>> listarEventos() {
        List<EventoDTO> eventos = eventoService.listarEventos();
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoDTO> getEvento(@PathVariable Long id) {
        EventoDTO evento = eventoService.getEventoById(id);
        return ResponseEntity.ok(evento);
    }

    @GetMapping("/meus-eventos")
    public ResponseEntity<List<EventoDTO>> listarMeusEventos(@AuthenticationPrincipal Usuario usuario) {
        List<EventoDTO> eventos = eventoService.listarEventosPorOrganizador(usuario.getId());
        return ResponseEntity.ok(eventos);
    }
}

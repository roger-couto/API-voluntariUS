package br.csi.eventos_voluntarios.controller;

import br.csi.eventos_voluntarios.model.Inscricao;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.service.InscricaoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class InscricaoController {

    private final InscricaoService inscricaoService;

    @GetMapping("/minhas-inscricoes")
    public ResponseEntity<List<Inscricao>> getMinhasInscricoes(@AuthenticationPrincipal Usuario usuario) {
        List<Inscricao> inscricoes = inscricaoService.getInscricoesPorUsuario(usuario.getId());
        return ResponseEntity.ok(inscricoes);
    }

    @GetMapping("/evento/{idEvento}/inscritos")
    public ResponseEntity<List<Inscricao>> getInscritosPorEvento(@PathVariable Long idEvento) {
        List<Inscricao> inscritos = inscricaoService.getInscritosPorEvento(idEvento);
        return ResponseEntity.ok(inscritos);
    }
}
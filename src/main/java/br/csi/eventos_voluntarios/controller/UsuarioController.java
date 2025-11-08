package br.csi.eventos_voluntarios.controller;

import br.csi.eventos_voluntarios.dto.UsuarioCadastroDTO;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarUsuario(@RequestBody @Valid UsuarioCadastroDTO dto, UriComponentsBuilder uriBuilder) {
        Usuario novoUsuario = usuarioService.registrar(dto);
        URI location = uriBuilder.path("/usuarios/{id}").buildAndExpand(novoUsuario.getId()).toUri();
        return ResponseEntity.created(location).body("Usuário registrado com sucesso.");
    }
}
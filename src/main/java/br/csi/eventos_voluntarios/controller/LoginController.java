package br.csi.eventos_voluntarios.controller;

import br.csi.eventos_voluntarios.dto.DadosAutenticacao;
import br.csi.eventos_voluntarios.dto.DadosToken;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.security.TokenServiceJWT;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final AuthenticationManager manager;
    private final TokenServiceJWT tokenService;

    @PostMapping
    public ResponseEntity<DadosToken> login(@RequestBody @Valid DadosAutenticacao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());
        Authentication authentication = manager.authenticate(token);
        var usuario = (Usuario) authentication.getPrincipal();
        var tokenJWT = tokenService.gerarToken(usuario);

        return ResponseEntity.ok(new DadosToken(tokenJWT));
    }
}
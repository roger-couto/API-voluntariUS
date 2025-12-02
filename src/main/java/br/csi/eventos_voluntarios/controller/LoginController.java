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
// 💡 CORRIGIDO: Alterando a rota de /login para /auth para evitar conflito com o filtro padrão do Spring Security
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {

    private final AuthenticationManager manager;
    private final TokenServiceJWT tokenService;

    @PostMapping
    public ResponseEntity<DadosToken> login(@RequestBody @Valid DadosAutenticacao dados) {
        // Cria o objeto de autenticação com e-mail (username) e senha
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.senha());

        // Autentica o usuário usando o AuthenticationManager
        Authentication authentication = manager.authenticate(token);

        // Converte o principal para objeto Usuario e gera o token JWT
        var usuario = (Usuario) authentication.getPrincipal();
        var tokenJWT = tokenService.gerarToken(usuario);

        // Retorna o token com status 200 OK
        return ResponseEntity.ok(new DadosToken(tokenJWT));
    }
}
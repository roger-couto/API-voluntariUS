package br.csi.eventos_voluntarios.service;

import br.csi.eventos_voluntarios.dto.UsuarioCadastroDTO;
import br.csi.eventos_voluntarios.model.Usuario;
import br.csi.eventos_voluntarios.repository.UsuarioRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Usuario registrar(UsuarioCadastroDTO dto) {
        // Verifica se o e-mail já está em uso
        if (usuarioRepository.findByEmail(dto.email()).isPresent()) {
            throw new ValidationException("E-mail já cadastrado.");
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dto.nome());
        novoUsuario.setEmail(dto.email());
        novoUsuario.setTelefone(dto.telefone());
        // Codifica a senha antes de salvar
        novoUsuario.setSenha(passwordEncoder.encode(dto.senha()));

        return usuarioRepository.save(novoUsuario);
    }
}
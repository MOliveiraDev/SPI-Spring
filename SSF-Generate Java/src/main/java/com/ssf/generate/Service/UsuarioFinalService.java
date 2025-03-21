package com.ssf.generate.Service;

import com.ssf.generate.Model.UsuarioFinalModel;
import com.ssf.generate.Repository.UsuarioFinalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioFinalService {

    @Autowired
    private UsuarioFinalRepository usuarioFinalRepository;

    public UsuarioFinalModel cadastrarUsuarioFinal(UsuarioFinalModel usuarioFinalModel) {
        return usuarioFinalRepository.save(usuarioFinalModel);
    }

    public List<UsuarioFinalModel> listarUsuariosFinais() {
        return usuarioFinalRepository.findAll();
    }

    // recuperação de senha
    public void iniciarRecuperacaoSenha(String email) {
        UsuarioFinalModel usuario = usuarioFinalRepository.findByEmail(email);
        if (usuario != null) {
            String token = UUID.randomUUID().toString();
            usuario.setTokenRecuperacao(token);
            usuarioFinalRepository.save(usuario);
            // Enviar e-mail com o token (não implementado aqui)
        }
    }

    // redefinir senha
    public void redefinirSenha(String token, String senha) {
        UsuarioFinalModel usuario = usuarioFinalRepository.findByTokenRecuperacao(token);
        if (usuario != null) {
            usuario.setSenha(senha);
            usuarioFinalRepository.save(usuario);
        }
    }
}
package com.ssf.generate.Controller;

import com.ssf.generate.Controller.dto.CpfDTO;
import com.ssf.generate.Model.UsuarioFinalModel;
import com.ssf.generate.Model.ssfModel;
import com.ssf.generate.Service.UsuarioFinalService;
import com.ssf.generate.Service.ssfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioFinalController {

    @Autowired
    private UsuarioFinalService usuarioFinalService;

    @Autowired
    private ssfService ssfService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioFinalModel> cadastrarUsuarioFinal(@RequestBody UsuarioFinalModel usuarioFinalModel) {
        if (usuarioFinalModel.getNome() == null || usuarioFinalModel.getNome().isEmpty() ||
            usuarioFinalModel.getEmail() == null || usuarioFinalModel.getEmail().isEmpty() ||
            usuarioFinalModel.getSenha() == null || usuarioFinalModel.getSenha().isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(usuarioFinalService.cadastrarUsuarioFinal(usuarioFinalModel));
    }

    //Página de Login
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String senha = payload.get("senha");
        // Verificar se o usuário existe e a senha está correta
        boolean isAuthenticated = usuarioFinalService.autenticarUsuario(email, senha);
        if (isAuthenticated) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping("/gerar-cpf")
    public ResponseEntity<ssfModel> gerarCpf(@RequestBody CpfDTO cpfDTO) {
        ssfModel usuarioSalvo = ssfService.salvarUsuarioComCpf(cpfDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

    //quando o usuario esquecer a senha
    @PostMapping("/esqueceu-senha")
    public ResponseEntity<Void> esqueceuSenha(@RequestBody Map<String, String>payload) {
        String email = payload.get("email");
        usuarioFinalService.iniciarRecuperacaoSenha(email);
        return ResponseEntity.noContent().build();
    }

    //Posso deletar o usuário final por id
    @DeleteMapping("/deletar-usuario/{id}")
    public ResponseEntity<Void> deletarUsuarioPorId(@PathVariable Long id) {
        usuarioFinalService.deletarUsuarioPorId(id);
        return ResponseEntity.noContent().build();
    }


}
package com.ssf.generate.Controller;

import com.ssf.generate.Controller.dto.CpfDTO;
import com.ssf.generate.Model.UsuarioFinalModel;
import com.ssf.generate.Model.ssfModel;
import com.ssf.generate.Service.UsuarioFinalService;
import com.ssf.generate.Service.ssfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioFinalController {

    @Autowired
    private UsuarioFinalService usuarioFinalService;

    @Autowired
    private ssfService ssfService;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioFinalModel> cadastrarUsuarioFinal(@RequestBody UsuarioFinalModel usuarioFinalModel) {
        return ResponseEntity.ok(usuarioFinalService.cadastrarUsuarioFinal(usuarioFinalModel));
    }

    //Página de Login
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestParam String email, @RequestParam String senha) {
        // Verificar se o usuário existe e a senha está correta
        return ResponseEntity.ok().build();
    }

    @PostMapping("/gerar-cpf")
    public ResponseEntity<ssfModel> gerarCpf(@RequestBody CpfDTO cpfDTO) {
        ssfModel usuarioSalvo = ssfService.salvarUsuarioComCpf(cpfDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }

    //quando o usuario esquecer a senha
    @PostMapping("/esqueceu-senha")
    public ResponseEntity<Void> esqueceuSenha(@RequestParam String email) {
        usuarioFinalService.iniciarRecuperacaoSenha(email);
        return ResponseEntity.noContent().build();
    }
}
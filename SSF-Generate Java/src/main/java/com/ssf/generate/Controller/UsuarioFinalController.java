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

    @PostMapping("/gerar-cpf")
    public ResponseEntity<ssfModel> gerarCpf(@RequestBody CpfDTO cpfDTO) {
        ssfModel usuarioSalvo = ssfService.salvarUsuarioComCpf(cpfDTO);
        return ResponseEntity.ok(usuarioSalvo);
    }
}
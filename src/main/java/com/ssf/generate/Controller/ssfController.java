package com.ssf.generate.Controller;

import com.ssf.generate.Service.ssfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class ssfController {

    @Autowired
    private ssfService ssfService;

    // Endpoint para gerar e salvar um CPF
    @PostMapping("/gerar-cpf")
    public String gerarCpf(@RequestParam String estado) {
        return ssfService.salvarCpf(estado);
    }
}
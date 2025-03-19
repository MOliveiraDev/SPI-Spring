package com.ssf.generate.Controller;

import com.ssf.generate.Service.ssfService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.ssf.generate.Controller.dto.ssfDto;
import com.ssf.generate.Model.ssfModel;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class ssfController {

    @Autowired
    private ssfService ssfService;

    // Endpoint para gerar e salvar um CPF
    @PostMapping("/gerar-cpf")
    public ResponseEntity<String> gerarCpf(@RequestParam String estado) {
        if (estado == null || estado.isEmpty()) {
            return ResponseEntity.badRequest().body("O parâmetro 'estado' é obrigatório.");
        }
        String cpf = ssfService.salvarCpf(estado);
        return ResponseEntity.ok(cpf);
    }

    // Endpoint para buscar todos os CPFs
    @GetMapping("/buscar-cpfs")
    public ResponseEntity<List<ssfDto>> buscarCpfs() {
        List<ssfModel> cpfs = ssfService.buscarCpfs();
        List<ssfDto> cpfsDto = cpfs.stream().map(ssfDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(cpfsDto);
    }

    // Endpoint para buscar um CPF por ID
    @GetMapping("/buscar-cpf/{id}")
    public ResponseEntity<ssfDto> buscarCpfPorId(@PathVariable Long id) {
        ssfModel cpf = ssfService.buscarCpfPorId(id);
        return ResponseEntity.ok(new ssfDto(cpf));
    }

    // Endpoint para deletar um CPF por ID
    @DeleteMapping("/deletar-cpf/{id}")
    public ResponseEntity<Void> deletarCpfPorId(@PathVariable Long id) {
        ssfService.deletarCpfPorId(id);
        return ResponseEntity.noContent().build();
    }
   
}
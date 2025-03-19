package com.ssf.generate.Service;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssf.generate.Model.ssfModel;
import com.ssf.generate.Repository.ssfRepository;
import com.ssf.generate.Controller.dto.CpfDTO;

@Service
public class ssfService {

    @Autowired
    private ssfRepository ssfRepository;

    // Gera os primeiros 8 dígitos do CPF dde forma aleatória
    private String gerarPrimeirosDigitosCpf() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) { 
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    // Define o nono dígito com base no estado
    public String DefinirONonoDigito(String estado) {
        switch (estado.toUpperCase()) {
            case "DF":
            case "GO":
            case "MS":
            case "MT":
            case "TO":
                return "1";
            case "AC":
            case "AM":
            case "AP":
            case "PA":
            case "RO":
            case "RR":
                return "2";
            case "CE":
            case "MA":
            case "PI":
                return "3";
            case "AL":
            case "PB":
            case "PE":
            case "RN":
                return "4";
            case "BA":
            case "SE":
                return "5";
            case "MG":
                return "6";
            case "ES":
            case "RJ":
                return "7";
            case "SP":
                return "8";
            case "PR":
            case "SC":
                return "9";
            case "RS":
                return "0";
            default:
                throw new IllegalArgumentException("Estado inválido!");
        }
    }

    // Calcula os dígitos verificadores do CPF
    // Resposável por calcular ois dois dígitos verificadores do CPF
    // O cálculo é feito com base nos pesos 2 a 11, que são multiplicados pelos 9 primeiros dígitos do CPF 
    public String calcularDigitosVeirifcadores(String cpfParcial) {
        if (cpfParcial.length() != 9) {
            throw new IllegalArgumentException("CPF parcial deve ter exatamente 9 caracteres.");
        }

        int[] pesosPrimeiroDigito = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] pesosSegundoDigito = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        // Calculando o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpfParcial.charAt(i))) * pesosPrimeiroDigito[i];
        }
        int primeiroDigito = (soma % 11) < 2 ? 0 : 11 - (soma % 11);

        // Calculando o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpfParcial.charAt(i))) * pesosSegundoDigito[i];
        }
        soma += primeiroDigito * pesosSegundoDigito[9]; // Adiciona o primeiro dígito verificador
        int segundoDigito = (soma % 11) < 2 ? 0 : 11 - (soma % 11);

        return String.valueOf(primeiroDigito) + String.valueOf(segundoDigito);
    }

    // Gera um CPF completo com base no estado
    public String gerarCpf(String estado) {
        String primeirosDigitos = gerarPrimeirosDigitosCpf();
        String nonoDigito = DefinirONonoDigito(estado);
        String cpfParcial = primeirosDigitos + nonoDigito;

        // Verifica se o CPF parcial tem exatamente 9 caracteres
        if (cpfParcial.length() != 9) {
            throw new IllegalArgumentException("CPF parcial deve ter exatamente 9 caracteres.");
        }

        String digitosVerificadores = calcularDigitosVeirifcadores(cpfParcial);
        String cpfCompleto = cpfParcial + digitosVerificadores;

        // Formatação do CPF (XXX.XXX.XXX-XX)
        return cpfCompleto.substring(0, 3) + "." +
               cpfCompleto.substring(3, 6) + "." +
               cpfCompleto.substring(6, 9) + "-" +
               cpfCompleto.substring(9, 11);
    }

    
    public String salvarCpf(String estado) {
        String cpf = gerarCpf(estado);
        ssfModel savedModel = ssfRepository.save(new ssfModel(cpf));
        return savedModel.getCpf();
    }

    
    public ssfModel salvarUsuarioComCpf(CpfDTO cpfDTO) {
        
        String cpf = gerarCpf(cpfDTO.getEstado());

        
        ssfModel usuario = new ssfModel();
        usuario.setName(cpfDTO.getName());
        usuario.setEmail(cpfDTO.getEmail());
        usuario.setEndereco(cpfDTO.getEndereco());
        usuario.setEstado(cpfDTO.getEstado());
        usuario.setCpf(cpf);

        
        return ssfRepository.save(usuario);
    }

    
    public List<ssfModel> buscarCpfs() {
        return ssfRepository.findAll();
    }

    
    public ssfModel buscarCpfPorId(Long id) {
        return ssfRepository.findById(id).orElseThrow(() -> new RuntimeException("CPF não encontrado"));
    }

    
    public void deletarCpfPorId(Long id) {
        ssfRepository.deleteById(id);
    }
}
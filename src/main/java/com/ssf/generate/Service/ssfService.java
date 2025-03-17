package com.ssf.generate.Service;

import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.ssf.generate.Model.ssfModel;

@Service
public class ssfService {

    @Autowired
    private JpaRepository<ssfModel, Long> ssfRepository;

    private String gerarPrimeirosDigitosCpf() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) { // Gera 8 dígitos aleatórios
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public String DefinirONonoDigito(String estado) {
        return switch (estado.toUpperCase()) {
            case "DF", "GO", "MS", "MT", "TO" -> "1";
            case "AC", "AM", "AP", "PA", "RO", "RR" -> "2";
            case "CE", "MA", "PI" -> "3";
            case "AL", "PB", "PE", "RN" -> "4";
            case "BA", "SE" -> "5";
            case "MG" -> "6";
            case "ES", "RJ" -> "7";
            case "SP" -> "8";
            case "PR", "SC" -> "9";
            case "RS" -> "0";
            default -> throw new IllegalArgumentException("Estado inválido!");
        };
    }

    public String calcularDigitosVerificadores(String cpfParcial) {
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

    public String gerarCpf(String estado) {
        String primeirosDigitos = gerarPrimeirosDigitosCpf();
        String nonoDigito = DefinirONonoDigito(estado);
        String cpfParcial = primeirosDigitos + nonoDigito;
        if (cpfParcial.length() != 9) {
            throw new IllegalArgumentException("CPF parcial deve ter exatamente 9 caracteres.");
        }
        String digitosVerificadores = calcularDigitosVerificadores(cpfParcial);
        String cpfCompleto = cpfParcial + digitosVerificadores;

       
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

    public List<ssfModel> buscarCpfs() {
        return ssfRepository.findAll();
    }

    public ssfModel buscarCpfPorId(Long id) {
        return ssfRepository.findById(id).orElseThrow();
    }

    public void deletarCpfPorId(Long id) {
        ssfRepository.deleteById(id);
    }
}
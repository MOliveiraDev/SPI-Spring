package com.ssf.generate.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

@SpringBootTest
public class ssfServiceTest {


    @InjectMocks
    private ssfService ssfService;

    @Test
    public void calcularDigitosVeirifcadoresTest() {
        String cpfParcial = "123456789";
        String digitosVerificadores = ssfService.calcularDigitosVeirifcadores(cpfParcial);
        assertEquals("09", digitosVerificadores); // Substitua "09" pelo valor esperado

        // Teste para CPF parcial com menos de 9 caracteres
        String cpfParcialInvalido = "12345";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ssfService.calcularDigitosVeirifcadores(cpfParcialInvalido);
        });
        assertEquals("Invalid CPF length", exception.getMessage()); 
    }

    @Test
    public void gerarCpfTest() {
        String estado = "SP";
        String cpf = ssfService.gerarCpf(estado);
        assertEquals(14, cpf.length()); // Verifica se o CPF gerado tem o comprimento correto (XXX.XXX.XXX-XX)
        assertEquals('.', cpf.charAt(3)); // Verifica se o CPF gerado tem a formatação correta
        assertEquals('.', cpf.charAt(7)); // Verifica se o CPF gerado tem a formatação correta
        assertEquals('-', cpf.charAt(11)); // Verifica se o CPF gerado tem a formatação correta
    }
}
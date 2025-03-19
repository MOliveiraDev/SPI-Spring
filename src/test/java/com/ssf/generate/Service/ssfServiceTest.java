package com.ssf.generate.Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.InjectMocks;

@SpringBootTest
public class ssfServiceTest {

    @InjectMocks
    private ssfService ssfService;

    @Test
    public void calcularDigitosVeirifcadoresTest() {
        // CPF parcial válido
        String cpfParcial = "123456789";
        String digitosVerificadores = ssfService.calcularDigitosVeirifcadores(cpfParcial);
        assertEquals("09", digitosVerificadores); // O valor esperado deve ser "09" para o CPF parcial "123456789"

        // CPF parcial inválido (menos de 9 caracteres)
        String cpfParcialInvalido = "12345";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ssfService.calcularDigitosVeirifcadores(cpfParcialInvalido);
        });
        assertEquals("CPF parcial deve ter pelo menos 9 caracteres.", exception.getMessage()); // Mensagem de erro esperada
    }

    @Test
    public void DefinirONonoDigitoTest() {
        // Teste para o estado "SP" (deve retornar "8")
        assertEquals("8", ssfService.DefinirONonoDigito("SP"));

        // Teste para o estado "RJ" (deve retornar "7")
        assertEquals("7", ssfService.DefinirONonoDigito("RJ"));

        // Teste para um estado inválido (deve lançar uma exceção)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ssfService.DefinirONonoDigito("XX"); // Estado inválido
        });
        assertEquals("Estado inválido!", exception.getMessage());
    }
}
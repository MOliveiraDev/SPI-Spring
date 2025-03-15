package com.ssf.generate.Service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.mockito.Mock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import com.ssf.generate.Model.ssfModel;

@SpringBootTest
public class ssfServiceTest {

    @Mock
    private JpaRepository<ssfModel, Long> ssfRepository;

    @InjectMocks
    private ssfService ssfService;

    @Test
    public void salvarCpfTest() {
        String estado = "SP";
        String cpf = "123456789";
        when(ssfRepository.save(any(ssfModel.class))).thenReturn(new ssfModel(cpf));
        String resultado = ssfService.salvarCpf(estado);
        assertEquals(cpf, resultado);
    }
}
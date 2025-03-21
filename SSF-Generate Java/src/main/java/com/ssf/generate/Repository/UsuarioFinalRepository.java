package com.ssf.generate.Repository;

import com.ssf.generate.Model.UsuarioFinalModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioFinalRepository extends JpaRepository<UsuarioFinalModel, Long> {
        UsuarioFinalModel findByEmail(String email);
        UsuarioFinalModel findByTokenRecuperacao(String tokenRecuperacao);
}

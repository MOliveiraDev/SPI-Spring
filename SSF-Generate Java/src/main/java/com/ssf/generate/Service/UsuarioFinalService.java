package com.ssf.generate.Service;

import com.ssf.generate.Model.UsuarioFinalModel;
import com.ssf.generate.Repository.UsuarioFinalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioFinalService {

        @Autowired
        private UsuarioFinalRepository usuarioFinalRepository;

        public UsuarioFinalModel cadastrarUsuarioFinal(UsuarioFinalModel usuarioFinalModel) {
            return usuarioFinalRepository.save(usuarioFinalModel);
        }

        public List<UsuarioFinalModel> listarUsuariosFinais() {
            return usuarioFinalRepository.findAll();
        }

}

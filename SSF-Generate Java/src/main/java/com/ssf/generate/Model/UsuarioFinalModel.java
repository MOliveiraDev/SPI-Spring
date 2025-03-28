package com.ssf.generate.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity (name = "usuario_final")
@Table (name = "usuariosfinais")
public class UsuarioFinalModel {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        @Getter
        @Setter
        private String nomeCompleto;
        @Setter
        @Getter
        private String email;
        @Setter
        @Getter
        private String senha;
        @Setter
        @Getter
        private String repetirSenha;
        @Setter
        @Getter
        private String tokenRecuperacao;

        @Setter
        @Getter
        private String nome;

}

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
@Table
public class UsuarioFinalModel {

        @Id
        @GeneratedValue (strategy = GenerationType.IDENTITY)
        private Long id;

        private String nomeCompleto;
        private String email;
        private String senha;
        private String repetirSenha;



}

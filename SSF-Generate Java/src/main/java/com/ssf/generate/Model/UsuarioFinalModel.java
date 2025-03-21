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

        private String nomeCompleto;
        private String email;
        private String senha;
        private String repetirSenha;
        private String tokenRecuperacao;

        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getNomeCompleto() {
            return nomeCompleto;
        }

        public void setNomeCompleto(String nomeCompleto) {
            this.nomeCompleto = nomeCompleto;
        }

        public String getRepetirSenha() {
            return repetirSenha;
        }

        public void setRepetirSenha(String repetirSenha) {
            this.repetirSenha = repetirSenha;
        }

        public String getTokenRecuperacao() {
            return tokenRecuperacao;
        }

        public void setTokenRecuperacao(String tokenRecuperacao) {
            this.tokenRecuperacao = tokenRecuperacao;
        }
}

package com.ssf.generate.Controller.dto;

import com.ssf.generate.Model.ssfModel;

public class ssfDto {
    private Long id;
    private String name;
    private String email;
    private String endereco;
    private String estado;
    private String cpf;

    public ssfDto(ssfModel model) {
        this.id = model.getId();
        this.name = model.getName();
        this.email = model.getEmail();
        this.endereco = model.getEndereco();
        this.estado = model.getEstado();
        this.cpf = model.getCpf();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
package com.ssf.generate.Controller.dto;

import com.ssf.generate.Model.ssfModel;

public record ssfDto(String name, String email, String endereco, String estado, String cpf) {

    public ssfDto(ssfModel model) {
        this(model.getName(), model.getEmail(), model.getEndereco(), model.getEstado(), model.getCpf());
    }
}
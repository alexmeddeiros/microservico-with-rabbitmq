package com.alex.propostaapp.dto;

import java.util.Objects;

public class PropostaRequestDto {

    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private Double renda;
    private Double valorSolicitado;
    private int prazoPagamento;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Double getValorSolicitado() {
        return valorSolicitado;
    }

    public void setValorSolicitado(Double valorSolicitado) {
        this.valorSolicitado = valorSolicitado;
    }

    public int getPrazoPagamento() {
        return prazoPagamento;
    }

    public void setPrazoPagamento(int prazoPagamento) {
        this.prazoPagamento = prazoPagamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PropostaRequestDto that = (PropostaRequestDto) o;
        return prazoPagamento == that.prazoPagamento && Objects.equals(nome, that.nome) && Objects.equals(sobrenome, that.sobrenome) && Objects.equals(cpf, that.cpf) && Objects.equals(telefone, that.telefone) && Objects.equals(renda, that.renda) && Objects.equals(valorSolicitado, that.valorSolicitado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sobrenome, cpf, telefone, renda, valorSolicitado, prazoPagamento);
    }

    public PropostaRequestDto(){ }

    public PropostaRequestDto(String nome, String sobrenome, String cpf, String telefone, Double renda, Double valorSolicitado, int prazoPagamento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.renda = renda;
        this.valorSolicitado = valorSolicitado;
        this.prazoPagamento = prazoPagamento;
    }
}

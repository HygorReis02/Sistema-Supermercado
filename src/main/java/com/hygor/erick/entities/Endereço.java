package com.hygor.erick.entities;

import java.util.Objects;

public class Endereço {
    private String rua;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereço() {
        this.rua = "";
        this.numero = "";
        this.complemento = "";
        this.bairro = "";
        this.cidade = "";
        this.estado = "";
        this.cep = "";
    }

    public Endereço(String rua, String numero, String complemento, String bairro,
                    String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }

    //Get
    public String getRua() {
        return rua;
    }
    public String getNumero() {
        return numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getEstado() {
        return estado;
    }
    public String getCep() {
        return cep;
    }
    
    //Set
    public void setRua(String rua) {
        this.rua = rua;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    
    @Override
    public String toString() {
        return "Endereco{rua='" + rua + "', numero='" + numero + "', complemento='" + complemento +
               "', bairro='" + bairro + "', cidade='" + cidade + "', estado='" + estado +
               "', cep='" + cep + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Endereço other = (Endereço) obj;
        return Objects.equals(rua, other.rua) &&
               Objects.equals(numero, other.numero) &&
               Objects.equals(complemento, other.complemento) &&
               Objects.equals(bairro, other.bairro) &&
               Objects.equals(cidade, other.cidade) &&
               Objects.equals(estado, other.estado) &&
               Objects.equals(cep, other.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rua, numero, complemento, bairro, cidade, estado, cep);
    }
}

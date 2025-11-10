package com.hygor.erick.Valid;

import com.hygor.erick.entities.Endereço;
import com.hygor.erick.exception.EndereçoException;

public class ValidEndereço {

    public Endereço validacao(String rua, String numero, String complemento, String bairro,
                              String cidade, String estado, String cep) {
        Endereço endereco = new Endereço();

        if (rua == null || rua.isEmpty()) throw new EndereçoException("Erro - Campo vazio: 'rua'");
        endereco.setRua(rua);

        if (numero == null || numero.isEmpty()) throw new EndereçoException("Erro - Campo vazio: 'número'");
        endereco.setNumero(numero);

        if (complemento == null) complemento = ""; // complemento pode ser vazio
        endereco.setComplemento(complemento);

        if (bairro == null || bairro.isEmpty()) throw new EndereçoException("Erro - Campo vazio: 'bairro'");
        endereco.setBairro(bairro);

        if (cidade == null || cidade.isEmpty()) throw new EndereçoException("Erro - Campo vazio: 'cidade'");
        endereco.setCidade(cidade);

        if (estado == null || estado.isEmpty()) throw new EndereçoException("Erro - Campo vazio: 'estado'");
        endereco.setEstado(estado);

        if (cep == null || cep.isEmpty()) throw new EndereçoException("Erro - Campo vazio: 'cep'");
        endereco.setCep(cep);

        return endereco;
    }
}

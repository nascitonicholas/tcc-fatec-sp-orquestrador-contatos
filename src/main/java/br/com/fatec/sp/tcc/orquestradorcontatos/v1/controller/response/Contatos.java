package br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contatos {

    @JsonProperty("subtitle")
    private String nomeSecao;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phone")
    private String telefone;

}

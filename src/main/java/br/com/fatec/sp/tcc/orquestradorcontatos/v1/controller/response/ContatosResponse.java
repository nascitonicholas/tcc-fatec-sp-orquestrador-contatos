package br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatosResponse {

    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String nomeDivisao;
    @JsonProperty("contatos")
    private List<Contatos> contatos;

}

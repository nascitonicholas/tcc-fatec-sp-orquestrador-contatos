package br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class ContatosBdResponse {

    @JsonProperty("data")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private List<ContatosBd> responseBody = new ArrayList<>();

    @JsonProperty("message")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  message;

    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_NULL)
    private String  description;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties
    public static class ContatosBd {

        @JsonProperty("id_contato")
        private Long id;
        @JsonProperty("divisao")
        private ContatosDivisoesBdResponse divisoesModel;
        @JsonProperty("secao")
        private ContatosSecoesBdResponse secoesModel;
        @JsonProperty("telefone")
        private String telefone;
        @JsonProperty("email")
        private String email;
        @JsonProperty("data_criacao")
        private String dataCriacao;
        @JsonProperty("data_ultima_alteracao")
        private String dataUltimaAlteracao;

    }

}

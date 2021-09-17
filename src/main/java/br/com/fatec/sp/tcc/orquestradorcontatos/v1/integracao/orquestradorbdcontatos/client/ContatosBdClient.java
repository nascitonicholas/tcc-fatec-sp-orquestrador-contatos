package br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.client;

import br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.response.ContatosBdResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name= "contatosBdClient",  url = "${contatos.bd.url}")
public interface ContatosBdClient {

    @GetMapping(value = "/contatos", consumes = MediaType.APPLICATION_JSON_VALUE)
    ContatosBdResponse getListaContatos();

}

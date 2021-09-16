package br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.service;

import br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.client.ContatosBdClient;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.response.ContatosBdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContatosBdService {

    @Autowired
    private ContatosBdClient contatosBdClient;

    public List<ContatosBdResponse.ContatosBd> getListaContatos() {
       return contatosBdClient.getListaContatos().getResponseBody();
    }

}

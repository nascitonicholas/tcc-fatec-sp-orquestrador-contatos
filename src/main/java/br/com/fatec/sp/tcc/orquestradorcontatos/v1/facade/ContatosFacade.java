package br.com.fatec.sp.tcc.orquestradorcontatos.v1.facade;

import br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller.response.ContatosResponse;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.response.ContatosBdResponse;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.service.ContatosBdService;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.mapper.ContatosMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ContatosFacade {

    @Autowired
    private ContatosBdService contatosBdService;

    private ContatosMapper mapper = Mappers.getMapper(ContatosMapper.class);

    public List<ContatosResponse> get() {
        List<ContatosBdResponse.ContatosBd> listaContatos = contatosBdService.getListaContatos();
        return mapper.mapListaContatosBdResponseToListaContatosResponse(listaContatos);
    }

}

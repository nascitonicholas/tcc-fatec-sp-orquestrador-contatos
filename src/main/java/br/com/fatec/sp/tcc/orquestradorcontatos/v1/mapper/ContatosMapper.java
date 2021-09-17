package br.com.fatec.sp.tcc.orquestradorcontatos.v1.mapper;

import br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller.response.Contatos;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller.response.ContatosResponse;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.integracao.orquestradorbdcontatos.response.ContatosBdResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.*;
import java.util.stream.Collectors;

@Mapper
public interface ContatosMapper {

    @Named("mapListaContatosBdResponseToListaContatosResponse")
    default List<ContatosResponse> mapListaContatosBdResponseToListaContatosResponse(List<ContatosBdResponse.ContatosBd> contatosBdResponse) {
        List<ContatosResponse> response = new ArrayList<>();
        contatosBdResponse.forEach(item -> {
            if(Objects.isNull(response) || response.isEmpty()) {
                ContatosResponse primeiroContato = new ContatosResponse();
                primeiroContato.setId(Integer.toString(response.size() + 1));
                primeiroContato.setNomeDivisao(item.getDivisoesModel().getNomeDivisao());
                Contatos primeiroContatoParcial = new Contatos();
                primeiroContatoParcial.setNomeSecao(item.getSecoesModel().getNomeSecao());
                primeiroContatoParcial.setEmail(item.getEmail());
                primeiroContatoParcial.setTelefone(item.getTelefone());
                primeiroContato.getContatos().add(primeiroContatoParcial);
                response.add(primeiroContato);
            } else {
                List<ContatosResponse> contatosResponsefilter = response.stream().filter(resposta ->
                                resposta.getNomeDivisao().equalsIgnoreCase(item.getDivisoesModel().getNomeDivisao()))
                        .collect(Collectors.toList());
                if(Objects.nonNull(contatosResponsefilter) && !contatosResponsefilter.isEmpty()) {
                    Contatos contato = new Contatos(item.getSecoesModel().getNomeSecao(),
                            item.getEmail(), item.getTelefone());
                    response.stream().filter(resposta ->
                                    resposta.getNomeDivisao().equalsIgnoreCase(item.getDivisoesModel().getNomeDivisao()))
                            .findFirst().get().getContatos().add(contato);
                } else {
                    Contatos contato = new Contatos(item.getSecoesModel().getNomeSecao(),
                            item.getEmail(), item.getTelefone());
                    List<Contatos> listaContatos = new ArrayList<>();
                    listaContatos.add(contato);
                    ContatosResponse contatosResponse = new ContatosResponse(Integer.toString(response.size() + 1),
                            item.getDivisoesModel().getNomeDivisao(),
                            listaContatos);
                    response.add(contatosResponse);
                }
            }
        });
        return response;
    }

}

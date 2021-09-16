package br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller;

import br.com.fatec.sp.tcc.orquestradorcontatos.v1.config.AbstractController;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.config.SaidaDefault;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.controller.response.ContatosResponse;
import br.com.fatec.sp.tcc.orquestradorcontatos.v1.facade.ContatosFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lista-contatos")
public class ListaContatosController implements AbstractController<SaidaDefault> {

    @Autowired
    private ContatosFacade contatosFacade;

    @GetMapping
    public ResponseEntity<?> get() {
        List<ContatosResponse> response = contatosFacade.get();
        return saidaSimplificada(SaidaDefault.builder().responseBody(response).message("Lista de Contatos retornada").build(), HttpStatus.OK);
    }

}

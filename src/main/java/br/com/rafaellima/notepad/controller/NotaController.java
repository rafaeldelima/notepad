package br.com.rafaellima.notepad.controller;

import br.com.rafaellima.notepad.model.Nota;
import br.com.rafaellima.notepad.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {

    @Autowired
    NotaService notaService;

    @GetMapping
    public List<Nota> buscarNotas(){
        return notaService.buscarTodas();
    }

    @GetMapping(value = "/titulo/{titulo}")
    public Nota buscarPeloTitulo(@PathVariable(value = "titulo") String titulo){
        return notaService.buscar(titulo);
    }

    @PostMapping
    public void salvar(@RequestBody Nota nota){
        notaService.salvarNota(nota);
    }
}

package br.com.rafaellima.notepad.service;

import br.com.rafaellima.notepad.model.Nota;
import br.com.rafaellima.notepad.repository.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaService {

    @Autowired
    NotaRepository notaRepository;

    public void salvarNota(Nota nota){
        Nota notaBanco = notaRepository.findByTitulo(nota.getTitulo());
        if(notaBanco != null){
            nota.setId(notaBanco.getId());
        }
        notaRepository.save(nota);
    }

    public List<Nota> buscarTodas(){
        return notaRepository.findAll();
    }

    public Nota buscar(String titulo){
        Nota nota = notaRepository.findByTitulo(titulo);
        if(nota == null){
            nota = new Nota();
        }
        return nota;
    }

    public void delete(Nota nota){
        notaRepository.delete(nota);
    }
}

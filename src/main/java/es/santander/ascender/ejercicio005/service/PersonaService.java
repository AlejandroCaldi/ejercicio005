package es.santander.ascender.ejercicio005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.santander.ascender.ejercicio005.model.Persona;
import es.santander.ascender.ejercicio005.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository repository;

    public Persona create(Persona boligrafo) {
        if (boligrafo.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de Persona utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 boligrafo.getId());
        }
        return repository.save(boligrafo);
    }

    public Persona read(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Persona> read() {
        return repository.findAll();
    }

    public Persona update(Persona boligrafo) {
        if (boligrafo.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro Persona utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);
            
        }
        return repository.save(boligrafo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }
}

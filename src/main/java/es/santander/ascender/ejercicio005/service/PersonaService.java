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

    public Persona create(Persona persona) {
        if (persona.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de Persona utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 persona.getId());
        }
        return repository.save(persona);
    }

    public Persona read(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Persona> read() {
        return repository.findAll();
    }

    public Persona update(Persona persona) {
        if (persona.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro Persona utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);
            
        }
        return repository.save(persona);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }

    public List<Persona> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Persona> buscarPorNombreFiltrado(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Persona> buscarPorApellido(String apellido) {
        return repository.findByApellido(apellido);
    }

    public List<Persona> buscarPorApellidoFiltrado(String apellido) {
        return repository.findByApellidoContainingIgnoreCase(apellido);
    }

    public List<Persona> buscarPorProvincia(Long provincia_Id) {
        return repository.findByProvincia(provincia_Id);
    }
}

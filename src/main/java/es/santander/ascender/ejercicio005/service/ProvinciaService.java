package es.santander.ascender.ejercicio005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejercicio005.model.Provincia;
import es.santander.ascender.ejercicio005.repository.ProvinciaRepository;

@Service
@Transactional
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository repository;

    public Provincia create(Provincia provincia) {
        if (provincia.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de provincia utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 provincia.getId());
        }
        return repository.save(provincia);
    }

    @Transactional(readOnly = true)
    public Provincia read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Provincia> read() {
        return repository.findAll();
    }

    public Provincia update(Provincia provincia) {
        if (provincia.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro provincia utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);
            
        }
        return repository.save(provincia);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }

    public List<Provincia> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Provincia> buscarPorNombreFiltro(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

}

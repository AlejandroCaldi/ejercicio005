package es.santander.ascender.ejercicio005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejercicio005.enums.Paises;
import es.santander.ascender.ejercicio005.model.Pais;
import es.santander.ascender.ejercicio005.repository.PaisRepository;

@Service
@Transactional
public class PaisService {

    @Autowired
    private PaisRepository repository;

    public Pais create(Pais pais) {
        if (pais.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de pais utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 pais.getId());
        }
        return repository.save(pais);
    }

    @Transactional(readOnly = true)
    public Pais read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    public List<Pais> read() {
        return repository.findAll();
    }

    public Pais update(Pais pais) {
        if (pais.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro pais utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);           
        }
        return repository.save(pais);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }

    public List<Pais> buscarPorNombre(Paises nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Pais> buscarPorNombreFiltro(Paises nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

}

package es.santander.ascender.ejercicio005.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 
// Este es el unico caso en que necesitamos este import en vez del de Jakarta.

import es.santander.ascender.ejercicio005.enums.CRUDOperation;
import es.santander.ascender.ejercicio005.model.Documento;
import es.santander.ascender.ejercicio005.repository.DocumentoRepository;


@Service
@Transactional
public class DocumentoService {

    @Autowired
    private DocumentoRepository repository;

    public Documento create(Documento documento) {
        if (documento.getId() != null) {
            throw new CrudSecurityException("Han tratado de modificar un registro de Documento utilizando la creación",
                                                 CRUDOperation.CREATE, 
                                                 documento.getId());
        }
        return repository.save(documento);
    }

    @Transactional(readOnly=true)
    public Documento read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional(readOnly=true)
    public List<Documento> read() {
        return repository.findAll();
    }

    public Documento update(Documento documento) {
        if (documento.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro Documento utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);
        }
        return repository.save(documento);
    }

    public void delete(Long id) {
        repository.deleteById(id);
        return;
    }

    public List<Documento> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    public List<Documento> buscarPorNombreFiltrado(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }
    
    public List<Documento> buscarPorExtension(String extension) {
        return repository.findByExtension(extension);
    }

    public List<Documento> buscarPorExtensionFiltrado(String extension) {
        return repository.findByExtensionContainingIgnoreCase(extension);
    }
}

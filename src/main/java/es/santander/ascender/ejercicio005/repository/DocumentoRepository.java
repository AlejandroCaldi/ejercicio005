package es.santander.ascender.ejercicio005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List<Documento> findByNombre(String nombre);
    List<Documento> findByNombreContainingIgnoreCase(String nombre);
    List<Documento> findByExtension(String apellido);
    List<Documento> findByExtensionContainingIgnoreCase(String nombre);
  
}

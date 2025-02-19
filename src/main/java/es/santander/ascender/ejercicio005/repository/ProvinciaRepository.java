package es.santander.ascender.ejercicio005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.model.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {
        List<Provincia> findByNombre(String nombre);
        List<Provincia> findByNombreContainingIgnoreCase(String nombre);


}

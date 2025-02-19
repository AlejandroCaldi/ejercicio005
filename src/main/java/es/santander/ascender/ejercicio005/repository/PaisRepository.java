package es.santander.ascender.ejercicio005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
        List<Pais> findByNombre(String nombre);
        List<Pais> findByNombreContainingIgnoreCase(String nombre);


}

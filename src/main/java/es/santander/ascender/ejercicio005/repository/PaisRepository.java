package es.santander.ascender.ejercicio005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.enums.Paises;
import es.santander.ascender.ejercicio005.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {
        List<Pais> findByNombre(Paises nombre);
        List<Pais> findByNombreContainingIgnoreCase(Enum<Paises> nombre);


}

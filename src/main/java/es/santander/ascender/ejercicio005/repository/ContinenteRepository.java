package es.santander.ascender.ejercicio005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.enums.Continentes;
import es.santander.ascender.ejercicio005.model.Continente;

public interface ContinenteRepository extends JpaRepository<Continente, Long> {
        List<Continente> findByNombre(Continentes nombre);
        List<Continente> findByNombreContainingIgnoreCase(Enum<Continentes> nombre);


}

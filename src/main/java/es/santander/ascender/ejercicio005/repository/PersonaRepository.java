package es.santander.ascender.ejercicio005.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}

package es.santander.ascender.ejercicio005.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejercicio005.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    List<Persona> findByNombre(String nombre);
    List<Persona> findByNombreContainingIgnoreCase(String nombre);
    List<Persona> findByApellido(String apellido);
    List<Persona> findByApellidoContainingIgnoreCase(String nombre);
    List<Persona> findByProvincia(Long provincia_Id);
  
}

package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejercicio005.model.Persona;

@SpringBootTest
public class PersonaRepositoryTest {

    @Autowired
    private PersonaRepository repository;

    @Test
    public void testCreate() {
        Persona persona = new Persona();
        persona.setNombre("Alejandro");
        persona.setApellido("Caldi");
        persona.setProvincia_Id(25l);

        repository.save(persona);

        assertTrue(
            repository
                .findById(persona.getId())
                .isPresent());
    }


    @Test
    public void delete() {

        Persona persona = new Persona();
        persona.setNombre("John");
        persona.setApellido("Balls");
        persona.setProvincia_Id(14l);
        repository.save(persona);

        assertTrue(repository.existsById(persona.getId()));

        repository.deleteById(persona.getId());

        assertFalse(repository.existsById(persona.getId()));
    }

    @Test
    public void view() {

        String nombre = "John";
        Persona persona = new Persona();
        persona.setNombre(nombre);
        persona.setApellido("Balls");
        persona.setProvincia_Id(1l);
        repository.save(persona);

        Optional<Persona> registro = repository.findById(persona.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals(nombre));
    }

    @Test
    public void update() {

        String apellidoOriginal = "Pelotas";
        String apellidoNuevo = "Gomez";
        Persona persona = new Persona();
        persona.setNombre("Sebastián");
        persona.setApellido(apellidoOriginal);
        persona.setProvincia_Id(6l);
        repository.save(persona);

        assertTrue(repository.existsById(persona.getId()));

        persona.setApellido(apellidoNuevo);
        repository.save(persona);

        Optional<Persona> updatedPersona = repository.findById(persona.getId());

        assertTrue(updatedPersona.isPresent());
        assertTrue(updatedPersona.get().getApellido().equals(apellidoNuevo));


    }

}

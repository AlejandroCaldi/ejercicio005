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
        persona.setNombre("La firma de un grande");
        persona.setColor("##2587f");
        persona.setEscribe(true);
        


        repository.save(persona);

        assertTrue(
            repository
                .findById(persona.getId())
                .isPresent());
    }


    @Test
    public void delete() {

        Persona persona = new Persona();
        persona.setColor("#0100fe");
        persona.setEscribe(true);
        persona.setNombre("Mi primer boli azul");
        repository.save(persona);

        assertTrue(repository.existsById(persona.getId()));

        // Borrar registro y comprobar que fue borrado
        repository.deleteById(persona.getId());

        assertFalse(repository.existsById(persona.getId()));
    }

    @Test
    public void view() {

        String color = "#2f0189";
        Persona persona = new Persona();
        persona.setColor(color);
        persona.setEscribe(true);
        persona.setNombre("Mi firmador de contratos");
        repository.save(persona);

        Optional<Persona> registro = repository.findById(persona.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getColor().equals(color));
    }

    @Test
    public void update() {

        String colorOriginal = "#2f0189";
        String colorNuevo = "#de0189";
        Persona persona = new Persona();
        persona.setColor(colorOriginal);
        persona.setEscribe(true);
        persona.setNombre("Para cartas de amor");
        repository.save(persona);

        assertTrue(repository.existsById(persona.getId()));

        persona.setColor(colorNuevo);
        repository.save(persona);

        Optional<Persona> updatedPersona = repository.findById(persona.getId());

        assertTrue(updatedPersona.isPresent());
        assertTrue(updatedPersona.get().getColor().equals(colorNuevo));
    }

}

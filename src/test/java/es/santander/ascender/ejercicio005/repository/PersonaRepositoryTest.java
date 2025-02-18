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
        Persona boligrafo = new Persona();
        boligrafo.setNombre("La firma de un grande");
        boligrafo.setColor("##2587f");
        boligrafo.setEscribe(true);
        


        repository.save(boligrafo);

        assertTrue(
            repository
                .findById(boligrafo.getId())
                .isPresent());
    }


    @Test
    public void delete() {

        Persona boligrafo = new Persona();
        boligrafo.setColor("#0100fe");
        boligrafo.setEscribe(true);
        boligrafo.setNombre("Mi primer boli azul");
        repository.save(boligrafo);

        assertTrue(repository.existsById(boligrafo.getId()));

        // Borrar registro y comprobar que fue borrado
        repository.deleteById(boligrafo.getId());

        assertFalse(repository.existsById(boligrafo.getId()));
    }

    @Test
    public void view() {

        String color = "#2f0189";
        Persona boligrafo = new Persona();
        boligrafo.setColor(color);
        boligrafo.setEscribe(true);
        boligrafo.setNombre("Mi firmador de contratos");
        repository.save(boligrafo);

        Optional<Persona> registro = repository.findById(boligrafo.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getColor().equals(color));
    }

    @Test
    public void update() {

        String colorOriginal = "#2f0189";
        String colorNuevo = "#de0189";
        Persona boligrafo = new Persona();
        boligrafo.setColor(colorOriginal);
        boligrafo.setEscribe(true);
        boligrafo.setNombre("Para cartas de amor");
        repository.save(boligrafo);

        assertTrue(repository.existsById(boligrafo.getId()));

        boligrafo.setColor(colorNuevo);
        repository.save(boligrafo);

        Optional<Persona> updatedPersona = repository.findById(boligrafo.getId());

        assertTrue(updatedPersona.isPresent());
        assertTrue(updatedPersona.get().getColor().equals(colorNuevo));
    }

}

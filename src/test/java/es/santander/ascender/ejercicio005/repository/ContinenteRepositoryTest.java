package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejercicio005.model.Continente;

@SpringBootTest
public class ContinenteRepositoryTest {

    @Autowired
    private ContinenteRepository repository;


    @Test
    public void testCreate() {

        Continente continente = new Continente();
        continente.setNombre("América");
        repository.save(continente);

        assertTrue(
            repository
                .findById(continente.getId())
                .isPresent());
    }

    @Test
    public void testCreateMalContinente() {

        Continente continente = new Continente();
        continente.setNombre("Europa");
        continente.setId(7l);
        assertThrows(Exception.class, () -> repository.save(continente));

    }


    @Test
    public void delete() {

        Continente continente = new Continente();
        continente.setNombre("Asia");
        repository.save(continente);

        assertTrue(repository.existsById(continente.getId()));

        repository.deleteById(continente.getId());

        assertFalse(repository.existsById(continente.getId()));
    }

    @Test
    public void view() {

        String nombre = "Oceanía";
        Continente continente = new Continente();
        continente.setNombre(nombre);
        repository.save(continente);

        Optional<Continente> registro = repository.findById(continente.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals(nombre));
    }

    @Test
    public void update() {

        String continenteNuevo = "Asia";
        Continente continente = new Continente();
        continente.setNombre("Antartida");
        repository.save(continente);

        assertTrue(repository.existsById(continente.getId()));

        continente.setNombre(continenteNuevo);
        repository.save(continente);

        Optional<Continente> updatedContinente = repository.findById(continente.getId());

        assertTrue(updatedContinente.isPresent());
        assertTrue(updatedContinente.get().getNombre().equals(continenteNuevo));


    }

}

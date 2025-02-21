package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejercicio005.enums.Continentes;
import es.santander.ascender.ejercicio005.model.Continente;

@SpringBootTest
public class ContinenteRepositoryTest {

    @Autowired
    private ContinenteRepository repository;


    private Continente getContinente(Continentes continent) {
        Continente continente = new Continente();
        continente.setNombre(continent);
        return continente;
    }


    @Test
    public void testCreate() {

        Continente continente = getContinente(Continentes.EUROPA);
        repository.save(continente);

        assertTrue(
            repository
                .findById(continente.getId())
                .isPresent());
    }

    @Test
    public void delete() {

        Continente continente = getContinente(Continentes.AMERICA);
        repository.save(continente);

        assertTrue(repository.existsById(continente.getId()));

        repository.deleteById(continente.getId());

        assertFalse(repository.existsById(continente.getId()));
    }

    @Test
    public void view() {

        Continentes nombre = Continentes.OCEANIA;
        Continente continente = getContinente(nombre);
        repository.save(continente);

        Optional<Continente> registro = repository.findById(continente.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals(nombre));
    }

    @Test
    public void update() {

        Continentes continenteNuevo = Continentes.ANTARTIDA;
        Continente continente = getContinente(continenteNuevo);
        repository.save(continente);

        assertTrue(repository.existsById(continente.getId()));

        continente.setNombre(continenteNuevo);
        repository.save(continente);

        Optional<Continente> updatedContinente = repository.findById(continente.getId());

        assertTrue(updatedContinente.isPresent());
        assertTrue(updatedContinente.get().getNombre().equals(continenteNuevo));


    }

}

package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejercicio005.model.Pais;

@SpringBootTest
public class PaisRepositoryTest {

    @Autowired
    private PaisRepository repository;


    @Test
    public void testCreate() {

        Pais pais = new Pais();
        pais.setNombre("España");
        pais.setContinenteId((short) 3);
        repository.save(pais);

        assertTrue(
            repository
                .findById(pais.getId())
                .isPresent());
    }

    @Test
    public void testCreateMalContinente() {

        Pais pais = new Pais();
        pais.setNombre("España");
        pais.setContinenteId((short) 7);
        assertThrows(Exception.class, () -> repository.save(pais));

    }


    @Test
    public void delete() {

        Pais pais = new Pais();
        pais.setNombre("Argentina");
        pais.setContinenteId((short) 2);
        repository.save(pais);

        assertTrue(repository.existsById(pais.getId()));

        repository.deleteById(pais.getId());

        assertFalse(repository.existsById(pais.getId()));
    }

    @Test
    public void view() {

        String nombre = "Tailandia";
        Pais pais = new Pais();
        pais.setNombre(nombre);
        pais.setContinenteId((short) 1);
        repository.save(pais);

        Optional<Pais> registro = repository.findById(pais.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals(nombre));
    }

    @Test
    public void update() {

        String paisNuevo = "Australia";
        Pais pais = new Pais();
        pais.setNombre("Nueva Zelanda");
        pais.setContinenteId((short) 3);
        repository.save(pais);

        assertTrue(repository.existsById(pais.getId()));

        pais.setNombre(paisNuevo);
        repository.save(pais);

        Optional<Pais> updatedPais = repository.findById(pais.getId());

        assertTrue(updatedPais.isPresent());
        assertTrue(updatedPais.get().getNombre().equals(paisNuevo));


    }

}

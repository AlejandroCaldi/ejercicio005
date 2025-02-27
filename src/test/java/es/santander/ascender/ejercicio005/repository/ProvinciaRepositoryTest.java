package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejercicio005.model.Provincia;

@SpringBootTest
public class ProvinciaRepositoryTest {

    @Autowired
    private ProvinciaRepository repository;

    private Provincia getProvincia(String nombre, Long paisId) {
        Provincia provincia = new Provincia();
        provincia.setNombre(nombre);
        provincia.setPaisId(paisId);
        return provincia;

    }
    @Test
    public void testCreate() {

        Provincia provincia = getProvincia("Cantabeia", 5l);
        repository.save(provincia);

        assertTrue(
            repository
                .findById(provincia.getId())
                .isPresent());
    }


   


    @Test
    public void delete() {

        Provincia provincia = new Provincia("Barcelona",2l);
        repository.save(provincia);

        assertTrue(repository.existsById(provincia.getId()));

        repository.deleteById(provincia.getId());

        assertFalse(repository.existsById(provincia.getId()));
    }

    @Test
    public void view() {

        String nombre = "Navarra";
        Provincia provincia = new Provincia(nombre, 1l);
        repository.save(provincia);

        Optional<Provincia> registro = repository.findById(provincia.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals(nombre));
    }

    @Test
    public void update() {

        String provinciaNuevo = "Asturias";
        Provincia provincia = new Provincia("Islas Canarias", 2l);
        repository.save(provincia);

        assertTrue(repository.existsById(provincia.getId()));

        provincia.setNombre(provinciaNuevo);
        repository.save(provincia);

        Optional<Provincia> updatedProvincia = repository.findById(provincia.getId());

        assertTrue(updatedProvincia.isPresent());
        assertTrue(updatedProvincia.get().getNombre().equals(provinciaNuevo));


    }

}

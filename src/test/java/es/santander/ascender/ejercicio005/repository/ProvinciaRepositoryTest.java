package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import es.santander.ascender.ejercicio005.model.Provincia;

@SpringBootTest
public class ProvinciaRepositoryTest {

    @Autowired
    private ProvinciaRepository repository;

    private Provincia establecerProvincia(Short colorR, Short colorG, Short colorB, 
                                          Double peso, Boolean esIntel, short numeroTeclas) {
        
        Provincia provincia = new Provincia();
        provincia.setColorR(colorR);
        provincia.setColorG(colorG);
        provincia.setColorB(colorB);
        provincia.setPeso(peso);
        provincia.setEsIntel(esIntel);
        provincia.setNumeroTeclas(numeroTeclas);

        repository.save(provincia);

        return provincia;
    }
                                        
    @Test
    public void testCreate() {
        Provincia provincia = establecerProvincia((short) 1, (short) 25, (short) 33, 3.1, false, (short) 101);
        
        assertTrue(
            repository
                .findById(provincia.getId())
                .isPresent());
    }

    @Test
    public void testCreateFallidoColor() {
        
        Provincia provincia = new Provincia();
        provincia.setColorR((short)-1);
        
        assertThrows(TransactionSystemException.class, () -> repository.save(provincia));
    }

    @Test
    public void testCreateFallidoTeclado() {
        
        Provincia provincia = new Provincia();
        provincia.setNumeroTeclas((short)-1);
        
        assertThrows(TransactionSystemException.class, () -> repository.save(provincia));
    }

    @Test
    public void testCreateFallidoPeso() {
        
        Provincia provincia = new Provincia();
        provincia.setPeso(-1.04);
        
        assertThrows(TransactionSystemException.class, () -> repository.save(provincia));
    }

    @Test
    public void delete() {

        Provincia provincia = establecerProvincia((short) 125, (short) 250, (short) 33, 2.1, true, (short) 99);

        assertTrue(repository.existsById(provincia.getId()));

        // Borrar registro y comprobar que fue borrado
        repository.deleteById(provincia.getId());

        assertFalse(repository.existsById(provincia.getId()));
    }

    @Test
    public void view() {

        Short colorR = 125;

        Provincia provincia = establecerProvincia((short) 125, (short) 250, (short) 55, 0.9, true, (short) 99);

        Optional<Provincia> registro = repository.findById(provincia.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getColorR().equals(colorR));
    }

    @Test
    public void update() {

        Boolean esIntelOrigial = false;
        Boolean esIntelNuevo = true;
        Provincia provincia = establecerProvincia((short) 125, (short) 250, (short) 55, 0.9, esIntelOrigial, (short) 99);

        assertTrue(repository.existsById(provincia.getId()));

        provincia.setEsIntel(esIntelNuevo);
        repository.save(provincia);

        Optional<Provincia> updatedProvincia = repository.findById(provincia.getId());

        assertTrue(updatedProvincia.isPresent());
        assertTrue(updatedProvincia.get().getEsIntel().equals(esIntelNuevo));
    }

}

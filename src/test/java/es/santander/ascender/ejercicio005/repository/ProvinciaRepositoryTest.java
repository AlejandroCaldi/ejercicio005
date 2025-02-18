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
        
        Provincia ordenador = new Provincia();
        ordenador.setColorR(colorR);
        ordenador.setColorG(colorG);
        ordenador.setColorB(colorB);
        ordenador.setPeso(peso);
        ordenador.setEsIntel(esIntel);
        ordenador.setNumeroTeclas(numeroTeclas);

        repository.save(ordenador);

        return ordenador;
    }
                                        
    @Test
    public void testCreate() {
        Provincia ordenador = establecerProvincia((short) 1, (short) 25, (short) 33, 3.1, false, (short) 101);
        
        assertTrue(
            repository
                .findById(ordenador.getId())
                .isPresent());
    }

    @Test
    public void testCreateFallidoColor() {
        
        Provincia ordenador = new Provincia();
        ordenador.setColorR((short)-1);
        
        assertThrows(TransactionSystemException.class, () -> repository.save(ordenador));
    }

    @Test
    public void testCreateFallidoTeclado() {
        
        Provincia ordenador = new Provincia();
        ordenador.setNumeroTeclas((short)-1);
        
        assertThrows(TransactionSystemException.class, () -> repository.save(ordenador));
    }

    @Test
    public void testCreateFallidoPeso() {
        
        Provincia ordenador = new Provincia();
        ordenador.setPeso(-1.04);
        
        assertThrows(TransactionSystemException.class, () -> repository.save(ordenador));
    }

    @Test
    public void delete() {

        Provincia ordenador = establecerProvincia((short) 125, (short) 250, (short) 33, 2.1, true, (short) 99);

        assertTrue(repository.existsById(ordenador.getId()));

        // Borrar registro y comprobar que fue borrado
        repository.deleteById(ordenador.getId());

        assertFalse(repository.existsById(ordenador.getId()));
    }

    @Test
    public void view() {

        Short colorR = 125;

        Provincia ordenador = establecerProvincia((short) 125, (short) 250, (short) 55, 0.9, true, (short) 99);

        Optional<Provincia> registro = repository.findById(ordenador.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getColorR().equals(colorR));
    }

    @Test
    public void update() {

        Boolean esIntelOrigial = false;
        Boolean esIntelNuevo = true;
        Provincia ordenador = establecerProvincia((short) 125, (short) 250, (short) 55, 0.9, esIntelOrigial, (short) 99);

        assertTrue(repository.existsById(ordenador.getId()));

        ordenador.setEsIntel(esIntelNuevo);
        repository.save(ordenador);

        Optional<Provincia> updatedProvincia = repository.findById(ordenador.getId());

        assertTrue(updatedProvincia.isPresent());
        assertTrue(updatedProvincia.get().getEsIntel().equals(esIntelNuevo));
    }

}

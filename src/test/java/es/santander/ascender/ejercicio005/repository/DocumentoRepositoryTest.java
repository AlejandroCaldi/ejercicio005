package es.santander.ascender.ejercicio005.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import es.santander.ascender.ejercicio005.model.Documento;

@SpringBootTest
public class DocumentoRepositoryTest {

    @Autowired
    private DocumentoRepository repository;

    private Documento getDocumento(String nombre, String extension, Long duenoId, Boolean borrado) {
        Documento documento = new Documento();
        documento.setNombre(nombre);
        documento.setExtension(extension);
        documento.setDuenoId(duenoId);
        documento.setFechaCreacion(LocalDate.now());
        documento.setBorrado(borrado);
        return documento;
    }



    @Test
    public void testCreate() {
        Documento documento = getDocumento("Un enfoque lacrimal sobre la tortilla de papa: ¿Con o sin cebolla?",
                                            "doc",
                                            5l, 
                                            false);

        repository.save(documento);

        assertTrue(
            repository
                .findById(documento.getId())
                .isPresent());
    }


    @Test
    public void delete() {

        Documento documento = getDocumento("todos mis passwords (no mirar)",
                                                "txt",
                                                10l, 
                                                false);
        
        repository.save(documento);

        assertTrue(repository.existsById(documento.getId()));

        repository.deleteById(documento.getId());

        assertFalse(repository.existsById(documento.getId()));
    }

    @Test
    public void view() {

        String nombre = "La sierra de Occam, lo más probable, es que se refiera sobre una sierra que tenía Occam";
        Documento documento = getDocumento(nombre,
                                            "pdf",
                                            11l, 
                                            true);
        repository.save(documento);

        Optional<Documento> registro = repository.findById(documento.getId());

        assertTrue(registro.isPresent());
        assertTrue(registro.get().getNombre().equals(nombre));
    }

    @Test
    public void update() {

        String nombreOriginal = "Gastos que no sé de qué son";
        String apellidoNuevo = "Ni idea";

        Documento documento = getDocumento(nombreOriginal,
                                "xls",
                                10l, 
                                false);

        repository.save(documento);

        assertTrue(repository.existsById(documento.getId()));

        documento.setNombre(apellidoNuevo);
        repository.save(documento);

        Optional<Documento> updatedDocumento = repository.findById(documento.getId());

        assertTrue(updatedDocumento.isPresent());
        assertTrue(updatedDocumento.get().getNombre().equals(apellidoNuevo));


    }

}

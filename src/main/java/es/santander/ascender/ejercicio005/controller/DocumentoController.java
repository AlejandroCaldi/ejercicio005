package es.santander.ascender.ejercicio005.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejercicio005.model.Documento;
import es.santander.ascender.ejercicio005.service.DocumentoService;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping
    public Documento create(@RequestBody Documento documento) {
        return documentoService.create(documento);
    }

    @GetMapping("/{id}")
    public Documento read(@PathVariable("id") Long id) {
        return documentoService.read(id);
    }
    
    @GetMapping
    public List<Documento> list() {
        return documentoService.read();
    }

    @PutMapping
    public Documento update(@RequestBody Documento documento) {
        return documentoService.update(documento);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        documentoService.delete(id);
    }

    @GetMapping("/buscar/nombre")
    public List<Documento> findByNombre(@RequestParam String nombre) {
        return documentoService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/nombre/filtro")
    public List<Documento> buscarPorNombreFiltro(@RequestParam String nombre) {
        return documentoService.buscarPorNombreFiltrado(nombre);
    }

    @GetMapping("/buscar/extension")
    public List<Documento> buscarPorNombre(@RequestParam String extension) {
        return documentoService.buscarPorNombre(extension);
    }

    @GetMapping("/buscar/extension/filtro")
    public List<Documento> buscarPorNombreFiltrado(@RequestParam String extension) {
        return documentoService.buscarPorNombreFiltrado(extension);
    }

    
}

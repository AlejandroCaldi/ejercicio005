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

import es.santander.ascender.ejercicio005.model.Continente;
import es.santander.ascender.ejercicio005.service.ContinenteService;

@RestController
@RequestMapping("/api/continente")
public class ContinenteController {

    @Autowired
    private ContinenteService continenteService;

    @PostMapping
    public Continente create(@RequestBody Continente continente) {
        return continenteService.create(continente);
    }

    @GetMapping("/{id}")
    public Continente read(@PathVariable("id") Long id) {
        return continenteService.read(id);
    }
    
    @GetMapping
    public List<Continente> list() {
        return continenteService.read();
    }

    @PutMapping
    public Continente update(@RequestBody Continente continente) {
        return continenteService.update(continente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        continenteService.delete(id);
    }

    @GetMapping("/buscar/nombre")
    public List<Continente> buscarPorNombre(@RequestParam String nombre) {
        return continenteService.buscarPorNombre(nombre);
    }

}

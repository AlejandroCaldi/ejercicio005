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

import es.santander.ascender.ejercicio005.model.Persona;
import es.santander.ascender.ejercicio005.service.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping
    public Persona create(@RequestBody Persona persona) {
        return personaService.create(persona);
    }

    @GetMapping("/{id}")
    public Persona read(@PathVariable("id") Long id) {
        return personaService.read(id);
    }
    
    @GetMapping
    public List<Persona> list() {
        return personaService.read();
    }

    @PutMapping
    public Persona update(@RequestBody Persona persona) {
        return personaService.update(persona);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        personaService.delete(id);
    }

    @GetMapping("/buscar/nombre")
    public List<Persona> findByNombre(@RequestParam String nombre) {
        return personaService.buscarPorNombre(nombre);
    }

    @GetMapping("/buscar/nombre/filtro")
    public List<Persona> buscarPorPersonaFiltro(@RequestParam String nombre) {
        return personaService.buscarPorApellidoFiltrado(nombre);
    }

    @GetMapping("/buscar/apellido")
    public List<Persona> buscarPorNombre(@RequestParam String apellido) {
        return personaService.buscarPorApellido(apellido);
    }

    @GetMapping("/buscar/apellido/filtro")
    public List<Persona> buscarPorNombreFiltrado(@RequestParam String apellido) {
        return personaService.buscarPorApellidoFiltrado(apellido);
    }

    @GetMapping("/buscar/provincia")
    public List<Persona> buscarPorProvincia(@RequestParam Long provinciaID) {
        return personaService.buscarPorProvincia(provinciaID);
    }
    
}

package es.santander.ascender.ejercicio005.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Continente {
  
    @Id
    @Max(6)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El nombre de la continente no puede ser vacío")
    @NotNull(message = "El nombre de la continente no puede ser nulo")
    @Column(name="nombre", unique = true)
    private String nombre;



    public Continente() {
        
    }


    public Continente(@NotBlank @NotNull String nombre, Long continenteId) {
        this.nombre = nombre;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}

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
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El nombre de la pais no puede ser vacío")
    @NotNull(message = "El nombre de la pais no puede ser nulo")
    @Column(name="nombre", unique = true)
    private String nombre;


    @NotNull(message = "El id de continente no puede ser nulo")
    @Column(name="continenteId")
    @Max(6)
    private Short continenteId;


    public Pais() {
        
    }


    public Pais(@NotBlank @NotNull String nombre, Short continenteId) {
        this.nombre = nombre;
        this.continenteId = continenteId;
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


    public Short getContinenteId() {
        return continenteId;
    }


    public void setContinenteId(Short continenteId) {
        this.continenteId = continenteId;
    };
    
    
}

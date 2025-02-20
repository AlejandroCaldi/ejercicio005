package es.santander.ascender.ejercicio005.model;

import es.santander.ascender.ejercicio005.enums.Paises;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="nombre", unique = true)
    private Paises nombre;


    @NotNull(message = "El id de continente no puede ser nulo")
    @Column(name="continenteId")
    private Long continenteId;


    public Pais() {
        
    }


    public Pais(@NotBlank @NotNull Paises nombre, Long continenteId) {
        this.nombre = nombre;
        this.continenteId = continenteId;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Paises getNombre() {
        return nombre;
    }


    public void setNombre(Paises nombre) {
        this.nombre = nombre;
    }


    public Long getContinenteId() {
        return continenteId;
    }


    public void setContinenteId(Long continenteId) {
        this.continenteId = continenteId;
    };
    
    
}

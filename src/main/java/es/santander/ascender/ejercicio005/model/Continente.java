package es.santander.ascender.ejercicio005.model;

import es.santander.ascender.ejercicio005.enums.Continentes;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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


    @Enumerated(EnumType.STRING)
    @Column(name="nombre", unique = true)
    private Continentes nombre;



    public Continente() {
        
    }


    public Continente(@NotBlank @NotNull Continentes nombre, Long continenteId) {
        this.nombre = nombre;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Continentes getNombre() {
        return nombre;
    }


    public void setNombre(Continentes nombre) {
        this.nombre = nombre;
    }
    
    
}

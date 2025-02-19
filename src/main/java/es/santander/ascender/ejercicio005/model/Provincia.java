package es.santander.ascender.ejercicio005.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "El nombre del provincia no puede ser vacío")
    @NotNull(message = "El nombre del provincia no puede ser nulo")
    @Column(name="nombre", unique = true)
    private String nombre;

    @NotNull(message = "El nombre del paisId no puede ser nulo")
    @Column(name="paisId")
    private Long paisId;



    public Provincia() {
        
    }


    public Provincia(@NotBlank @NotNull String nombre, Long paisId) {
        this.nombre = nombre;
        this.paisId = paisId;
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


    public Long getPaisId() {
        return paisId;
    }


    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    };
    
    
}

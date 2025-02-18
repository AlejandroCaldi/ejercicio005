package es.santander.ascender.ejercicio005.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Column(name="nombre")
    private String nombre; 

    @NotBlank
    @NotNull
    @Column(name="apellido")
    private Boolean apellido;

    @NotNull
    @Column(name="nombre", unique = true, nullable = false) // asumimos que no habrìa dos lapiceras con el mismo nombre. 
    private Long provincia_Id;

    public Persona(){
    }

    public Persona(Long id, @NotBlank @NotNull String nombre, @NotBlank @NotNull Boolean apellido,
            @NotNull Long provincia_Id) {
                
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.provincia_Id = provincia_Id;
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

    public Boolean getApellido() {
        return apellido;
    }

    public void setApellido(Boolean apellido) {
        this.apellido = apellido;
    }

    public Long getProvincia_Id() {
        return provincia_Id;
    }

    public void setProvincia_Id(Long provincia_Id) {
        this.provincia_Id = provincia_Id;
    }

    
    
    
    
}

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

    @NotBlank(message = "El nombre de la persona no puede ser vacío")
    @NotNull(message = "El nombre de la persona no puede ser nulo")
    @Column(name="nombre")
    private String nombre; 

    @NotBlank(message= "El apellido de la persona no puede ser vacío")
    @NotNull(message="El apellido de la persona no puede ser vacío")
    @Column(name="apellido")
    private String apellido;

    @NotNull(message="El id de la provincia no puede ser nulo, a ser referenciado por clave foreánea")
    @Column(name="nombre", unique = true, nullable = false) // asumimos que no habrìa dos lapiceras con el mismo nombre. 
    private Long provincia_Id;

    public Persona(){
    }

    public Persona(Long id, @NotBlank @NotNull String nombre, @NotBlank @NotNull String apellido,
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getProvincia_Id() {
        return provincia_Id;
    }

    public void setProvincia_Id(Long provincia_Id) {
        this.provincia_Id = provincia_Id;
    }

    
    
    
    
}

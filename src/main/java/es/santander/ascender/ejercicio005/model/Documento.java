package es.santander.ascender.ejercicio005.model;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

    @Entity
    public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull()
    @NotBlank()
    @Length(max = 256)
    @Column(name="nombre")
    private String nombre; 

    @NotNull()
    @Length(max = 15)
    @Column(name="extension")
    private String extension; 

    @NotNull()
    @Column(name="duenoId")
    private Long duenoId;

    @Column(name="fecha")
    @NotNull(message="Es preciso informar una fecha")
    private LocalDate fechaCreacion = LocalDate.now();

    @Column(nullable = false, name = "borrado")
    private Boolean borrado = false;

    public Documento() {

    }

    public Documento(Long id, @NotNull @NotBlank @Length(max = 256) String nombre,
            @NotNull @Length(max = 15) String extension, @NotNull Long duenoId, Boolean borrado) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
        this.duenoId = duenoId;
        this.borrado = borrado;
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

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getDuenoId() {
        return duenoId;
    }

    public void setDuenoId(Long duenoId) {
        this.duenoId = duenoId;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }

}

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

    @NotBlank(message = "El nombre de documento no puede ser vacío")
    @NotNull(message = "El nombre del documento no puede ser nulo")
    @Length(max = 256)
    @Length(min = 1)
    @Column(name="nombre")
    private String nombre; 

    @NotBlank(message = "El nombre de la persona no puede ser vacío")
    @NotNull(message = "El nombre de la persona no puede ser nulo")
    @Length(max = 15)
    @Length(min = 0)
    @Column(name="extension")
    private String extension; 

    @NotNull(message="El id de dueño no puede ser vacío")
    @Column(name="duenoId")
    private Long duenoId;

    @Column(name="fecha")
    @NotNull(message="Es preciso informar una fecha")
    private LocalDate fechaCreacion = LocalDate.now();

    @Column(nullable = false, name = "borrado")
    private Boolean borrado = false;

    public Documento() {

    }

    public Documento(Long id,
            @NotBlank(message = "El nombre de documento no puede ser vacío") @NotNull(message = "El nombre del documento no puede ser nulo") @Length(max = 256) @Length(min = 1) String nombre,
            @NotBlank(message = "El nombre de la persona no puede ser vacío") @NotNull(message = "El nombre de la persona no puede ser nulo") @Length(max = 15) @Length(min = 0) String extension,
            @NotBlank(message = "El apellido de la persona no puede ser vacío") @NotNull(message = "El apellido de la persona no puede ser vacío") Long duenoId,
            @NotNull(message = "Es preciso informar una fecha") LocalDate fechaCreacion, Boolean borrado) {
        this.id = id;
        this.nombre = nombre;
        this.extension = extension;
        this.duenoId = duenoId;
        this.fechaCreacion = fechaCreacion;
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

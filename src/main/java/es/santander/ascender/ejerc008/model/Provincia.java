package es.santander.ascender.ejerc008.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Provincia {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;

    private int codigoPostal;

    public Provincia() {
    }

    public Provincia(Long id, String nombre, int codigoPostal) {
        this.id = id;
        this.nombre = nombre;
        this.codigoPostal = codigoPostal;
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

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    
    



}

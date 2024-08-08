package com.proyecto.integral.model.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;
    @Column(name = "cli_nombres")
    private String nombres;
    @Column(name = "cli_apellidos")
    private String apellidos;
    @Column(name = "cli_correo")
    private String correo;

    @Column(name = "cli_fecha_registro")
    //Temporal ayuda a definir el tipo de dato
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    //me ayuda a grabar la fecha del sistema antes incluso de ejecutar la persistencia
    @PrePersist
    public void colocarFecha(){
        if (date == null){
            date = new Date();
        }
    }
    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
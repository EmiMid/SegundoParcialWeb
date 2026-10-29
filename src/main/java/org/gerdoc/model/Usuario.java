package org.gerdoc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USUARIO")
public class Usuario
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String nombre;

    @Column(name = "PASSWORD")
    private String contraseña;

    @Column(name = "PROMEDIO")
    private Double promedio;

    @ManyToOne
    @JoinColumn(name = "ROL_ID")
    private Rol rol;

    @ManyToOne
    @JoinColumn(name = "PROFESOR_ID")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "ALUMNO_ID")
    private Alumno alumno;

    @Column(name = "ACTIVO")
    private Double activo;

}
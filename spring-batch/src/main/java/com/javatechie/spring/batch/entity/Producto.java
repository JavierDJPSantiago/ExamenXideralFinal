package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    @Id
    @Column(name = "producto_id")
    private int producto_id;
    @Column(name = "nombre_de_producto")
    private String nombre_de_producto;
    @Column(name = "tipo_de_producto")
    private String tipo_de_producto;
    @Column(name = "correo_de_vendedor")
    private String correo_de_vendedor;
    @Column(name = "marca")
    private String marca;
    @Column(name = "pais")
    private String pais;
    @Column(name = "fecha_de_recibido")
    private String fecha_de_recibido;
    @Column(name = "fecha_de_salida")
    private String fecha_de_salida;
    
}

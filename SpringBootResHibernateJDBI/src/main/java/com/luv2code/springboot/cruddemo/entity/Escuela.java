package com.luv2code.springboot.cruddemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@AllArgsConstructor
@Data
@Entity
@Table(name="escuela")//nombre de la tabla en base de datos
public class Escuela {

	// definir campos
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="tescuela")
	private String tescuela;
	
	@Column(name="correo")
	private String correo;
	
	//constructor default
	public Escuela() {
	}
	
	//constructor sin id
	public Escuela(String nombre, String tescuela, String correo) {
		super();
		this.nombre = nombre;
		this.tescuela = tescuela;
		this.correo = correo;
	}

	
	
	
	

}












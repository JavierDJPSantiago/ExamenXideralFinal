package com.client.rest.model;

import lombok.*;

//Notación de Lombok para constructor sin argumentos
@NoArgsConstructor
//Notación de Lombok para constructor con todos los argumentos
@AllArgsConstructor
//Notación de Lombok usada para Getter, Setter y ToString
@Data
public class Escuela {

	private int id;
	private String nombre;
	private String tescuela;
	private String correo;	

}

package com.client.rest.service;

import java.util.List;
import com.client.rest.model.Escuela;

public interface EscuelaService {

	public List<Escuela> getEscuelas();

	public void saveEscuela(Escuela theEscuela);

	public Escuela getEscuela(int theId);

	public void deleteEscuela(int theId);
	
}

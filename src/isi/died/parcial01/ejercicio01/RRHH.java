package isi.died.parcial01.ejercicio01;

import java.util.ArrayList;
import java.util.Arrays;

public class RRHH {
	
	public ReciboSueldo[] getListaRecibos(ArrayList<Empleado> lEmpleados){
		return	lEmpleados
				.stream()
				.map(e -> e.getReciboSueldo())
				.toArray());
				
				/*
				 * No encuentro el error aca, me dice que tengo que cerrar con;
				 */
		}
	
}
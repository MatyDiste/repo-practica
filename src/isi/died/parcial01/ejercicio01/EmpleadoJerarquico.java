package isi.died.parcial01.ejercicio01;

import java.util.Calendar;

public class EmpleadoJerarquico extends Empleado{
	//SON JEFES DE PLANTAS Y DEPARTAMENTOS
	public EmpleadoJerarquico(Integer ndni, String name, Calendar fContrato, String email) {
		super(ndni, name, fContrato, email);
	}
	
	public Double getSueldo(Double basico) {
		Double reintegro = super.getListaGastos()
				.stream()
				.mapToDouble(g -> g.precio)
				.sum() * 1.10d;
		
		return basico*((100d+8d-5d)/100d) + reintegro + super.getSueldo(basico);
	}
	
}

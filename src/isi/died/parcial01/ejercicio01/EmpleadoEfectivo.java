package isi.died.parcial01.ejercicio01;

import java.util.Calendar;

public class EmpleadoEfectivo extends Empleado{
	//TIENE RELACION DE DEPENDENCIA CON LA EMPRESA
	
	public EmpleadoEfectivo(Integer ndni, String name, Calendar fContrato, String email) {
		super(ndni, name, fContrato, email);
	}

	@Override
	public Double getSueldo(Double basico) {
		Double reintegro = super.getListaGastos()
				.stream()
				.filter(g -> g.aprobado) //Solo aprobados
				.mapToDouble(g -> g.precio) //Los precios
				.sum(); //Sumatoria
		return basico*((100d-11d-3d)/100d) + reintegro + super.getSueldo(basico);
	}
	
	
}

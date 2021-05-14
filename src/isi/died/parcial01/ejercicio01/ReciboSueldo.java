package isi.died.parcial01.ejercicio01;

public class ReciboSueldo {
	public Integer numero;
	public Integer mes;
	public Double total;
	public Empleado empleado;
	
	public ReciboSueldo(Integer n, Integer numeroMes, Double t, Empleado e) {
		numero=n;
		mes=numeroMes;
		total=t;
		empleado=e;
	}
	
}

package isi.died.parcial01.ejercicio01;
import java.util.*;


public abstract class Empleado {
	public Integer dni;
	public String nombre;
	public Calendar fechaContratacion;
	public String correo;
	private ArrayList<Gasto> listaGastos=new ArrayList<Gasto>();
	
	
	public Empleado(Integer ndni, String name, Calendar fContrato, String email) {
		dni=ndni;
		nombre=name;
		fechaContratacion=fContrato;
		correo=email;
	}
	
	public ArrayList<Gasto> getListaGastos(){
		return listaGastos;
	}
	
	public Double getSueldo(Double basico) {
		if(Calendar.getInstance().get(Calendar.MONTH) == 2) {
			//SI ES MARZO
			return basico*0.5d;
		}
		return 0d;
	}
	
	public ReciboSueldo getReciboSueldo() {
		//TODO
		//DUMMY VALUES
		Integer nrecibo=999;
		Integer nmes=5;
		Double pago=9999999d;
		//DUMMY VALUES
		return new ReciboSueldo(nrecibo, nmes, pago, this);
	}
	
}

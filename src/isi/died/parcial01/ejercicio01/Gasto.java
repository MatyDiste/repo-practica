package isi.died.parcial01.ejercicio01;

public class Gasto {
	public Integer numComprobante;
	public String descripcion;
	public Boolean aprobado;
	public Double precio;
	
	public Gasto(
			Integer nc,
			String desc,
			Boolean ap,
			Double pr) {
		
		numComprobante=nc;
		descripcion=desc;
		aprobado=ap;
		precio=pr;
	}
	
	
}

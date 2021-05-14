package isi.died.parcial01.ejercicio02.dominio;

import java.util.Comparator;

import java.util.ArrayList;
import java.util.List;

import isi.died.parcial01.ejercicio02.dominio.Inscripcion.Estado;

public class Alumno {
	
	private static Integer ID_GENERATOR=0;
	
	private Integer id;
	private String nombre;

	private List<Inscripcion> materiasCursadas;
	private List<Examen> examenes;
	
	public Alumno() {
		this.id = ID_GENERATOR++;
		this.materiasCursadas = new ArrayList<Inscripcion>();
		this.examenes = new ArrayList<Examen>();
	}
	
	
	public Alumno(String nombre) {
		this();
		this.nombre = nombre;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void addExamen(Examen e) {
		this.examenes.add(e);
		e.setAlumno(this);
	}
	
	
	public void addCursada(Inscripcion e) throws Exception{
		if(this.materiasCursadas
				.stream()
				.anyMatch(insc -> 
				insc.getMateria().getNombre().equals(e.getMateria().getNombre()) &&
				insc.getEstado() != Estado.LIBRE)) {
			//Si alguna inscripcion es de la materia que se quiere anotar
			//y esa inscripcion no está en estado LIBRE lanzo excepcion
			throw new Exception("El alumno ya esta inscripto en la materia");
		}
		
		this.materiasCursadas.add(e);
		e.setInscripto(this);
	}
	
	public void promocionarMateria(String nMateria) {
		Inscripcion insc= 
			this.materiasCursadas
			.stream()
			.filter(m -> m.getMateria().getNombre().equals(nMateria)) //solo las inscripciones a esta materia
			.max((a,b) -> a.getCicloLectivo() - b.getCicloLectivo()) //el ciclo lectivo mas grande
			.get();
		insc.setEstado(Estado.PROMOCIONADO);
		
	}

}

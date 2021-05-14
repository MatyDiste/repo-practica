package isi.died.parcial01.ejercicio02.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import isi.died.parcial01.ejercicio02.db.*;
import isi.died.parcial01.ejercicio02.dominio.*;


public class MySysAcadImpl implements MySysAcad {
	private static final BaseDeDatos DB = new BaseDeDatos();


	private List<Materia> materia = new ArrayList<Materia>();
	
	@Override
	public void registrarMateria(Materia d) {
		this.materia.add(d);
	}
	
	private List<Docente> docentes = new ArrayList<Docente>();
	
	@Override
	public void registrarDocente(Docente d) {
		this.docentes.add(d);
	}
	
	private List<Alumno> alumnos = new ArrayList<Alumno>();
	
	@Override
	public void registrarAlumnos(Alumno d) {
		this.alumnos.add(d);
	}
	
	public void registrarNota(Examen e, Integer nota) {
		e.setNota(nota);
		if(nota>=6) {
			e.getAlumno().promocionarMateria(e.getMateria().getNombre());
		}else {
			//NO IMPLEMENTADO
		}
	}
	
	public Double promedioAprobados(Materia m) {
		return m.getExamenes()
				.stream()
				.filter(e -> e.getNota()>6)
				.mapToInt(e -> e.getNota())
				.average()
				.getAsDouble();
	}

	public List<Alumno> inscriptos(Materia m,Integer ciclo){
		//No se como castear de Stream a List<Alumno>
		return Arrays.asList(
				m.getInscripciones()
				.stream()
				.filter(i -> i.getCicloLectivo()==ciclo)
				.map(insc -> insc.getInscripto())
				.sorted((a,b)-> a.getNombre().compareToIgnoreCase(b.getNombre()))
				.toArray());
	}
	
	@Override
	public void inscribirAlumnoCursada(Docente d, Alumno a, Materia m, Integer cicloLectivo) throws Exception{
		Inscripcion insc = new Inscripcion(cicloLectivo,Inscripcion.Estado.CURSANDO);
		d.agregarInscripcion(insc);
		a.addCursada(insc);
		m.addInscripcion(insc); //El método addInscripcion lanza excepcion si el alumno ya esta inscripto
		try {
			DB.guardar(insc);
		} catch(BaseDeDatosExcepcion dbe) {
			throw new Exception("Error en la base de datos");
		}
	}

	@Override
	public void inscribirAlumnoExamen(Docente d, Alumno a, Materia m) {
		Examen e = new Examen();
		a.addExamen(e);
		d.agregarExamen(e);
		m.addExamen(e);
		// DESCOMENTAR Y gestionar excepcion
		// DB.guardar(e);
	}
	

}

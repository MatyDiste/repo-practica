package isi.died.parcial01.ejercicio02.app;

import isi.died.parcial01.ejercicio02.dominio.*;



public interface MySysAcad {
	
	public void registrarMateria(Materia d);
	
	
	public void registrarDocente(Docente d) ;
	
	
	public void registrarAlumnos(Alumno d) throws Exception;
	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 * @throws Exception 
	 */
	public void inscribirAlumnoCursada(Docente d,Alumno a, Materia m,Integer cicloLectivo) throws Exception;

	/**
	 * crea una nueva instancia de Inscripcion y 
	 * asigna la inscripcion a la lista de inscripciones del alumno, 
	 * de la materia y del docente
	 */
	public void inscribirAlumnoExamen(Docente d,Alumno a, Materia m);
	
	public Double promedioAprobados(Materia m);
}

package com.apoyoaula.reports.model;

public class Parametros {
	private String folioDocente;
	private String grado;
	private String grupo;
	private String idEntidad;
	private String entidad;
	private String idNivel;
	private String nivel;
	private String idTurno;
	private String turno;
	private String cct;
	private String folioEscuela;
	private String nombre;

	public Parametros(String folioDocente,String grado,String grupo,String idEntidad,String entidad,String idNivel,String nivel,String idTurno,String turno,String cct,String folioEscuela,String nombre){
		this.folioDocente = folioDocente;
		this.grado = grado;
		this.grupo = grupo;
		this.idEntidad = idEntidad;
		this.entidad = entidad;
		this.idNivel = idNivel;
		this.nivel = nivel;
		this.idTurno = idTurno;
		this.turno = turno;
		this.cct = cct;
		this.folioEscuela = folioEscuela;
		this.nombre = nombre;
	}

	public String getFolioDocente() {
		return folioDocente;
	}

	public void setFolioDocente(String folioDocente) {
		this.folioDocente = folioDocente;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(String idNivel) {
		this.idNivel = idNivel;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getIdTurno() {
		return idTurno;
	}

	public void setIdTurno(String idTurno) {
		this.idTurno = idTurno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getCct() {
		return cct;
	}

	public void setCct(String cct) {
		this.cct = cct;
	}

	public String getFolioEscuela() {
		return folioEscuela;
	}

	public void setFolioEscuela(String folioEscuela) {
		this.folioEscuela = folioEscuela;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

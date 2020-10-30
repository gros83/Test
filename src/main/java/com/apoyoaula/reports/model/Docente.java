package com.apoyoaula.reports.model;

public class Docente {
	private String cs;
	private String folioDoc;
	private String gradoDoc;
	private String grupoDoc;
	private String idEntidad;
	private String entidad;
	private String idNivel;
	private String nivel;
	private String idTurno;
	private String turno;
	private String cct;
	private String folioEsc;
	private String nomEsc;
	private String fhSubida;
	
	public Docente(String cs, String folioDoc, String gradoDoc, String grupoDoc, String idEntidad, String entidad,
			String idNivel, String nivel, String idTurno, String turno, String cct, String folioEsc, String nomEsc,
			String fhSubida) {
		super();
		this.cs = cs;
		this.folioDoc = folioDoc;
		this.gradoDoc = gradoDoc;
		this.grupoDoc = grupoDoc;
		this.idEntidad = idEntidad;
		this.entidad = entidad;
		this.idNivel = idNivel;
		this.nivel = nivel;
		this.idTurno = idTurno;
		this.turno = turno;
		this.cct = cct;
		this.folioEsc = folioEsc;
		this.nomEsc = nomEsc;
		this.fhSubida = fhSubida;
	}

	public String getCs() {
		return cs;
	}

	public void setCs(String cs) {
		this.cs = cs;
	}

	public String getFolioDoc() {
		return folioDoc;
	}

	public void setFolioDoc(String folioDoc) {
		this.folioDoc = folioDoc;
	}

	public String getGradoDoc() {
		return gradoDoc;
	}

	public void setGradoDoc(String gradoDoc) {
		this.gradoDoc = gradoDoc;
	}

	public String getGrupoDoc() {
		return grupoDoc;
	}

	public void setGrupoDoc(String grupoDoc) {
		this.grupoDoc = grupoDoc;
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

	public String getFolioEsc() {
		return folioEsc;
	}

	public void setFolioEsc(String folioEsc) {
		this.folioEsc = folioEsc;
	}

	public String getNomEsc() {
		return nomEsc;
	}

	public void setNomEsc(String nomEsc) {
		this.nomEsc = nomEsc;
	}

	public String getFhSubida() {
		return fhSubida;
	}

	public void setFhSubida(String fhSubida) {
		this.fhSubida = fhSubida;
	}
	
	@Override
	public String toString() {
		return "Docente [cs=" + cs + ", folioDoc=" + folioDoc + ", gradoDoc=" + gradoDoc + ", grupoDoc=" + grupoDoc
				+ ", idEntidad=" + idEntidad + ", entidad=" + entidad + ", idNivel=" + idNivel + ", nivel=" + nivel
				+ ", idTurno=" + idTurno + ", turno=" + turno + ", cct=" + cct + ", folioEsc=" + folioEsc + ", nomEsc="
				+ nomEsc + ", fhSubida=" + fhSubida + "]";
	}
}

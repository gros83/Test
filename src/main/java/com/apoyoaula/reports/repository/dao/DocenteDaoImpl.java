package com.apoyoaula.reports.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apoyoaula.reports.model.Docente;
import com.apoyoaula.reports.repository.ConexionesBaseDatos;

public class DocenteDaoImpl implements DocenteDao{

	@Override
	public Docente read(Integer id) {
		return null;
	}

	@Override
	public Docente readByFolioDocente(String id) {
        Connection conn = null;
        Docente docente = null;

        try {
            conn = ConexionesBaseDatos.POSTGRES.getConnection();
            
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from cat_docentes where folio_doc = ?")) {
            	
                ps.setString(1, id);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de la columnas y mapearlas a la clase Product
                    	docente = new Docente(rs.getString("cs"),
                    			id,
                        		rs.getString("grado_doc"),
                        		rs.getString("grupo_doc"),
                        		rs.getString("id_entidad"),
                        		rs.getString("entidad"),
                        		rs.getString("id_nivel"),
                        		rs.getString("nivel"),
                        		rs.getString("id_turno"),
                        		rs.getString("turno"),
                        		rs.getString("cct"),
                        		rs.getString("folio_esc"),
                        		rs.getString("nom_esc"),
                        		rs.getString("fh_subida"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return docente;
}

	@Override
	public Docente readByFolioEscuela(String id) {
        Connection conn = null;
        Docente docente = null;

        try {
            conn = ConexionesBaseDatos.POSTGRES.getConnection();
            
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from cat_docentes where folio_esc = ?")) {
                ps.setString(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                    	docente = new Docente(rs.getString("cs"),
                    			rs.getString("folio_doc"),
                        		rs.getString("grado_doc"),
                        		rs.getString("grupo_doc"),
                        		rs.getString("id_entidad"),
                        		rs.getString("entidad"),
                        		rs.getString("id_nivel"),
                        		rs.getString("nivel"),
                        		rs.getString("id_turno"),
                        		rs.getString("turno"),
                        		rs.getString("cct"),
                        		id,
                        		rs.getString("nom_esc"),
                        		rs.getString("fh_subida"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return docente;
}

}

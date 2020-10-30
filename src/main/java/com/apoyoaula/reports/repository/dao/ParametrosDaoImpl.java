package com.apoyoaula.reports.repository.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.apoyoaula.reports.model.Parametros;
import com.apoyoaula.reports.repository.ConexionesBaseDatos;

public class ParametrosDaoImpl implements ParametrosDao{

	@Override
	public Parametros read(Integer id) {
		return null;
	}

	@Override
	public Parametros readByFolioDocente(String id) {
        Connection conn = null;
        Parametros parametros = null;

        try {
            conn = ConexionesBaseDatos.POSTGRES.getConnection();
            
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from datos where folio_docente = ?")) {
            	
                ps.setString(1, id);
                
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // obtener cada una de la columnas y mapearlas a la clase Product
                    	parametros = new Parametros(id,
                        		rs.getString("grado"),
                        		rs.getString("grupo"),
                        		rs.getString("id_entidad"),
                        		rs.getString("entidad"),
                        		rs.getString("id_nivel"),
                        		rs.getString("nivel"),
                        		rs.getString("id_turno"),
                        		rs.getString("turno"),
                        		rs.getString("cct"),
                        		rs.getString("folio_escuela"),
                        		rs.getString("nombre"));
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
        return parametros;
}

	@Override
	public Parametros readByFolioEscuela(String id) {
        Connection conn = null;
        Parametros parametros = null;

        try {
            conn = ConexionesBaseDatos.POSTGRES.getConnection();
            
            try (PreparedStatement ps = conn.prepareStatement(
                    "select * from datos where folio_escuela = ?")) {
                ps.setString(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                    	parametros = new Parametros(rs.getString("folio_docente"),
                        		rs.getString("grado"),
                        		rs.getString("grupo"),
                        		rs.getString("id_entidad"),
                        		rs.getString("entidad"),
                        		rs.getString("id_nivel"),
                        		rs.getString("nivel"),
                        		rs.getString("id_turno"),
                        		rs.getString("turno"),
                        		rs.getString("cct"),
                        		id,
                        		rs.getString("nombre"));
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
        return parametros;
}

}

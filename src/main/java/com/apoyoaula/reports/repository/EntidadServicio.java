package com.apoyoaula.reports.repository;

import java.sql.Connection;

public class EntidadServicio {
/*
    public void guardaEntidad(Entidad entidad) {
        Connection conn = null;
        try (conn = ConexionesBaseDatos.POSTGRES.getConnection()) {
            //iniciar una transacción, buena práctica
            conn.setAutoCommit(false);
            //abrir un bloque de manejo de excepciones
            try {
                //creas todos los Daos con la misma conexión para manejar
                //la misma transacción
                EntidadDao entidadDao = new EntidadDao(conn);
                entidadDao.guardaEntidad(entidad);
                //si todo funcionó sin problemas, se realiza el commit
                conn.commit();
            } catch (Exception e) {
                //si hubo algún problema, se realiza un rollback
                conn.rollback();
            }
            //se cierra la transacción
            conn.setAutoCommit(true);
        }
    }
    */
}

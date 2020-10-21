package com.apoyoaula.reports.repository;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public enum ConexionesBaseDatos {
	POSTGRES;
    private final DataSource dataSource;
    

    private ConexionesBaseDatos() {
    	try { 
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
        }
        dataSource = getDataSource("jdbc:postgresql://localhost:5432/sp2020_planea_diagnostica", "postgres", "admin");
    }

    private DataSource getDataSource(String constr, String usuario, String password) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(constr);
        config.setUsername(usuario);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        return ds;
    }

    public Connection getConnection() throws SQLException{
        return dataSource.getConnection();
    }
}

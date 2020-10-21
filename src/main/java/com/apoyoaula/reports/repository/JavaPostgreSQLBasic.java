package com.apoyoaula.reports.repository;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaPostgreSQLBasic {
	 
    public void connectDatabase() {
        try {
            // We register the PostgreSQL driver
            // Registramos el driver de PostgresSQL
            try { 
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
            }
            Connection connection = null;
            // Database connect
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/sp2020_planea_diagnostica",
                    "postgres", "admin");
 
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "TEST OK" : "TEST FAIL");
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error: " + sqle);
        }
    } 
    /**
     * Testing Java PostgreSQL connection with host and port
     * Probando la conexión en Java a PostgreSQL especificando el host y el puerto.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaPostgreSQLBasic javaPostgreSQLBasic = new JavaPostgreSQLBasic();
        javaPostgreSQLBasic.connectDatabase(); 
    }
}

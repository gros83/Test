package com.apoyoaula.reports.service;


import com.apoyoaula.reports.model.Docente;
import com.apoyoaula.reports.repository.dao.DocenteDao;
import com.apoyoaula.reports.repository.dao.DocenteDaoImpl;

public class TestDAO2 {
	public static void main(String[] args) {
		DocenteDao docente = new DocenteDaoImpl();
        
        // obtener el producto con ID = 100
		Docente d = docente.readByFolioDocente("09S1000111");
        System.out.println(d);
        
     	d = docente.readByFolioEscuela("09S10001");
     	System.out.println(d);  
	}
}

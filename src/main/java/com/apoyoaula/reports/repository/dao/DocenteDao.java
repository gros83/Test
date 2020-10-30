package com.apoyoaula.reports.repository.dao;

import com.apoyoaula.reports.model.Docente;

public interface DocenteDao {
    public Docente read(Integer id);
    public Docente readByFolioDocente(String id);
    public Docente readByFolioEscuela(String id);
}

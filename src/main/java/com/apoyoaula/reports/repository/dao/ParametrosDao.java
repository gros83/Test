package com.apoyoaula.reports.repository.dao;

import com.apoyoaula.reports.model.Parametros;

public interface ParametrosDao {
    public Parametros read(Integer id);
    public Parametros readByFolioDocente(String id);
    public Parametros readByFolioEscuela(String id);
}

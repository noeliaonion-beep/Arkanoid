package es.masanz.ut6.arkanoid.service;

import es.masanz.ut6.arkanoid.dao.NivelDao;
import es.masanz.ut6.arkanoid.database.ConnectionManager;
import es.masanz.ut6.arkanoid.model.Nivel;

import static es.masanz.ut6.arkanoid.conf.Const.*;

public class NivelService {

    public static Nivel obtenerNivel(int id) {

        // TODO 02: Buscar y devolver el nivel en caso de existir
        if (NivelDao.obtenerNivel(id)!=null){
            return NivelDao.obtenerNivel(id);
        }
        return null;
    }



}

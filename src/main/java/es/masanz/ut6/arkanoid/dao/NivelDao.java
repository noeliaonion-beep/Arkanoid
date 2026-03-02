package es.masanz.ut6.arkanoid.dao;

import es.masanz.ut6.arkanoid.database.ConnectionManager;
import es.masanz.ut6.arkanoid.model.Ladrillo;
import es.masanz.ut6.arkanoid.model.Nivel;

import java.util.List;

public class NivelDao {

    public static Nivel obtenerNivel(int id){
        String sql="SELECT id, filas, columnas, ladrillos, siguiente_nivel FROM nivel WHERE id = ?";
        Object[] params={id};
        Object[][] resultados = ConnectionManager.ejecutarSelectSQL(sql,params);
        if (resultados!=null){
            Nivel nivel = new Nivel();
            nivel.setFilas((int) resultados[0][0]);
            nivel.setColumnas((int) resultados[0][1]);
            nivel.generarLadrillosDesdeTexto((String) resultados[0][2]);
            nivel.setSiguienteNivel((int) (resultados[0][3]));
            return nivel;
        }
        return null;
    }


}

package es.masanz.ut6.arkanoid.model;

import java.util.ArrayList;
import java.util.List;

import static es.masanz.ut6.arkanoid.conf.Const.TAM_CASILLA;

public class Nivel {

    int id;
    int filas, columnas;
    List<Ladrillo> ladrillos;
    int siguienteNivel;

    public Nivel() {
        this.ladrillos=new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public List<Ladrillo> getLadrillos() {
        return ladrillos;
    }

    public void setLadrillos(List<Ladrillo> ladrillos) {
        this.ladrillos = ladrillos;
    }

    public int getSiguienteNivel() {
        return siguienteNivel;
    }

    public void setSiguienteNivel(int siguienteNivel) {
        this.siguienteNivel = siguienteNivel;
    }

    /**
     *
     * @param ladrillosStr
     *  //'0100000100000000000001000001000000000000010000010000000000000000000000000000000000000000000000000000'),
     */
    public void generarLadrillosDesdeTexto(String ladrillosStr) {
        // TODO 03: En funcion del String recibido, cargar los ladrillos del nivel
        String[] caracteres = ladrillosStr.split("");

        for (int i = 0; i <caracteres.length ; i++) {
            if (Integer.parseInt(caracteres[i])>0){
                Ladrillo ladrillo = new Ladrillo(i%columnas,i/columnas);
                ladrillo.setVidas(Integer.parseInt(caracteres[i]));
                ladrillos.add(ladrillo);
            }

        }
    }

    public String generarTextoDesdeLadrillos(){
        // TODO 04: En funcion de los ladrillos del nivel, generar el String que los represente
        int[][] matriz = new int[filas][columnas];

        for (Ladrillo ladrillo : ladrillos) {
            matriz[(int) (ladrillo.getY()/TAM_CASILLA)][(int) (ladrillo.getX()/TAM_CASILLA)]=ladrillo.getVidas();
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <matriz.length ; i++) {
            for (int j = 0; j < matriz[0].length ; j++) {
                sb.append(matriz[i][j]);
            }
        }


        return sb.toString();
    }
}

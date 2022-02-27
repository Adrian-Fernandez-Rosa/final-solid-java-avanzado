package Ejercicios22_23_24;

import Ejercicios22_23_24.entidades.Coche;
import Ejercicios22_23_24.entidades.CocheCombustible;
import Ejercicios22_23_24.entidades.CocheElectrico;
import Ejercicios22_23_24.entidades.*;
import Ejercicios22_23_24.repositorios.CochesArchivo;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        CocheCombustible coche = new CocheCombustible();
        coche.setMarca("toyota");
        coche.setModelo("2014");
        coche.setVelocidadMaxima(150);
        coche.setMatricula("abc001");

        Coche cocheElec = new CocheElectrico();
        cocheElec.setMarca("tesla");
        cocheElec.setModelo("2016");
        cocheElec.setVelocidadMaxima(145);
        cocheElec.setMatricula("abc002");

        ((CocheElectrico) cocheElec).Avanzar10km();


        CochesArchivo database = new CochesArchivo();
     database.insertar(coche);
    database.insertar(cocheElec);
  //    Coche cocheBuscado = database.buscar("abc001");
        ArrayList<Coche> coches = database.obtener();
    //    System.out.println("vamo"+ cocheBuscado.getMatricula());

        for(Coche cochee: coches){
            System.out.println(cochee.getMarca());
        }

      //  System.out.println( cocheBuscado.getMarca());



    }
}

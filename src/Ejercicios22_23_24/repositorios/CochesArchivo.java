package Ejercicios22_23_24.repositorios;

import Ejercicios22_23_24.entidades.Coche;
import Ejercicios22_23_24.entidades.CocheCombustible;
import Ejercicios22_23_24.entidades.CocheElectrico;
import Ejercicios22_23_24.entidades.CocheHibrido;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CochesArchivo implements Database{

    private String archivo="coches.txt";

    @Override
    public void conectar() {

    }

    @Override
    public ArrayList<Coche> obtener() {
        ArrayList<Coche> coches = new ArrayList();
        try{
            Scanner scanner = new Scanner(new File(archivo));

            while (scanner.hasNext()){
                String cocheActual = scanner.next();
                String []atributos = cocheActual.split(",");

                Coche coche = identificarCoche(atributos[0]);

                coche.setTipo(atributos[0]);
                coche.setMarca(atributos[1]);
                coche.setModelo(atributos[2]);
                coche.setVelocidadMaxima(Integer.parseInt(atributos[3]));
                coche.setMatricula(atributos[4]);
/*
 coche.getTipo() + ","
                + coche.getMarca() + ","
                + coche.getModelo() + ","
                + coche.getVelocidadMaxima()+","
                + coche.getMatricula()+",";
 */
                if (coche instanceof CocheCombustible){

                    ((CocheCombustible) coche).setCombustible(Integer.parseInt(atributos[5]));
                }
                if (coche instanceof CocheElectrico){
                    ((CocheElectrico) coche).setBateria(Integer.parseInt(atributos[5]));
                }
                if (coche instanceof CocheHibrido){
                    ((CocheHibrido) coche).setCombustible(Integer.parseInt(atributos[5]));
                    ((CocheHibrido) coche).setBateria(Integer.parseInt(atributos[6]));
                }

                coches.add(coche);
            }
            scanner.close();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
        return coches;
    }

    public Coche identificarCoche(String tipo){
        if(tipo.contains("Combustible")){
            return new CocheCombustible();
        }
        if(tipo.contains("Hibrido")){
            return new CocheHibrido();
        }
        if(tipo.contains("Electrico")){
            return new CocheElectrico();
        }
        return null;
    }


    @Override
    public Coche buscar(String matricula) {
        ArrayList<Coche> coches = obtener();

        for (Coche coche : coches){
            if(coche.getMatricula().equalsIgnoreCase(matricula)){
                System.out.println("Coche encontrado");
                return coche;
            }
        }
        System.out.println("coche no encontrado");
        return null;
    }

    @Override
    public void insertar(Coche coche) {

        try{
            FileOutputStream fichero = new FileOutputStream(archivo, true);
            PrintStream stream = new PrintStream(fichero);
            stream.println(separarCochePorComas(coche));
            stream.flush();
            stream.close();

        }catch(Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void borrar(String matricula) {
        ArrayList<Coche> coches = obtener();

        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).getMatricula().equalsIgnoreCase(matricula)){
                coches.remove(i);
                System.out.println("Coche borrado de forma exitosa");
                break;
            }
        }
        reescribirFichero(coches);
    }

    public void reescribirFichero(ArrayList<Coche> coches){

        try{
            PrintStream fichero = new PrintStream(archivo);

            for (Coche coche : coches){

                String cochetxt = separarCochePorComas(coche);
                fichero.println(cochetxt);
            }
            fichero.close();

        }catch(Exception e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }

    private String separarCochePorComas(Coche coche){
        String cochetxt = "";
        cochetxt = coche.getTipo() + ","
                + coche.getMarca() + ","
                + coche.getModelo() + ","
                + coche.getVelocidadMaxima()+","
                + coche.getMatricula()+",";

        if (coche instanceof CocheCombustible || coche instanceof CocheHibrido){
          cochetxt +=   (((CocheCombustible) coche).getCombustible())+",";
        }
        if (coche instanceof CocheElectrico || coche instanceof CocheHibrido){
            cochetxt += ((CocheElectrico) coche).getBateria()+",";
        }

        return cochetxt;
    }

}

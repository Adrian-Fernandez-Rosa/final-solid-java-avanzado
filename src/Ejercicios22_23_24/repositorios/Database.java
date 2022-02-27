package Ejercicios22_23_24.repositorios;

import Ejercicios22_23_24.entidades.Coche;

import java.util.ArrayList;

public interface Database {
    void conectar();
    ArrayList<Coche> obtener();
    Coche buscar(String matricula);
    void insertar(Coche coche);
    void borrar(String matricula);

}

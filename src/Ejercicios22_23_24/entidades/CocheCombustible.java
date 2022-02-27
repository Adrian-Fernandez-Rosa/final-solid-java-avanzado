package Ejercicios22_23_24.entidades;

public class CocheCombustible extends Coche{
    private Integer combustible;

    public CocheCombustible( String marca, String modelo, Integer velocidadMaxima, String matricula) {
        super("Combustible", marca, modelo, velocidadMaxima, matricula);
        this.combustible = 100;
    }






    public CocheCombustible() {
        this.combustible = 100;
        this.setTipo("Combustible");
    }

    public Integer getCombustible() {
        return combustible;
    }

    public void setCombustible(Integer combustible) {
        this.combustible = combustible;
    }

    @Override
    void Avanzar10km() {

        for (int i = 0; i < 10; i++) {
            if (this.combustible == 0 ){
                System.out.println("te has quedado sin combustible");
                System.out.println("solo recorriste "+(i+1)+" km");
                return ;
            }
            combustible--;
        }
    }

    @Override
    void cargarCombustible() {
        this.combustible =100;
        System.out.println("se ha cargado combustible del coche regular");
    }
}

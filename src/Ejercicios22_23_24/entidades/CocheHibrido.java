package Ejercicios22_23_24.entidades;

public class CocheHibrido extends Coche implements EnergiaRenovable{
    private Integer bateria;
    private Integer combustible;

    public CocheHibrido( String marca, String modelo, Integer velocidadMaxima, String matricula, Integer bateria, Integer combustible) {
        super("Hibrido", marca, modelo, velocidadMaxima, matricula);
        this.bateria = bateria;
        this.combustible = combustible;
    }

    public CocheHibrido(){
        this.setTipo("Hibrido");
        bateria = 100;
        combustible = 100;
    }

    public CocheHibrido(Integer bateria, Integer combustible) {
        this.bateria = bateria;
        this.combustible = combustible;
    }



    @Override
    void Avanzar10km() {

        for (int i = 0; i < 10; i++) {
            if (bateria==0){
                System.out.println("te has quedado sin bateria, se pasara a consumir el combustible");
                if(combustible==0){
                    System.out.println("te has quedado sin combustible");
                    System.out.println("has avanzado "+(i+1)+ " km");
                }
            }
        }
    }

    @Override
    void cargarCombustible() {
        this.combustible=100;
    }

    @Override
    public void CargarBateria() {
        this.bateria=100;
    }

    public Integer getBateria() {
        return bateria;
    }

    public void setBateria(Integer bateria) {
        this.bateria = bateria;
    }

    public Integer getCombustible() {
        return combustible;
    }

    public void setCombustible(Integer combustible) {
        this.combustible = combustible;
    }
}

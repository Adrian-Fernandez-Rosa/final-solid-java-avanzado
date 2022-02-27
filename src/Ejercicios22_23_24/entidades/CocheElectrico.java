package Ejercicios22_23_24.entidades;

public class CocheElectrico extends Coche implements EnergiaRenovable{
  private Integer bateria;


    public CocheElectrico() {
        this.setTipo("Electrico");
        bateria=100;
    }

    @Override
    public void Avanzar10km() {
        for (int i = 0; i < 10; i++) {
            if (bateria == 0){
                System.out.println("te has quedado sin batería solo avanzaste "+(i+1)+" km");
                return ;
            }
            bateria--;
        }
    }

    //principio de sustitución de Liskov
    @Override
    void cargarCombustible() {
        System.out.println("Este coche no es de combustible");
    }

    @Override
    public void CargarBateria() {
        this.bateria = 100;
    }

    public Integer getBateria() {
        return bateria;
    }

    public void setBateria(Integer bateria) {
        this.bateria = bateria;
    }

    @Override
    public String toString() {
        return "CocheElectrico{" +
                super.toString()+"\n"+
                "bateria=" + bateria +
                '}';
    }
}

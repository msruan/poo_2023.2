package carros;

public class CarroEletrico extends Carro {
    private double autonomia;
    CarroEletrico(String placa, double ano, String modelo, double autonomia){
        super(placa, ano, modelo);
        this.autonomia = autonomia;
    }
}

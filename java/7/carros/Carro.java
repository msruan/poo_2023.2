package carros;

public class Carro extends Veiculo {
    String modelo;
    Carro(String placa, double ano, String modelo){
        super(placa, ano);
        this.modelo = modelo;
    }
}

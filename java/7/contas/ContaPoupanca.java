package contas;

public class ContaPoupanca extends Conta {
    private double taxa;
    ContaPoupanca(String numero, String nome, double saldo, double taxa){
        super(numero, nome, saldo);
        this.taxa = taxa;
    }
    public void renderJuros(){
        depositar(getSaldo() * (taxa/100));
    }
}

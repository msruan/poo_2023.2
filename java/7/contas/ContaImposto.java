package contas;

public class ContaImposto extends Conta {
    private double taxa;
    ContaImposto(String numero, String nome, double saldo, double taxa){
        super(numero, nome, saldo);
        this.taxa = taxa;
    }
    public boolean sacar(double quantidade){
        return super.sacar(quantidade + quantidade*(taxa/100));
    }
    public boolean depositar(double quantidade){
        return super.depositar(quantidade - quantidade*(taxa/100));
    }
}

package contas_a;

public class ContaImposto extends Conta {

    private double taxa;

    ContaImposto(String numero, String nome, double saldo, double taxa){
        super(numero, nome, saldo);
        this.taxa = taxa;
    }

    public double getTaxa(){
        return taxa;
    }

    public void sacar(double quantidade) throws Exception {
        super.sacar(quantidade + quantidade*(taxa/100));
    }
}

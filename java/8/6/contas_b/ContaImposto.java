package contas_b;

public class ContaImposto extends Conta {

    private double taxa;

    ContaImposto(String numero, String nome, double saldo, double taxa) throws Exception{
        super(numero, nome, saldo);
        if(taxa < 0)
            throw new Exception("Taxa de imposto não pode ser negativa!");
        this.taxa = taxa;
    }

    public double getTaxa(){
        return taxa;
    }

    public void sacar(double quantidade) throws Exception {
        super.sacar(quantidade + quantidade*(taxa/100));
    }
}

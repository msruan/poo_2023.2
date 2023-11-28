package contas_c;

public class ContaPoupanca extends Conta {

    private double taxa;

    ContaPoupanca(String numero, String nome, double saldo, double taxa) throws Exception{
        super(numero, nome, saldo);
        if(taxa < 0)
            throw new Exception("Taxa de juros não pode ser negativa!");
        this.taxa = taxa;
    }
    
    public double getTaxa(){
        return taxa;
    }

    public void renderJuros() throws Exception{
        depositar(getSaldo() * (taxa));
    }
}

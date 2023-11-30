package contas_c;

public class ContaPoupanca extends Conta {

    private double taxa;

    ContaPoupanca(String numero, String nome, double saldo, double taxa) throws ValorInvalidoException{
        super(numero, nome, saldo);
        validarValor(taxa);
        this.taxa = taxa;
    }
    
    public double getTaxa(){
        return taxa;
    }

    public void renderJuros() throws ValorInvalidoException{
        depositar(getSaldo() * (taxa));
    }
}

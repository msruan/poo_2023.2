package contas_c;

public class ContaImposto extends Conta {

    private double taxa;

    ContaImposto(String numero, String nome, double saldo, double taxa) throws ValorInvalidoException{
        super(numero, nome, saldo);
        validarValor(taxa);
        this.taxa = taxa;
    }

    public double getTaxa(){
        return taxa;
    }

    public void sacar(double quantidade) throws ValorInvalidoException, SaldoInsuficienteException {
        super.sacar(quantidade + quantidade*(taxa/100));
    }
}
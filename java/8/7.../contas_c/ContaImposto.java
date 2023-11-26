package contas_c;

public class ContaImposto extends Conta {
    private double taxa;
    ContaImposto(String numero, String nome, double saldo, double taxa) throws Exception{
        super(numero, nome, saldo);
        this.taxa = taxa;
    }
    public String salvar(){

        return "1;"+getNumero()+";"+getNome()+";"+getSaldo()+";"+getTaxa()+";\n";
    }
    public double getTaxa(){
        return taxa;
    }

    public void sacar(double quantidade) throws Exception {
        super.sacar(quantidade + quantidade*(taxa/100));
    }
    public boolean depositar(double quantidade) throws Exception{
        return super.depositar(quantidade - quantidade*(taxa/100));
    }
}

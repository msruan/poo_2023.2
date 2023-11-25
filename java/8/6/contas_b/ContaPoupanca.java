package contas_b;

public class ContaPoupanca extends Conta {
    private double taxa;
    ContaPoupanca(String numero, String nome, double saldo, double taxa) throws Exception{
        super(numero, nome, saldo);
        this.taxa = taxa;
    }
    public String salvar(){

        return "1;"+getNumero()+";"+getNome()+";"+getSaldo()+";"+getTaxa()+";\n";
    }
    public double getTaxa(){
        return taxa;
    }
    public void renderJuros() throws Exception{
        depositar(getSaldo() * (taxa/100));
    }
}

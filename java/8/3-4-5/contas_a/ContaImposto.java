package contas_a;

public class ContaImposto extends Conta {
    private double taxa;
    ContaImposto(String numero, String nome, double saldo, double taxa){
        super(numero, nome, saldo);
        this.taxa = taxa;
    }
    public String salvar(){

        return "1;"+consultarNumero()+";"+consultarNome()+";"+getSaldo()+";"+getTaxa()+";\n";
    }
    public double getTaxa(){
        return taxa;
    }

    public boolean sacar(double quantidade) throws Exception {
        return super.sacar(quantidade + quantidade*(taxa/100));
    }
    public boolean depositar(double quantidade){
        return super.depositar(quantidade - quantidade*(taxa/100));
    }
}

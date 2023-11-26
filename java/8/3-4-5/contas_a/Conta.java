package contas_a;

public class Conta {
    @Override
    public String toString(){
        return String.format("Conta %s\nCliente: %s\nSaldo atual: %f",this.consultarNumero(),this.consultarNome(),this.getSaldo());
    }
    private final String numero;
    private final String nome;
    private double saldo;

    public String salvar(){

        return "0;"+consultarNumero()+";"+consultarNome()+";"+getSaldo()+";\n";
    }

    public Conta(String numero, String nome, double saldo){
        this(numero,nome);
        this.saldo = saldo;
    }
    public Conta(String numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }

    public String consultarNumero() {
        return numero;
    }public String consultarNome() {
        return nome;
    }
    void sacar(double valor) throws Exception {
        if(saldo < valor)
            throw new Exception("Saldo insuficiente!");
        this.saldo -= valor;
    }

    boolean depositar(double valor){
        if (valor > 0) {
            this.saldo += valor;
            return true;
        }return false;
    }

    public double getSaldo(){
        return this.saldo;
    }

    boolean transferir(Conta contaDestino, double valor) throws Exception{
        sacar(valor);
        return contaDestino.depositar(valor);
    }   
}
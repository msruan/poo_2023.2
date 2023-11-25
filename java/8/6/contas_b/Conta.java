package contas_b;

public class Conta {
    @Override
    public String toString(){
        return String.format("Conta %s\nCliente: %s\nSaldo atual: %f",this.getNumero(),this.getNome(),this.getSaldo());
    }
    private final String numero;
    private final String nome;
    private double saldo;

    public String salvar(){

        return "0;"+getNumero()+";"+getNome()+";"+getSaldo()+";\n";
    }

    public Conta(String numero, String nome, double saldo) throws Exception{
        this(numero,nome);
        if(saldo <= 0)
            throw new Exception("Valor inválido!");
        this.saldo = saldo;
    }
    public Conta(String numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }

    public String getNumero() {
        return numero;

    }public String getNome() {
        return nome;
    }

    boolean sacar(double valor) throws Exception {

        if(saldo <= 0)
            throw new Exception("Valor inválido!");

        else if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;

        }else 
            throw new Exception("Saldo insuficiente!");
    }

    boolean depositar(double valor) throws Exception{
        
        if(saldo <= 0)
            throw new Exception("Valor inválido!");
     
        this.saldo += valor;
        return true; 
    }

    public double getSaldo(){
        return this.saldo;
    }

    boolean transferir(Conta contaDestino, double valor) throws Exception{
        if (this.sacar(valor)) {
            return contaDestino.depositar(valor);
        }return false;
    }   
}
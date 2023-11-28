package contas_c;

public class Conta {

    private final String numero;
    private final String nome;
    private double saldo;

    public Conta(String numero, String nome, double saldo){
        this(numero,nome);
        if(saldo < 0)
            throw new Error("Saldo inicial não pode ser negativo!");
        this.saldo = saldo;
    }

    public Conta(String numero, String nome){
        this.numero = numero;
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }
    
    public String getNome() {
        return nome;
    }

    @Override
    public String toString(){
        return String.format("Conta %s\nCliente: %s\nSaldo atual: %f",this.getNumero(),this.getNome(),this.getSaldo());
    }

    void sacar(double valor) throws Exception {
        if(saldo < valor)
            throw new Exception("Saldo insuficiente!");
        else if(valor < 0)
            throw new Exception("Valor negativo passado para saque!");
        this.saldo -= valor;
    }

    void depositar(double valor) throws Exception{
        if(valor < 0)
            throw new Exception("Valor negativo passado para depósito!");
        this.saldo += valor;
    }

    public double getSaldo(){
        return this.saldo;
    }

    void transferir(Conta contaDestino, double valor) throws Exception{
        sacar(valor);
        contaDestino.depositar(valor);
    }   
}
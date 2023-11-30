package contas_c;

public class Conta {

    private final String numero;
    private final String nome;
    private double saldo;

    public Conta(String numero, String nome, double saldo) throws ValorInvalidoException{
        this(numero,nome);
        this.saldo = 0;
        depositar(saldo);
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

    void sacar(double valor) throws SaldoInsuficienteException, ValorInvalidoException {
        validarValor(valor);
        if(saldo < valor)
            throw new SaldoInsuficienteException();
        this.saldo -= valor;
    }

    void depositar(double valor) throws ValorInvalidoException{
        validarValor(valor);
        this.saldo += valor;
    }

    public double getSaldo(){
        return this.saldo;
    }

    void transferir(Conta contaDestino, double valor) throws Exception{
        sacar(valor);
        contaDestino.depositar(valor);
    }   

    void validarValor(double valor) throws ValorInvalidoException {
        if(valor <= 0)
            throw new ValorInvalidoException();
    }
}
package contas;

public class Teste {
    public static void main(String[] args) throws Exception {

        Conta conta = new Conta("123", "João",100);
        Conta conta2 = new Conta("456", "Flavia",200);
        Banco banco = new Banco("Banco");
        banco.cadastrarConta(conta);
        banco.cadastrarConta(conta2);
        banco.sacar("123", 101);
        banco.sacar("456", 300);
    }
}


package contas_b;

/*6) Lance um erro no construtor e nos métodos sacar e depositar para que, caso o
valor passado seja menor que zero uma exceção seja lançada. Reexecute os
testes da questão anterior com valores que “passem” pelo saldo insuficiente, e
teste também a chamada dos métodos passando como parâmetro valores < 0.*/
public class Questao6 {
    public static void main(String[] args) throws Exception {
        // Teste.main(args);
        //Teste2.main(args);
        // Teste3.main(args);
    }
}

class Teste {
    public static void main(String[] args) throws Exception {

        Conta conta = new Conta("123", "João",100);
        Banco banco = new Banco("Banco");
        banco.inserir(conta);
        banco.sacar("123", 40);
        System.out.println(conta);
        
        Conta conta2 = new Conta("456", "Flavia",-200);
        banco.inserir(conta2);
        banco.sacar("456", 300);
        System.out.println(conta2);
    }
}


class Teste2 {

    public static void main(String[] args)throws Exception {

        ContaImposto conta = new ContaImposto("123", "João",100,0.6);
        ContaPoupanca conta2 = new ContaPoupanca("456", "Flavia",0,0.48);
       
        conta.transferir(conta2, -1);
    }

}

class Teste3 {

    public static void main(String[] args) throws Exception{
        Banco banco = new Banco("Banco");

        ContaPoupanca conta = new ContaPoupanca("718", "Caio",5100,0.12);
        Conta conta2 = new Conta("532", "Katia",67);
        banco.inserir(conta);
        banco.inserir(conta2);
        banco.transferir("718","532",600);   
        banco.transferir("532","718",-4);   
    }
    /*
     * Sim, sempre que uma exceção não é tratada em uma camada mais baixa da aplicação (como em Conta),
     * ela é propagada até as camadas superiores (como em Banco). Apesar de agora termos certeza de
     * quando ocorre o erro de "Saldo insuficiente" sem grandes modificações no código, ainda não
     * possuímos mecanismos para lidar com esse erro, o que ocasiona na interrupção abrupta do programa.
     * Isso não parece muito confiável, já que num cenário ideal, a aplicação "nunca" deveria ser interrompida,
     * já que deveríamos torná-la tolerante à erros.
     */
    
    
}


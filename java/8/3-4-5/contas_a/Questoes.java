package contas_a;

public class Questoes {
    public static void main(String[] args) throws Exception {
        Questao3.main(args);
        Questao4.main(args);
        Questao5.main(args);
    }
}


/*3) Implemente como nos slides o lançamento da exceção no método sacar e realize
um teste para saques que deixariam o saldo negativo.*/
class Questao3 {
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


/*4) Crie duas contas e teste o método transferir de modo que a conta a ser debitada
não possua saldo suficiente. Explique o que ocorreu. */
class Questao4 {

    public static void main(String[] args)throws Exception {

        ContaImposto conta = new ContaImposto("123", "João",100,0.6);
        ContaPoupanca conta2 = new ContaPoupanca("456", "Flavia",0,0.48);
       
        conta.transferir(conta2, 200);
    }

    /*  
    * Como no método transferir o método 'sacar' está sendo chamado pela conta debitante, o resultado é que ao
    * passarmos um valor superior ao saldo, é lançada uma exceção dentro do método sacar e esta não é tratada, o que
    * por consequência faz com que a exceção alcance o trecho de código onde o método transferir foi chamado, e como 
    * nesse caso, novamente não a tratamos, a a execução do programa é abortada.
    */
}


/*5) Instancie uma classe banco e crie duas contas. Adicione-as à instancia do banco.
Chame o método transferir novamente passando um valor que lance a exceção na
classe conta. Você considera que o lançamento da exceção foi “propagado” para o
método conta.transferir(), banco.transferir() e o método transferir do script app?
Como você avalia a confiabilidade dessa implementação. */
class Questao5 {

    public static void main(String[] args) throws Exception{
        Banco banco = new Banco("Banco");

        ContaPoupanca conta = new ContaPoupanca("718", "Caio",555,0.12);
        Conta conta2 = new Conta("532", "Katia",67);
        banco.cadastrarConta(conta);
        banco.cadastrarConta(conta2);
        banco.transferir("718","532",600);   
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


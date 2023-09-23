import contas.Conta;
import contas.Banco;
import my_utils.MenuUtils;

import java.util.Scanner;

import static my_utils.MenuUtils.*;

public class App {
    public static final int SAIDA = 0;
    public static final int CADASTRO = 1;
    public static final int CONSULTA = 2;
    public static final int SAQUE = 3;
    public static final int DEPOSITO = 4;

    public static final int TRANSFERENCIA = 5;
    public static final int EXCLUSAO = 6;
    public static final int TOTAL = 7;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do seu banco: ");
        String nome_banco = input.nextLine().trim();
        limparConsole();
        Banco banco = new Banco(nome_banco);
        String menu_principal = gerarMenu(nome_banco,"Cadastrar, Consultar, Sacar, Depositar, Transferir, Excluir, Totalizações");
        boolean ha_contas = false;
        int opcao;
        do{
            if(!ha_contas) {
                opcao = MenuUtils.obterOpcao(gerarMenu(nome_banco, "Cadastrar"));
                if (opcao != 0 && opcao != 1)
                    continue;
            }
            else{
                opcao = MenuUtils.obterOpcao(menu_principal);
                if (opcao < 0 || opcao > 7)
                    continue;
            }
            switch (opcao) {
                case CADASTRO:
                    String nome;
                    double saldo;
                    String numero_cadastro = lerString("\nDigite o número da conta desejada: ", input);
                    while (!(banco.consultarPorNumero(numero_cadastro) == null)) {
                        numero_cadastro = lerString("Este número já está cadastrado!\nPor favor, digite outro: ", input);
                    }
                    nome = lerString("Digite seu nome: ", input);
                    saldo = lerDoublePositivo("\nDigite seu saldo atual: ", input);
                    banco.cadastrarConta(new Conta(numero_cadastro, nome, saldo));
                    ha_contas = true;
                    break;
                case CONSULTA:
                    Conta procurada;
                    do {
                        procurada = banco.consultarPorNumero(lerString("Digite o numero da conta desejada: ", input));
                        if (procurada == null)
                            System.out.println("Conta não encontrada!");
                        else
                            System.out.println(procurada);
                        System.out.println();
                    }while (lerSimOuNao("Deseja realizar uma nova consulta?", input));
                    break;

                case SAQUE:
                    String numero_sacada;
                    double valor_saque;
                    do {
                        numero_sacada = lerString("\nDigite o número da sua conta: ",input);
                        if(banco.estaCadastrada(numero_sacada)){
                            valor_saque = lerDoublePositivo("\nDigite o valor do saque: ",input);
                            if(banco.sacar(numero_sacada,valor_saque)){
                                System.out.println("Saque de R$ "+valor_saque+" realizado com sucesso!");
                                break;
                            }
                            else
                                System.out.println("Saldo insuficiente! ");
                        }else
                            System.out.println("Conta não encontrada!");
                        System.out.println();
                    }while(lerSimOuNao("Repetir operação? ",input));//Limpar tela quando quiser repteir operação...
                    break;

                case DEPOSITO:
                    String numero_depositada;
                    do {
                        numero_depositada = lerString("\nDigite o número da sua conta: ",input);
                        if(banco.estaCadastrada(numero_depositada)){
                            double valor_deposito = lerDoublePositivo("\nDigite o valor do saque: ",input);
                            if(banco.depositar(numero_depositada,valor_deposito)){
                                System.out.println("Depósito de R$ "+valor_deposito+" realizado com sucesso!");
                                break;
                            }
                            else
                                System.out.println("Depósito falhou!");
                        }else
                            System.out.println("Conta não encontrada!");
                        System.out.println();
                    }while(lerSimOuNao("Repetir operação? ",input));
                    break;
                case TRANSFERENCIA:
                    String numero_fonte, numero_destino;
                    double valor_transferencia;
                    do {
                        numero_fonte = lerString("Digite o número da conta fonte: ", input);
                        numero_destino = lerString("Digite o número da conta destino: ", input);
                        valor_transferencia = lerDoublePositivo("Digite o valor a ser transferido: ", input);

                        if (!banco.transferir(numero_fonte, numero_destino, valor_transferencia)) {
                            System.out.println("Operação falhou!");
                        } else {
                            System.out.printf("Transferência de R$ %f para %s realizada com sucesso!", valor_transferencia, banco.consultarPorNumero(numero_destino).consultarNome());
                            break;
                        }
                    }while(lerSimOuNao("Repetir operação? ",input));
                    break;
                case EXCLUSAO:
                    Conta alvo;
                    do{
                        alvo = banco.consultarPorNumero(lerString("Digite o numero da conta desejada: ",input));
                        if(alvo == null){
                            System.out.println("Conta não encontrada!");
                        }else{
                            banco.excluirContaPorNumero(alvo.consultarNumero());
                            System.out.println("Exclusão concluída com sucesso!");
                            break;
                        }
                    }while(lerSimOuNao("Deseja tentar novamente?",input));
                    break;
                case TOTAL:
                    System.out.println(banco);
                    break;
            }
            limparConsole();
        }while(opcao != SAIDA);

    }
}

/* import prompt from "prompt-sync";
import { Conta, Banco } from "./banco";

let input = prompt();
let b: Banco = new Banco();
let opcao: String = '';
do {
console.log('\nBem vindo\nDigite uma opção:');
console.log('1 - Cadastrar 2 - Consultar 3 - Sacar\n' +
'4 - Depositar 5 - Excluir 6 - Transferir\n' +
'7 – Totalizações' +
'0 - Sair\n');
opcao = input("Opção:");
switch (opcao) {
case "1":
inserir();
break
case "2":
consultar();
break
//...
}
input("Operação finalizada. Digite <enter>");
} while (opcao != "0");
console.log("Aplicação encerrada");

function inserir(): void {
console.log("\nCadastrar conta\n");
let numero: string = input('Digite o número da conta:');
let conta: Conta;
conta = new Conta(numero, 0);
b.inserir(conta);
}
//...*/
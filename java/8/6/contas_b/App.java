package contas_b;

import java.util.Scanner;
import javax.swing.JOptionPane;
import static contas_b.utils.MenuUtils.*;

public class App {
    
    public static final int SAIDA = 0;
    public static final int CADASTRO = 1;
    public static final int CONSULTA = 2;
    public static final int SAQUE = 3;
    public static final int DEPOSITO = 4;

    public static final int TRANSFERENCIA = 5;
    public static final int RENDER_JUROS = 6;
    public static final int EXCLUSAO = 7;
    public static final int TOTAL = 8;

    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        System.out.print("Digite o nome do seu banco: ");
        String nome_banco = input.nextLine().trim();
        limparConsole();
        Banco banco = new Banco(nome_banco);
        banco.carregarDeArquivo();
     
        String menu_principal = gerarMenu(nome_banco,"Cadastrar, Consultar saldo, Sacar, Depositar, Transferir, Render Juros, Excluir, Totalizações");
        int opcao;
        
        do{

            if(banco.getTotalContas() == 0) {
                System.out.print(gerarMenu(nome_banco, "Cadastrar"));
                opcao = input.nextInt();
                if (opcao != 0 && opcao != 1)
                    continue;
            }

            else{
                System.out.print(menu_principal);
                opcao = input.nextInt();
                if (opcao < 1 || opcao > 8)
                    continue;
            }

            if(opcao == CADASTRO){
            
                String nome;
                double saldo;
                
                String[] opcoes = { "Normal", "Poupança", "Imposto" };
                int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                String numero_cadastro = JOptionPane.showInputDialog(null,"\nDigite o número da conta desejada: ","Cadastro", JOptionPane.QUESTION_MESSAGE);
      
                nome = JOptionPane.showInputDialog(null,"Digite seu nome: ", "Cadastro", JOptionPane.QUESTION_MESSAGE);
                
                saldo = lerDouble("Digite seu saldo atual: ", input);

                if(escolha == 0)
                    banco.inserir(new Conta(numero_cadastro, nome, saldo));

                else{
                    double taxa = lerDouble("Digite o valor da taxa: ", input);

                    if(escolha == 1)
                        banco.inserir(new ContaPoupanca(numero_cadastro, nome, saldo, taxa));
                    else
                        banco.inserir(new ContaImposto(numero_cadastro, nome, saldo, taxa));
                }

            }

            else if(opcao == CONSULTA){

                Conta procurada;
                procurada = banco.consultarConta(lerString("Digite o numero da conta desejada: ", input));
                if (procurada == null)
                    JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);
                else
                    System.out.println(procurada);
                pause(input,"<Enter>");
            }

            else if(opcao == SAQUE || opcao == DEPOSITO){

                String numero;
                double valor;
                do {
                    numero = lerString("\nDigite o número da sua conta: ",input);
                    Conta conta = banco.consultarConta(numero);

                    if(conta != null){

                        valor = lerDouble("Digite o valor: ", input);
                        if(opcao == SAQUE)
                            conta.sacar(valor);
                        else
                            conta.depositar(valor);

                        JOptionPane.showMessageDialog(null, String.format("%s de R$ "+valor+" realizado com sucesso!",opcao == SAQUE ? "Saque" : "Depósito"));
                        break;

                    }else
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);

                    System.out.println();
                }while(lerSimOuNao("Repetir operação? ",input));//Limpar tela quando quiser repteir operação...

            }

            else if(opcao == TRANSFERENCIA){
                    
                String numero_fonte, numero_destino;
                numero_fonte = JOptionPane.showInputDialog(null,"Digite o número da conta fonte: ");
                numero_destino = lerString("Digite o número da conta destino: ", input);
                double valor_transferencia = lerDouble("Digite o valor a ser transferido: ", input);
                banco.transferir(numero_fonte, numero_destino, valor_transferencia);
            }

            else if(opcao == RENDER_JUROS){

                System.out.print("Digite o número da sua conta poupança:\n>>> ");
                String numero = input.nextLine();
                banco.renderJuros(numero);
            }

            else if(opcao == EXCLUSAO){
                    
                banco.excluir(JOptionPane.showInputDialog(null,"Digite o numero da conta desejada: ",input));
                JOptionPane.showMessageDialog(null, "Exclusão finalizada!");
            }

            else if(opcao == TOTAL){
                System.out.println(banco);
                pause(input,"<Enter>");
            }

            limparConsole();
        }while(opcao != SAIDA);

        banco.salvarEmArquivo();
        
        input.close();
    }
}
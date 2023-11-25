package contas_b;
import javax.swing.JOptionPane;


import static contas_b.utils.ManipuladorArquivos.*;
import static contas_b.utils.MenuUtils.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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


        if(arquivoExiste(getCaminhoDoBancoDeDados(nome_banco))){

            ArrayList<String> conteudo = lerLinhas(getCaminhoDoBancoDeDados(nome_banco));

            for(String linha : conteudo){
                
                String []atributos = linha.split(";");
                if(atributos[0].equals("0"))
                    banco.cadastrarConta(new Conta(atributos[1], atributos[2], Double.parseDouble(atributos[3])));
                else if(atributos[0].equals("1"))
                    banco.cadastrarConta(new ContaPoupanca(atributos[1], atributos[2], Double.parseDouble(atributos[3]),Double.parseDouble(atributos[4])));
                else if(atributos[0].equals("2"))
                    banco.cadastrarConta(new ContaImposto(atributos[1], atributos[2], Double.parseDouble(atributos[3]),Double.parseDouble(atributos[4])));
            }
        }
     
        String menu_principal = gerarMenu(nome_banco,"Cadastrar, Consultar saldo, Sacar, Depositar, Transferir, Render Juros, Excluir, Totalizações");
        int opcao;
        
        do{

            if(!banco.temContas()) {
                opcao = obterOpcao(gerarMenu(nome_banco, "Cadastrar"));
                if (opcao != 0 && opcao != 1)
                    continue;
            }

            else{
                opcao = obterOpcao(menu_principal);
                if (opcao < 1 || opcao > 8)
                    continue;
            }

            if(opcao == CADASTRO){
            
                String nome;
                double saldo;
                
                String[] opcoes = { "Normal", "Poupança", "Imposto" };
                int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Menu", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

                String numero_cadastro = lerString("\nDigite o número da conta desejada: ", input);
                while (!(banco.consultarPorNumero(numero_cadastro) == null)) {
                    JOptionPane.showMessageDialog(null, "Este número já está cadastrado!", "Erro",JOptionPane.ERROR_MESSAGE);
                    numero_cadastro = lerString("\nPor favor, digite outro: ", input);
                }
                nome = lerString("Digite seu nome: ", input);
                saldo = lerDoublePositivo("\nDigite seu saldo atual: ", input);

                if(escolha == 0){

                    banco.cadastrarConta(new Conta(numero_cadastro, nome, saldo));

                }else{

                    double taxa = lerDoublePositivo("Digite o valor da taxa: ",input);

                    if(escolha == 1)
                        banco.cadastrarConta(new ContaPoupanca(numero_cadastro, nome, saldo, taxa));
                    else
                        banco.cadastrarConta(new ContaImposto(numero_cadastro, nome, saldo, taxa));
                }

            }

            else if(opcao == CONSULTA){

                Conta procurada;
                do {
                    procurada = banco.consultarPorNumero(lerString("Digite o numero da conta desejada: ", input));
                    if (procurada == null)
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);
                    else
                        System.out.println(procurada);
                    System.out.println();
                }while (lerSimOuNao("Deseja realizar uma nova consulta?", input));
            }

            else if(opcao == SAQUE){

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
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente!", "Erro",JOptionPane.ERROR_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);

                    System.out.println();
                }while(lerSimOuNao("Repetir operação? ",input));//Limpar tela quando quiser repteir operação...

            }

            else if(opcao == DEPOSITO){

                String numero_depositada;
                do {
                    numero_depositada = lerString("\nDigite o número da sua conta: ",input);
                    if(banco.estaCadastrada(numero_depositada)){
                        double valor_deposito = lerDoublePositivo("\nDigite o valor do depósito: ",input);
                        if(banco.depositar(numero_depositada,valor_deposito)){
                            System.out.println("Depósito de R$ "+valor_deposito+" realizado com sucesso!");
                            break;
                        }
                        else
                            JOptionPane.showMessageDialog(null, "Depósito falhou!", "Erro",JOptionPane.ERROR_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);

                    System.out.println();
                }while(lerSimOuNao("Repetir operação? ",input));
            }

            else if(opcao == TRANSFERENCIA){
                    
                String numero_fonte, numero_destino;
                double valor_transferencia;
                do {
                    numero_fonte = lerString("Digite o número da conta fonte: ", input);
                    numero_destino = lerString("Digite o número da conta destino: ", input);
                    valor_transferencia = lerDoublePositivo("Digite o valor a ser transferido: ", input);

                    if (!banco.transferir(numero_fonte, numero_destino, valor_transferencia)) {
                        System.out.println("Operação falhou!");
                    } else {
                        System.out.printf("Transferência de R$ %f para %s realizada com sucesso!", valor_transferencia, banco.consultarPorNumero(numero_destino).getNome());
                        break;
                    }
                }while(lerSimOuNao("Repetir operação? ",input));

            }

            else if(opcao == RENDER_JUROS){

                System.out.print("Digite o número da sua conta poupança:\n>>> ");
                Conta conta_poupanca = banco.consultarPorNumero(input.nextLine());
                if(conta_poupanca == null) {
                    JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
                else if(conta_poupanca instanceof ContaPoupanca){
                    ((ContaPoupanca)conta_poupanca).renderJuros();

                }else {
                    JOptionPane.showMessageDialog(null, "Conta não é do tipo poupança!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            else if(opcao == EXCLUSAO){

                Conta alvo;
                do{
                    alvo = banco.consultarPorNumero(lerString("Digite o numero da conta desejada: ",input));
                    if(alvo == null){

                        JOptionPane.showMessageDialog(null, "Conta não encontrada!", "Erro",JOptionPane.ERROR_MESSAGE);

                    }else{

                        banco.excluirContaPorNumero(alvo.getNumero());
                        //nao sei se funcionou ou não...
                        System.out.println("Exclusão concluída com sucesso!");
                        break;
                    }
                }while(lerSimOuNao("Deseja tentar novamente?",input));
            }

            else if(opcao == TOTAL){
                System.out.println(banco);
                pause();
            }

            limparConsole();
        }while(opcao != SAIDA);
        
        if(banco.temContas()){

            try ( BufferedWriter buffwriter = new BufferedWriter(
                new FileWriter(getCaminhoDoBancoDeDados(nome_banco ) 
                ) ) ){

                for(Conta conta : banco.getContas() ){
                    buffwriter.write(conta.salvar());
                }

            } catch (IOException e){
                System.out.println("Erro durante a tentativa de salvar as contas em "+getCaminhoDoBancoDeDados(nome_banco));
                e.printStackTrace();
            }catch(RuntimeException e){
                System.out.println("Erro desconhecido durante a tentativa de salvar as contas.");
            }
           
        }

        input.close();
    }

    public static String getCaminhoDoBancoDeDados(String nomeDoBanco){
        
        return System.getProperty("user.dir")+"/db/%sContas.txt".formatted(nomeDoBanco);
    }
}
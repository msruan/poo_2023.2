package contas_c;

import java.util.Optional;
import java.util.Scanner;
import javax.swing.JOptionPane;

import static contas_c.utils.MenuUtils.*;

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
        String nome_banco = "";
    
        for(int i = 0; i < 3; i++){
            
            try{
                nome_banco = validarString(JOptionPane.showInputDialog(null,"Digite o nome do seu banco: ", "Bem vindo!", JOptionPane.QUESTION_MESSAGE));
                break;

            }catch(IllegalArgumentException e){

                if(i < 2)
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar um nome!", "Erro",JOptionPane.ERROR_MESSAGE);
                else{
                    JOptionPane.showMessageDialog(null, "Volte quando decidir o nome do banco!", "Erro",JOptionPane.ERROR_MESSAGE);
                    System.exit(1);
                }
            }
        }

        Banco banco = new Banco(nome_banco);
        banco.carregarDeArquivo();

        limparConsole();
        String primeiro_menu = gerarMenu(nome_banco, "Cadastrar");
        String menu_principal = gerarMenu(nome_banco,"Cadastrar, Consultar saldo, Sacar, Depositar, Transferir, Render Juros, Excluir, Totalizações");
        int opcao = -1;
        
        do{
            try{
                if(banco.getTotalContas() == 0) {

                    System.out.print(primeiro_menu);
                    opcao = (int)validarValor(input.nextLine());
                    
                    if (opcao != 0 && opcao != 1)
                        continue;
                }

                else{
                    System.out.print(menu_principal);
                    opcao = (int)validarValor(input.nextLine());
                    
                
                }
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, "Tenha certeza de digitar um número!", "Erro",JOptionPane.ERROR_MESSAGE);
            }

            if(opcao == CADASTRO){
                
                String[] opcoes = { "Normal", "Poupança", "Imposto" };
                int escolha = JOptionPane.showOptionDialog(null, "Escolha o tipo de conta desejado", "Tipo", 0, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                try{
                    String numero = validarString(JOptionPane.showInputDialog(null,"\nDigite o número da conta desejada: ","Cadastro", JOptionPane.QUESTION_MESSAGE));
                    validarValor(numero);
      
                    String nome = validarString(JOptionPane.showInputDialog(null,"Digite seu nome: ", "Cadastro", JOptionPane.QUESTION_MESSAGE));    
                    
                    double saldo = validarValor(JOptionPane.showInputDialog(null,"Digite seu saldo atual: ", "Cadastro", JOptionPane.QUESTION_MESSAGE));

                    if(escolha == 0)
                        banco.inserir(new Conta(numero, nome, saldo));

                    else{
                        double taxa = validarValor(JOptionPane.showInputDialog(null,"Digite o valor da taxa: ", "Cadastro", JOptionPane.QUESTION_MESSAGE));;

                        if(escolha == 1)
                            banco.inserir(new ContaPoupanca(numero, nome, saldo, taxa));
                        else
                            banco.inserir(new ContaImposto(numero, nome, saldo, taxa));
                    }
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar um número!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch(IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de não deixar nenhum campo em branco!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch(ValorInvalidoException e){
                    JOptionPane.showMessageDialog(null, "Só é possível passar valores positivos para o cadastro!", "Erro",JOptionPane.ERROR_MESSAGE);
                }

            }

            else if(opcao == CONSULTA){

                try{
                    String buscada = validarString(JOptionPane.showInputDialog(null,"\nDigite o número da conta desejada: ","Consulta", JOptionPane.QUESTION_MESSAGE));
                    validarValor(buscada);
                    Conta procurada = banco.consultarConta(buscada);
                    System.out.println(procurada);
                    input.nextLine();
                    pause(input,"<Enter>");

                }catch(ContaNotFoundException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar o número da conta!", "Erro",JOptionPane.ERROR_MESSAGE);
                }catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar o número da conta!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            else if(opcao == SAQUE || opcao == DEPOSITO){     

                try{
                    String numero = validarString(JOptionPane.showInputDialog(null,"\nDigite o número da conta desejada: ","Cadastro", JOptionPane.QUESTION_MESSAGE));
                    validarValor(numero);
                    Conta conta = banco.consultarConta(numero);
                    double valor = validarValor(JOptionPane.showInputDialog(null,"Digite o valor: ", String.format("%s",opcao == SAQUE ? "Saque" : "Depósito"), JOptionPane.QUESTION_MESSAGE));

                    if(opcao == SAQUE)
                        conta.sacar(valor);
                    else
                        conta.depositar(valor);

                    JOptionPane.showMessageDialog(null, String.format("%s de R$ "+valor+" realizado com sucesso!",opcao == SAQUE ? "Saque" : "Depósito"));

                }catch(ContaNotFoundException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);

                }catch(ValorInvalidoException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar um número!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de não deixar nenhum campo em branco!", "Erro",JOptionPane.ERROR_MESSAGE);
                }catch(SaldoInsuficienteException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);

                }
            }

            else if(opcao == TRANSFERENCIA){

                
                try{
                    String numero_fonte = validarString(JOptionPane.showInputDialog(null,"Digite o número da conta fonte: "));
                    String numero_destino = validarString(JOptionPane.showInputDialog(null,"Digite o número da conta destino: "));
                    validarValor(numero_fonte);
                    validarValor(numero_destino);
                    double valor = validarValor(JOptionPane.showInputDialog(null,"Digite o valor a ser transferido: ", String.format("%s",opcao == SAQUE ? "Saque" : "Depósito"), JOptionPane.QUESTION_MESSAGE));
                    banco.transferir(numero_fonte, numero_destino, valor);
                    JOptionPane.showMessageDialog(null, String.format("Transferência de %f realizada com sucesso!",valor));
                }
                catch(ContaNotFoundException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);

                }catch(ValorInvalidoException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar um número!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de não deixar nenhum campo em branco!", "Erro",JOptionPane.ERROR_MESSAGE);
                }catch(SaldoInsuficienteException e){
                    JOptionPane.showMessageDialog(null,e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            else if(opcao == RENDER_JUROS){
                
                try{
                    String numero = validarString(JOptionPane.showInputDialog(null,"Digite o número da conta poupança: "));;
                    validarValor(numero);
                    banco.renderJuros(numero);

                }catch(ContaNotFoundException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch(NotPoupancaObject e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }
                catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar o número da conta!", "Erro",JOptionPane.ERROR_MESSAGE);
                }catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar o número da conta!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            else if(opcao == EXCLUSAO){

                try{
                    String excluida = validarString(JOptionPane.showInputDialog(null,"Digite o numero da conta desejada: ","Exclusão", JOptionPane.QUESTION_MESSAGE));
                    validarValor(excluida);
                    banco.excluir(excluida);
                    JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");

                }catch(ContaNotFoundException e){
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro",JOptionPane.ERROR_MESSAGE);
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar o número da conta!", "Erro",JOptionPane.ERROR_MESSAGE);
                }catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null, "Tenha certeza de digitar o número da conta!", "Erro",JOptionPane.ERROR_MESSAGE);
                }
            }

            else if(opcao == TOTAL){
                System.out.println(banco);
                input.nextLine();
                pause(input,"<Enter>");
            }

            limparConsole();
        }while(opcao != SAIDA);

        banco.salvarEmArquivo();
        
        input.close();
    }
    public static double validarValor(String entrada) throws IllegalArgumentException, NumberFormatException{
        validarString(entrada);
        return Double.parseDouble(entrada);
    }
    public static String validarString(String entrada) throws IllegalArgumentException{
        if(Optional.ofNullable(entrada).isPresent() &&  !entrada.trim().isBlank()){
            return entrada;
        }throw new IllegalArgumentException();
    }
}
public class Teste {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Joao", "Silva");
        System.out.println("Olá " + pessoa.getNomeCompleto());
        Funcionario func = new Funcionario("Maria", "Santos", 1111, 1500);
        Professor prof = new Professor("Igor", "Sena", 2222, 3000, "Mestre");
        Pessoa[] pagados = {pessoa,func,prof}; 
        FolhaDePagamento pagamento = new FolhaDePagamento(pagados);
        System.out.println("Vamos pagar R$ "+pagamento.calcularPagamentos() + " para os funcionários no total!");

    }
}

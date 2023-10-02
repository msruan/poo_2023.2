package contas;
class TestaPrivacidade {
    public static void main(String[] args) {
        Conta cliente = new Conta("32123", "Ruan");
        Banco bradesco = new Banco("Bradesco");
        bradesco.cadastrarConta(cliente);
        System.out.println(bradesco.contas);
        System.out.println(cliente.nome);
        System.out.println(cliente.numero);
    }
}
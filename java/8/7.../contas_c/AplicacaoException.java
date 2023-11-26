package contas_c;

public class AplicacaoException extends Exception{
    @Override
    public String getMessage(){
        return "Houve um erro durante a execução do programa!";
    }
}

class AccountNotFoundException extends AplicacaoException {
    @Override
    public String getMessage(){
        return "Conta não registrada no banco!";
    }
}

class SaldoInsuficienteException extends AplicacaoException {
    @Override
    public String getMessage(){
        return "Impossível descontar o valor da conta, saldo insuficente!";
    }
}

class NonPoupancaAccountException extends AplicacaoException {
    @Override
    public String getMessage(){
        return "A conta passada como argumento não é do tipo Poupança!";
    }
}
package contas_c;

public class AplicacaoException extends Exception{ 
    @Override
    public String getMessage() {
        return "Erro na aplicaçãp!";
    }
}

class NotPoupancaObject extends AplicacaoException {
    @Override
    public String getMessage() {
        return "Conta informada não é poupança!";
    }
}

class ContaNotFoundException extends AplicacaoException {
    @Override
    public String getMessage() {
        return "Conta não encontrada!";
    }
}

class SaldoInsuficienteException extends AplicacaoException {
    @Override
    public String getMessage() {
        return "Não há saldo suficiente para completar operação!";
    }
}

class ValorInvalidoException extends AplicacaoException {
    @Override
    public String getMessage() {
        return "Só é possível passar valores positivos para a operação!";
    }
}
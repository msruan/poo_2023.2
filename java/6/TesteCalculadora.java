class Calculadora {

    private double _operando1;
    private double _operando2;

    Calculadora(double _operando1, double _operando2) {
        this._operando1 = _operando1;
        this._operando2 = _operando2;
    }

    public double calcularProduto() {
        return _operando1 * _operando2;
    }

    public double calcularSoma() {
        return _operando1 + _operando2;
    
    }
    
}
public class TesteCalculadora {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora(17, 24);
        System.out.printf("A soma dos números %f e %f é igual a %f!",calculadora._operando1, calculadora._operando2, calculadora.calcularSoma());
        //dá erro
    }
}


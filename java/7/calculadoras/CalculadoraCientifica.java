package calculadoras;

public class CalculadoraCientifica extends Calculadora {
    CalculadoraCientifica(double op1, double op2){
        super(op1, op2);
    }
    public double exponeciar(){
        int i, expo = 1;
        for(i = 0; i < getOp2(); i++){
            expo *= getOp1();
        }return expo;
    }
}

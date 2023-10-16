package calculadoras;
public class Calculadora {
    private double op1;
    private double op2;

    Calculadora(double op1, double op2){
        this.op1 = op1;
        this.op2 = op2;
    }

    public double getOp1(){
        return op1;
    }

    public double getOp2(){
        return op2;
    }

    double somar(){
        return op1+op2;
    }
}

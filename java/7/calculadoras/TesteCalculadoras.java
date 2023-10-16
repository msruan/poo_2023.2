package calculadoras;

public class TesteCalculadoras {
    public static void main(String[] args) {
        Calculadora c1 = new Calculadora(7,2);
        System.out.println("A soma dos elementos é igual a "+c1.somar());
        CalculadoraCientifica c2 = new CalculadoraCientifica(5,3);
        System.out.printf("%.3f elevado a %.3f é igual a %.3f",c2.getOp1(),c2.getOp2(),c2.exponeciar());
    }
}

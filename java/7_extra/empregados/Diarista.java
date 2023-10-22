package empregados;

public class Diarista extends Empregado {

	public double calcularSalario(){
		return super.calcularSalario()/30;
	}
	
}
package empregados;

public class Horista extends Diarista {

	public double calcularSalario(){
		return super.calcularSalario()/24;
	}
	
}
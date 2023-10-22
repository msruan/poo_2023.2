public class Funcionario extends Pessoa {

	Funcionario(String nome, String sobrenome, double matricula, double salario){
		super(nome, sobrenome);
		if(salario < 0) {
			throw new RuntimeException();
		}
		this._matricula = matricula;
		this._salario = salario;
	}

	private double _matricula;
	private double _salario;

	public double getMatricula() {
		return _matricula;
	}

	public double getSalario() {
		return _salario;
	}

	public double getSalarioPrimeiraParcela() {
		return getSalario()*0.6;
	}

	public double getSalarioSegundaParcela() {
		return getSalario()*0.4;
	}
}
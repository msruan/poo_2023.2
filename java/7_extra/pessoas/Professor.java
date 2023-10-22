public class Professor extends Funcionario {

	private String _titulacao;

	Professor(String nome, String sobrenome, double matricula, double salario, String titulacao){
		super(nome,sobrenome,matricula,salario);
		this._titulacao = titulacao;
	}	

	public String getTitulacao() {
		return _titulacao;
	}

	public double calcularSalarioPrimeiraParcela() {
		return super.getSalario();
	}

	public double calcularSalarioSegundaParcela() {
		return 0;
	}
}
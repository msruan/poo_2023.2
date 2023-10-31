public class FolhaDePagamento {

	private Pessoa[] _funcionarios;

	FolhaDePagamento(Pessoa[] funcionarios){
		this._funcionarios = funcionarios;
	}

	public Pessoa[] getFuncionarios() {
		return _funcionarios;
	}

	public double calcularPagamentos() {
		double soma = 0;
		for(Pessoa func : getFuncionarios()){
			if(func instanceof Professor) {
				soma += ((Professor)func).getSalario();

			}else if(func instanceof Funcionario){
				soma+= ((Funcionario)func).getSalario();
			}
		}return soma;
	}
}
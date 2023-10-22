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
				Professor func_cast = (Professor)func;
				soma += func_cast.getSalario();
			}else if(func instanceof Funcionario){
				Funcionario func_cast = (Funcionario)func;
				soma+= func_cast.getSalario();
			}
		}return soma;
	}
	
}
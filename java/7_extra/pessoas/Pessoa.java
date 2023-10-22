public class Pessoa {

	private String _nome;
	private String _sobrenome;

	Pessoa (String nome, String sobrenome) {
		this._nome = nome;
		this._sobrenome = sobrenome;
	}

	public String getNome() {
		return _nome;
	}
	public String getSobrenome() {
		return _sobrenome;
	}
	public String getNomeCompleto() {
		return getNome()+" "+getSobrenome();
	}
}
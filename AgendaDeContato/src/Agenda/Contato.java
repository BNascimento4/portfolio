package Agenda;

public class Contato {
	private String nomeContato;
	private String numeroTelefone;
	public Contato() {
	}
	public String getNumero() {
		return this.numeroTelefone;
	}
	public String getNome() {
		return this.nomeContato;
	}
	public void setNome(String nome_contato) {
		this.nomeContato = nome_contato;
		return;
	}
	public void setNumero(String numero_telefone) {
		this.numeroTelefone = numero_telefone;
		return;
	}
}

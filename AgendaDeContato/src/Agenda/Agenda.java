package Agenda;
import java.util.Scanner;
public class Agenda{
	public Contato[] contatos = new Contato[100];
	public int i = 0;
	public void Inicio() {
		System.out.println("Bem-Vindo a sua agenda de contatos!!!");
		boolean rodar = true;
		while(rodar) {
			Scanner escolha = new Scanner(System.in);
			System.out.println("Oque deseja fazer?");
			System.out.println("1- Novo contato.");
			System.out.println("2-Buscar contato.");
			System.out.println("0-Sair da agenda.");
			System.out.println("Escolha:");
			int opcao = escolha.nextInt();
			switch(opcao) {
				case 1:
					novoContato();
					break;
				case 2:
					buscarContato();
					break;
				case 0:
					rodar = false;
					break;
				default:
					System.out.println("Opção invalida.");
					break;
			}
		}
	}
	public void novoContato(){
		Scanner resposta = new Scanner(System.in);
		Scanner respostaN = new Scanner(System.in);
		System.out.println("Nome do Contato: ");
		String nome = resposta.nextLine();
		System.out.println("Numero de telefone:");
		String numero = respostaN.nextLine();
		this.contatos[i] = new Contato();
		this.contatos[i].setNome(nome);
		this.contatos[i].setNumero(numero);
		i++;
		return;
	}
	public void buscarContato() {
		Scanner resposta = new Scanner(System.in);
		System.out.println("Nome do Contato: ");
		String nome = resposta.nextLine();
		for(int j = 0; j < i; j ++) {
			String contato = this.contatos[j].getNome();
			if(nome.equalsIgnoreCase(contato)) {
				String nomep = contatos[j].getNome();
				String numerop = contatos[j].getNumero();
				System.out.println("Nome: " + nomep);
				System.out.println("Numero: " + numerop);
				return;
			}
		}
		System.out.println("Contato não encontrado");
		return;
	}
}

package truco;
import java.util.ArrayList;
import java.util.Scanner;

public class jogoSolo {

	Baralho baralho;
    ArrayList<Jogador> jogadores;
    int turno;
    int pontosEquipe1 = 0;
    int pontosEquipe2 = 0;
    int pontoRodadaE1 = 0;
    int pontoRodadeE2 = 0;
    int pontoTurno1 = 0;
    int pontoTurno2 = 0;
    public int timeVencedor;
    ArrayList<Carta> pilha = new ArrayList<Carta>();
    public jogoSolo() {
 
        jogadores = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            jogadores.add(new Jogador());
        }
        turno = 0;
    }

    private void distribuirCartas() {
        for (Jogador jogador : jogadores) {
            for (int i = 0; i < 3; i++) {
                jogador.pegaCarta(baralho.retiraCarta());
            }
        }
    }

   
        private int iniciarRodada() {
            distribuirCartas();
            int jogando = 0;
            Carta cartaMaior = null;
            int timeMaior = 0; 
            int pontuacao = 1;
            while (!todosJogaram()) {
            	cartaMaior = null;
            	for(int i = 0; i < 2; i++) {
                Jogador jogadorAtual = jogadores.get(jogando);
                System.out.println("\nJogador " + (jogando + 1) + ":");
                jogadorAtual.printCarta();
                Scanner s = new Scanner(System.in);
                System.out.println("Escolha a carta ou -1 para truco:");
                int cartaEscolhida = s.nextInt();
           

                if (cartaEscolhida == -1) {
                	boolean respostaTruco = aceitarTruco(jogando + 1);
                    if (respostaTruco) {
                        if(pontuacao == 1)pontuacao = 3;
                        else if(pontuacao > 1)pontuacao += 3;
                        else if(pontuacao >= 12) System.out.println("Truco esta no seu maximo!!!");
                        jogadorAtual.printCarta();
                    	System.out.println("Escolha a carta");
                    	cartaEscolhida = s.nextInt();
                        } else {
                        	if(jogando + 1 == 2) timeMaior = 2;
                    		else timeMaior = 1;
                            System.out.println("Truco recusado!");
                            for(Jogador jogador : jogadores) {
                            	jogador.mao.clear();
                            }
                            this.timeVencedor = timeMaior;
                            return pontuacao;
                        }
                    } 
                    
                    pilha.add(jogadorAtual.jogarCarta(cartaEscolhida));
                    Carta c = pilha.get(pilha.size() - 1);
                	System.out.println("Carta jogada: " + c.getNaipe() + " " + c.getValue());
                    if (cartaMaior == null) {
                    		cartaMaior = pilha.get(pilha.size() - 1);
                    		if(jogando + 1 == 1) timeMaior = 1;
                    		else timeMaior = 2;
                }else {
                	if(cartaMaior.forca < pilha.get(pilha.size()-1).forca) {
                		cartaMaior = pilha.get(pilha.size() - 1);
                		if(jogando + 1 == 2) timeMaior = 2;
                		else timeMaior = 1;
                	}
                }

                jogando = (jogando + 1) % 2;
            }
            if(timeMaior == 1) {
            	System.out.println("Time 1 venceu o turno.");
            	pontoTurno1++;
            }else if(timeMaior == 2){
            	System.out.println("Time 2 venceu o turno.");
            	pontoTurno2++;
            }
            }
            if(pontoTurno1 > pontoTurno2) {
            	this.timeVencedor = 1;
            }else if (pontoTurno2 > pontoTurno1){
            	this.timeVencedor = 2;
            }
            pilha.clear();
            this.timeVencedor = timeMaior;
            return pontuacao;
        
}
 

    private boolean todosJogaram() {
        for (Jogador jogador : jogadores) {
        	int valor = jogador.getMao();
            if (valor > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean aceitarTruco(int jogadorAtual) {
        int jogadorOponente = (jogadorAtual + 1) % 2;
        System.out.println("Jogador " + jogadorOponente  + ", aceitar truco? (1-sim/2-não):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt() == 1;
    }




    private void mostrarPontuacoes() {
        System.out.println("\n**Pontuacoes:**");
        System.out.println("Equipe 1: " + pontosEquipe1);
        System.out.println("Equipe 2: " + pontosEquipe2);
    }

    public void iniciarPartida() {
        while (pontosEquipe1 < 12 && pontosEquipe2 < 12) {
        	baralho = new Baralho();
        	baralho.setManilha();
            baralho.embaralhar();
            int pontos = iniciarRodada();
       
            if(this.timeVencedor == 1) {
            	this.pontosEquipe1 += pontos;
            }else if(this.timeVencedor == 2) {
            	this.pontosEquipe2 += pontos;
            }
            mostrarPontuacoes();
        }

        determinarVencedorPartida();     
        }

    private void determinarVencedorPartida() {
        if (this.pontosEquipe1 >= 12) {
            System.out.println("\nEquipe 1 venceu a partida!");
        } else {
            System.out.println("\nEquipe 2 venceu a partida!");
        }
    }
 }
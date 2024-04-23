package truco;
import java.util.ArrayList;
public class Jogador {
    protected int pontuacao;
    ArrayList<Carta> mao = new ArrayList<Carta>();
    public Jogador() {
        this.pontuacao = 0;
    }

    public void setPontuacao(int i) {
        this.pontuacao += i;
    }
    public int getPontuacao() {
    	return this.pontuacao;
    }
    public Carta jogarCarta(int i) {
    	int j = 1;
    	for(Carta maos : mao) {
    		if(j == i) {
    			mao.remove(maos);
    			return maos;
    		}
    		j++;
    	}
		return null;
    }
    public void pegaCarta(Carta carta) {
    	mao.add(carta);
    }
    public void printCarta() {
    	int opcaoCarta = 1;
    	for(Carta cartaA : mao) {
    		System.out.println(opcaoCarta+" - "+cartaA.getNaipe()+ " " + cartaA.getValue());
    		opcaoCarta++;
    	}
    }

	public int getMao() {
		
		int valor = this.mao.size();
		return valor;
	}
}



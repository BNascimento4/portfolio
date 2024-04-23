package truco;
import java.util.ArrayList;
import java.util.Collections;

public class Baralho {
  ArrayList<Carta> cartas = new ArrayList<Carta>();
  public int forca;
  public Baralho() {
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 10; j++) {
        String value;
        String naipes;
        switch (i) {
          case 0:
            value = escolher(j);
            naipes = "♦️";
            this.forca = 10 + j;
            Carta cartaO = new Carta(value, naipes,forca);
            cartas.add(cartaO);
            break;
          case 1:
            value = escolher(j);
            naipes = "♠️";
            this.forca = 20 + j;
            Carta cartaE = new Carta(value, naipes,forca);
            cartas.add(cartaE);
            break;
          case 2:
            value = escolher(j);
            naipes = "♥️";
            this.forca = 30 + j;
            Carta cartaC = new Carta(value, naipes,forca);
            cartas.add(cartaC);
            break;
          case 3:
            value = escolher(j);
            naipes = "♣️";
            this.forca = 40 + j;
            Carta cartaP = new Carta(value, naipes,forca);
            cartas.add(cartaP);
            break;
          default:
            break;
        }
      }

    }
  }

  public String escolher(int J) {
    switch (J) {
      case 7:
        return "A";

      case 8:
        return "2";

      case 9:
      	
        return "3";

      case 0:
      	
        return "4";

      case 1:
       
        return "5";

      case 2:
      	
        return "6";

      case 3:
    
        return "7";

      case 4:
       
        return "J";

      case 5:
      
        return "Q";

      case 6:
    
        return "K";

      default:
        break;
    }
    return "";
  }

 
  public void embaralhar() {
    Collections.shuffle(cartas);
  }
  public Carta retiraCarta() {
  	return cartas.removeFirst();
  }
  public void setManilha() {
	   	embaralhar();
	   	System.out.println(cartas.getFirst().getNaipe()+  " " + cartas.getFirst().getValue() + " é a Carta Virada.");
	    for(Carta card : cartas) {
	    	if(card.getForca() == cartas.getFirst().getForca() + 1) {
	    		card.setForca(50);
	    	}
	    }
	  }
  public void printCarta() {
  	for(Carta cartaA : cartas) {
  		System.out.println(cartaA.getNaipe()+ " " + cartaA.getValue() + " " + cartaA.getForca());
  	}
  }
}

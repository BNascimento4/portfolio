package truco;

import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("1- Para jogo 1v1	2- Para jogo 2v2");
		int a = s.nextInt();
		if(a == 2) {
			Jogo j = new Jogo();
			j.iniciarPartida();
		}else if(a == 1){
			jogoSolo j = new jogoSolo();
			j.iniciarPartida();
		}
	}
}

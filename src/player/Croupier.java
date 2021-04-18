package player;

import main.Karta;

public class Croupier extends Player {

	public Croupier() {
		super();
	}
	
	public void showFirst() {
		Karta karta = actualCards.iterator().next();
		System.out.println(karta.toString());
		System.out.println("X");
		if (karta.getWartosc() == 14) {
			System.out.println("Wartoœæ: 1/11");
		} else {
			System.out.println("Wartoœæ: " + karta.getValue());
		}
		System.out.println("------------------------------------");
	}
	
	public Boolean endGame() {
		if (points <= 16) {
			return Boolean.FALSE;
		} else {
			return Boolean.TRUE;
		}
	}
	
}

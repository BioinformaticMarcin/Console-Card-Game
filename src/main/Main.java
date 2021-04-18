package main;

import player.Croupier;
import player.Player;

public class Main {

	private static Talia talia;
	
	public static void main(String[] args) {
		
		// Tworzenie nowej talii
		talia = new Talia();
		talia.tasuj();
		
		Player player = new Player();
		player.addCard(talia.pobierz());
		player.addCard(talia.pobierz());
		System.out.println("Twoje karty:");
		player.showCards();
		
		Croupier croupier = new Croupier();
		croupier.addCard(talia.pobierz());
		croupier.addCard(talia.pobierz());
		System.out.println("Karty krupiera:");
		croupier.showFirst();
		
		Boolean gameOn = Boolean.TRUE;
		while (gameOn) {
			switch (player.playerMove()) {
			case "Hit":
				addNextCard(player);
				player.showCards();
				croupier.showFirst();
				break;
			case "Stand":
				gameOn = Boolean.FALSE;
				System.out.println("Twoje karty:");
				player.showCards();
				System.out.println("Karty krupiera:");
				croupier.showCards();
				break;
			case "Double":
				System.out.println("Double Down");
				addNextCard(player);
				gameOn = Boolean.FALSE;
				System.out.println("Twoje karty:");
				player.showCards();
				System.out.println("Karty krupiera:");
				croupier.showCards();
				break;
			}
			
			if (!player.areYouWinning) {
				gameOn = Boolean.FALSE;
				System.out.println("Karty krupiera:");
				croupier.showCards();
				System.out.println("You lose!");
				return;
			} 
			if (!gameOn){
				while(!croupier.endGame()) {
					addNextCard(croupier);
					System.out.println("Karty krupiera:");
					croupier.showCards();
				}
				Integer crouToBJDist = Math.abs(croupier.getPoints() - 21);
				Integer crouToBJDistAs = Math.abs(croupier.getPointsAs() - 21);
				Integer playToBJDist = Math.abs(player.getPoints() - 21);
				Integer playToBJDistAs = Math.abs(player.getPointsAs() - 21);
				
				crouToBJDist = crouToBJDist < crouToBJDistAs ? crouToBJDist : crouToBJDistAs;
				playToBJDist = playToBJDist < playToBJDistAs ? playToBJDist : playToBJDistAs;
				
				if (crouToBJDist < playToBJDist) {
					System.out.println("You lose!");
				} else {
					System.out.println("You win!");
				}
				
			}
		}
	}
	
	public static void addNextCard (Player player) {
		Karta karta = talia.pobierz();
		System.out.println("------------------------------------");
		System.out.println("Pobrana karta: " + karta.toString());
		player.addCard(karta);
		System.out.println("------------------------------------");
	}
	
}

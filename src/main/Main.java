package main;

import oczko.Oczko;

public class Main {

	public static void main(String[] args) {
		
		// Tworzenie nowej talii
		Talia talia = new Talia();
		talia.tasuj();
		
		
		Boolean gameOn = Boolean.TRUE;
		while (gameOn) {
			gameOn = Oczko.bierzCzyStop();
			if (gameOn) {
				Karta karta = talia.pobierz();
				System.out.println("------------------------------------");
				System.out.println("Pobrana karta: " + karta.toString());
				Oczko.addCard(karta);
				System.out.println("------------------------------------");
			}
		}
		Oczko.sprawdzOczko();
	}

}

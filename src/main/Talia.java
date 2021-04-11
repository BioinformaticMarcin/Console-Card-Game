package main;

import java.util.ArrayList;
import java.util.Collections;

public class Talia {
	private ArrayList<Karta> karty;
	
	// Konstruktor dwie pêtle inicjuj¹ taliê - Tworz¹ nowe karty
	public Talia() {
		this.karty = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			for (int j = 2; j < 15; j++) {
				this.karty.add(new Karta(j, i));
			}
		}
	}
	
	// gotowa metoda KLasy Collections zwracaj¹ca randomowo posortowane elementy zbioru
	public void tasuj() {
		Collections.shuffle(karty);
	}
	
	// pobiera kolejny element talii
	public Karta pobierz() {
		Karta karta = karty.iterator().next();
		karty.remove(karta);
		return karta;
	}
	
	// metoda pomocnicza do wyœwietlania wszystkich kart
	public void showAll() {
		for (Karta karta : karty) {
			System.out.println(karta.toString());
		}
	}
}

package oczko;

import java.util.ArrayList;
import java.util.Scanner;

import main.Karta;

public class Oczko {
	private static Integer aktualnaLiczbaPunktow = 0;
	private static ArrayList<Karta> wybraneKarty = new ArrayList<>();
	
	public static void sprawdzOczko() {
		int perskieOko = 0;
		for (Karta karta : wybraneKarty) {
			if (karta.getWartosc() == 14) {
				perskieOko++;
			}
		}
		if (perskieOko >= 2) {
			System.out.println("Wygra³eœ! Masz perskie oko!");
		} else {
			System.out.println(aktualnaLiczbaPunktow < 21 ? "Wygra³eœ" : "Przegra³eœ");
		}
	}
	
	public static Boolean bierzCzyStop() {
		Scanner scnr = new Scanner(System.in);
		while (true) {
			System.out.println("Pobierz kartê - t\nZakoñcz grê - n");
			String read = scnr.nextLine();
			if (read.equals("n")) {
				return Boolean.FALSE;
			} else if (read.equals("t")) {
				return Boolean.TRUE;
			} 
			System.out.println("Wpisz poprawn¹ wartoœæ!");
		}
	}
	
	public static void addCard(Karta karta) {
		wybraneKarty.add(karta);
		aktualnaLiczbaPunktow += karta.getWartosc();
		System.out.println(String.format("Aktualny wynik: %s", aktualnaLiczbaPunktow.toString()));
	}
}

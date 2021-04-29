package main;

import java.util.ArrayList;
import java.util.Scanner;

import oczko.Oczko;
import player.Croupier;
import player.Player;

public class Games {
	protected static void oczko() {

		Oczko.newOczko();
		Talia talia = new Talia();
		talia.tasuj();
		talia.pobierz();

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
	
	protected static void wojna() {
		Talia talia = new Talia();
		talia.tasuj();
		Player system = new Player();
		Player player = new Player();
		
		//Rozdanie
		ArrayList<Karta> allCards = talia.getAllCards();
		for (int i = 0; i < allCards.size(); i++) {
			if (i%2==0) {
				system.justAddCard(allCards.get(i));
			} else {
				player.justAddCard(allCards.get(i));
			}
		}
		ArrayList<Karta> tableSys = new ArrayList<>();
		ArrayList<Karta> tablePlay = new ArrayList<>();
		Scanner scnr = new Scanner(System.in);
		
		wojna:while (!system.getActualCards().isEmpty() || !player.getActualCards().isEmpty()) {
			menu:while(true) {
				System.out.println("------------------------------------");
				System.out.println(String.format("Ilo�� kart systemu: %d", system.getActualCards().size()));
				System.out.println(String.format("Ilo�� twoich kart: %d", player.getActualCards().size()));
				System.out.println("------------------------------------");
				System.out.println("Tw�j ruch [wpisz wybrany numer a nast�pnie naci�nij ENTER]");
				System.out.println("1. Graj");
				System.out.println("2. Przerwij");
				
				String option = scnr.nextLine();
				switch (option.trim()) {
				case "1":
					break menu;
				case "2":
					break wojna;
				default:
					System.out.println("Wpisz poprawn� warto��!");
					continue;
				}
			}
			
			while(true) {
				tableSys.add(system.getActualCards().get(0));
				System.out.println(String.format("System:\t %s", system.getActualCards().get(0).toString()));
				system.getActualCards().remove(0);
				
				tablePlay.add(player.getActualCards().get(0));
				System.out.println(String.format("Ty:\t %s", player.getActualCards().get(0).toString()));
				player.getActualCards().remove(0);
				
				if (tableSys.get(tableSys.size()-1).getWartosc() > tablePlay.get(tablePlay.size()-1).getWartosc()) {
					system.getActualCards().addAll(tableSys);
					system.getActualCards().addAll(tablePlay);
					tablePlay.clear();
					tableSys.clear();
					break;
				} else if (tableSys.get(tableSys.size()-1).getWartosc() < tablePlay.get(tablePlay.size()-1).getWartosc()) {
					player.getActualCards().addAll(tableSys);
					player.getActualCards().addAll(tablePlay);
					tablePlay.clear();
					tableSys.clear();
					break;
				} else {
					System.out.println("Wojna!");
					
				}
			}
		}
		
	}
	
	@SuppressWarnings("resource")
	protected static void wojnaIntro() {
		Scanner scnr = new Scanner(System.in);
		//Starting new game
		while(true) {
			System.out.println("Menu Wojny [wpisz wybrany numer a nast�pnie naci�nij ENTER]");
			System.out.println("1. Poka� zasady");
			System.out.println("2. Zagraj");
			System.out.println("3. Zako�cz gr� - Wojna");
			
			String option = scnr.nextLine();
			switch (option.trim()) {
			case "1":
				showZasadyWojny();
				continue;
			case "2":
				wojna();
				continue;
			case "3":
				return;
			default:
				System.out.println("Wpisz poprawn� warto��!");
				continue;
			}
		}
	}
	
	private static void showZasadyWojny() {
		System.out.println("Zasady gry s� bardzo proste. "
				+ "Przetasowan� tali� kart dzieli si� na dwie cz�ci, rozdaje graczom i k�adzie koszulkami do g�ry. \n"
				+ "Pierwszy i drugi zawodnik r�wnocze�nie wyk�adaj� po jednej karcie i por�wnuj� ich warto�ci \n"
				+ "(wzgl�dem starsze�stwa � kolory nie odgrywaj� roli). \n"
				+ "Gracz maj�cy kart� o wy�szej warto�ci odbiera karty i k�adzie je pod spodem swojej talii. \n"
				+ "Je�li karty maj� tak� sam� si�� (as na asa, kr�l na kr�la, itp.), rozp�tuje si� wojna, \n"
				+ "chyba �e gra si� w wi�cej os�b i s�absze karty nie walcz� np. 9-3-3 gracze z tr�jkami nie walcz�; \n"
				+ "nale�y odkry� po jednej karcie, po�o�y� je koszulkami do g�ry na swoich kartach odkrytych, \n"
				+ "a nast�pnie wyci�gn�� nast�pn� kart�, po�o�y� odkryte na zakrytych kartach i w�wczas s� one por�wnywane. \n"
				+ "Karta o wy�szej warto�ci wygrywa, a zwyci�zca wojny odbiera wszystkie karty wykorzystane w wojnie. \n"
				+ "Proces jest powtarzany, je�li w okresie wojny znowu nie mo�na wy�oni� zwyci�zcy.\n" 
				+ "Wygrywa ten, kto pierwszy zabierze wszystkie karty przeciwnikowi.\n\n");
	}
	
	protected static void blackJack() {
		
		// Tworzenie nowej talii
		Talia talia = new Talia();
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
				addNextCard(player, talia);
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
				addNextCard(player, talia);
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
					addNextCard(croupier, talia);
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
				return;
			}
		}
	}
	
	public static void addNextCard (Player player, Talia talia) {
		Karta karta = talia.pobierz();
		System.out.println("------------------------------------");
		System.out.println("Pobrana karta: " + karta.toString());
		player.addCard(karta);
		System.out.println("------------------------------------");
	}
}

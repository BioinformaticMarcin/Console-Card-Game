package main;

import java.util.Scanner;

public class Main extends Games{

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		main:while (true) {
			Scanner scnr = new Scanner(System.in);
			//Starting new game
			while(true) {
				System.out.println("W co chcesz zagraæ? [wpisz wybrany numer a nastêpnie naciœnij ENTER]");
				System.out.println("1. Oczko");
				System.out.println("2. BlackJack");
				System.out.println("3. Wojnê");
				
				String option = scnr.nextLine();
				switch (option.trim()) {
				case "1":
					oczko();
					break;
				case "2":
					blackJack();
					break;
				case "3":
					wojnaIntro();
					break;
				default:
					System.out.println("Wpisz poprawn¹ wartoœæ!");
					continue;
				}
				break;
			}
			//Ending program
			while(true) {
				System.out.println("Chcesz zakoñczyæ program? [wpisz wybrany numer a nastêpnie naciœnij ENTER]");
				System.out.println("1. Tak");
				System.out.println("2. Nie");
				
				String option = scnr.nextLine();
				switch (option.trim()) {
				case "1":
					break main;
				case "2":
					break;
				default:
					System.out.println("Wpisz poprawn¹ wartoœæ!");
					continue;
				}
				break;
			}
		}
		System.out.println("Koniec programu");
		return;
	}
	

	
}

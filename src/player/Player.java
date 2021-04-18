package player;

import java.util.ArrayList;
import java.util.Scanner;

import main.Karta;

public class Player {
	
	protected ArrayList<Karta> actualCards;
	protected Boolean isAs = Boolean.FALSE;
	public Boolean areYouWinning = Boolean.TRUE;
	protected Integer points = 0;
	protected Integer pointsWithAs = 0;

	public Player() {
		this.actualCards = new ArrayList<>();
	}

	public ArrayList<Karta> getActualCards() {
		return actualCards;
	}
	public void setActualCards(ArrayList<Karta> actualCards) {
		this.actualCards = actualCards;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public Integer getPointsAs() {
		return pointsWithAs;
	}
	
	public void addCard(Karta karta) {
		actualCards.add(karta);
		points += karta.getValue();
		if (karta.getWartosc() == 14) {
			isAs = Boolean.TRUE;
			pointsWithAs += 1;
		} else {
			pointsWithAs += karta.getValue();
		}
		if (pointsWithAs > 21) {
			areYouWinning = Boolean.FALSE;
		}
	}
	
	public void showCards() {
		for (Karta karta : actualCards) {
			System.out.println(karta.toString());
		}
		if (isAs) {
			System.out.println("Wartoœæ: " + pointsWithAs + "/" +  points.toString());
		} else {
			System.out.println("Wartoœæ: " + points.toString());
		}
		System.out.println("------------------------------------");
	}
	
	public String playerMove() {
		Scanner scnr = new Scanner(System.in);
		while (true) {
			System.out.println("Wpisz odpowiedni¹ literê:");
			System.out.println("Hit - h\nStand - s\nDouble down - d");
			String read = scnr.nextLine();
			if (read.equals("h")) {
				return "Hit";
			} else if (read.equals("s")) {
				return "Stand";
			} else if (read.equals("d")) {
				return "Double";
			}
			System.out.println("Wpisz poprawn¹ wartoœæ!");
		}
	}

}

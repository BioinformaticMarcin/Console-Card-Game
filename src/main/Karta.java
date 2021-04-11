package main;

public class Karta {
	private Integer wartosc;
	private String kolor;
	
	// Konstruktor - odwo�ania do setter�w
	public Karta(int numerWartosc, int numerKolor) {
		setWartosc(numerWartosc);
		setKolor(numerKolor);
	}
	
	public int getWartosc() {
		return wartosc;
	}
	
	// setter dla warto�ci - dla 11, 12 ,13 i 14 ustawia odpowiednio litery figur
	public void setWartosc(Integer figureNumer) {
		this.wartosc = figureNumer;
	}
	
	public String getKolor() {
		return kolor;
	}
	
	// podobnie jak z figur� - w zale�no�ci jaki numer podamy do metody taki kolor b�dzie miala karta
	public void setKolor(int colorNumer) {
		switch (colorNumer) {
		case 0:
			this.kolor = "PIK";
			break;
		case 1:
			this.kolor = "KIER";
			break;
		case 2:
			this.kolor = "TREFL";
			break;
		case 3:
			this.kolor = "KARO";
			break;
		}
	}
	
	// przeci��ona metoda toString z klasy Object zwraca sformatowane warto�ci w ci�gu znak�w
	@Override
	public String toString() {
		String val = "";
		switch (wartosc) {
		case 11:
			val = "J";
			break;
		case 12:
			val = "Q";
			break;
		case 13:
			val = "K";
			break;
		case 14:
			val = "A";
			break;
		default: // dla ka�dej innej zamieniam liczb� na Stringa i wstawiam do warto�ci
			val = wartosc.toString();
		}
		return String.format("Karta - kolor [%s] - warto�� [%s]", this.kolor, val);
	}
	
}

package main;

public class Karta {
	private String wartosc;
	private String kolor;
	
	// Konstruktor - odwo�ania do setter�w
	public Karta(int numerWartosc, int numerKolor) {
		setWartosc(numerWartosc);
		setKolor(numerKolor);
	}
	
	public String getWartosc() {
		return wartosc;
	}
	
	// setter dla warto�ci - dla 11, 12 ,13 i 14 ustawia odpowiednio litery figur
	public void setWartosc(Integer figureNumer) {
		switch (figureNumer) {
		case 11:
			this.wartosc = "J";
			break;
		case 12:
			this.wartosc = "Q";
			break;
		case 13:
			this.wartosc = "K";
			break;
		case 14:
			this.wartosc = "A";
			break;
		default: // dla ka�dej innej zamieniam liczb� na Stringa i wstawiam do warto�ci
			this.wartosc = figureNumer.toString();
		}
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
		return String.format("Karta - kolor [%s] - warto�� [%s]", this.kolor, this.wartosc);
	}
	
}

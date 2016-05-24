package model;

public class Produs {
	private String denumire;
	private double pret;
	public String getDenumire() {
		return denumire;
	}
	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}
	public double getPret() {
		return pret;
	}
	public void setPret(double pret) {
		this.pret = pret;
	}
	public Produs(String denumire, double pret) {
		super();
		this.denumire = denumire;
		this.pret = pret;
	}
	@Override
	public String toString() {
		return "Denumire produs: "+denumire+" | Pret:"+pret;
	}
	public Produs() {
	}
	
	public String getDenumireSiPret(){
		return denumire+" "+pret;
	}
	
	
}

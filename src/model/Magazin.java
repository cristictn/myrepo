package model;
import java.util.ArrayList;

import utils.MagazinListener;


public class Magazin {
	private static Magazin singleton=null;
	
	private ArrayList<Produs> produse = new ArrayList<Produs>();
	
	private ArrayList<MagazinListener> listeners = new ArrayList<>();
	private Magazin(){
		
	}
	
	public static synchronized Magazin getInstance(){
		if(singleton==null) 
			singleton=new Magazin();
		return singleton;
	}
	
	public void adaugaProdus(Produs p){
		produse.add(p);
		notifyMagazinListeners();
	}
	
	public ArrayList<Produs> getProduse(){
		return this.produse;
	}
	
	public void eliminaProdus(Produs p){
		produse.remove(p);
	}
	public void addMagazinListener(MagazinListener ml){
		listeners.add(ml);
	}
	
	public void removeMagazinListener(MagazinListener ml){
		listeners.remove(ml);
	}
	
	private void notifyMagazinListeners(){
		for(MagazinListener ml:listeners){
			ml.listaProduseModificata();
		}
	}
}

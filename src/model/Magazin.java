package model;
import java.util.ArrayList;

import utils.MagazinListener;


public class Magazin {
	private static Magazin singleton=null;
	
	private static ArrayList<Produs> produse = new ArrayList<Produs>();

	
	private static ArrayList<MagazinListener> listeners = new ArrayList<>();
	
	private Magazin(){
		
	}
	
	public static synchronized Magazin getInstance(){
		if(singleton==null) 
			singleton=new Magazin();
		return singleton;
	}
	
	public static void adaugaProdus(Produs p){
		if(p!=null) produse.add(p);
		else System.out.println("Produs NULL!");
		notifyMagazinListeners();
	}
	
	public ArrayList<Produs> getProduse(){
		return this.produse;
	}
	
	public static void eliminaProdus(Produs p){
		produse.remove(p);
	}
	public void addMagazinListener(MagazinListener ml){
		listeners.add(ml);
	}
	
	public void removeMagazinListener(MagazinListener ml){
		listeners.remove(ml);
	}
	
	private static void notifyMagazinListeners(){
		for(MagazinListener ml:listeners){
			ml.listaProduseModificata();
		}
	}
	
	public static int getLenghtArrayProduse()
	{
		return produse.size();
	}
	
	public static int getLenghtArrayListeners()
	{
		return listeners.size();
	}
	
}

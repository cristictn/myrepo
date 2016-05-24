package utils;

import model.Produs;

public class TestFactory {
	public static void main(String [] args){
		ProdusFactory produsFactory = new ProdusFactory();
		Produs produsA = produsFactory.getProdus("A");
		Produs produsB = produsFactory.getProdus("B");
		Produs produsC = produsFactory.getProdus("C");
		
		
		produsA.setDenumire("Produs A");
		produsB.setDenumire("Produs B");
		produsC.setDenumire("Produs C");

		System.out.println(produsA);
		System.out.println(produsB);
		System.out.println(produsC);
	}
}

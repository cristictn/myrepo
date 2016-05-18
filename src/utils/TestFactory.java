package utils;

import model.Produs;

public class TestFactory {
	public static void main(String [] args){
		ProdusFactory produsFactory = new ProdusFactory();
		Produs produsA = produsFactory.getProdus("A");
		Produs produsB = produsFactory.getProdus("B");
		Produs produsC = produsFactory.getProdus("C");

		System.out.println(produsA);c
		System.out.println(produsB);
		System.out.println(produsC);
	}
}

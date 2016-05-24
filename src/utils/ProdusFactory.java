package utils;

import model.Produs;
import model.ProdusA;
import model.ProdusB;
import model.ProdusC;

public class ProdusFactory {
//factory nu va fi folosit in aplicatie efectiv, este pur didactic
	public static Produs getProdus(String tipProdus) {
		if (tipProdus.equals("A"))
			return new ProdusA();
		else if (tipProdus.equals("B"))
			return new ProdusB();
		else if (tipProdus.equals("C"))
			return new ProdusC();
		else
			return null;
	}
}

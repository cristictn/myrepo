package testare;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Magazin;
import model.Produs;

public class MagazinTest {
	
	
	Produs p=new Produs();
	Magazin magazin = Magazin.getInstance();
	
	@Test
	public void testSingleTon(){
		assertEquals(Magazin.getInstance(), magazin);
	}


	@Test
	public void testAdaugaProdus()
	{
		int dimensiuneInainte=Magazin.getLenghtArrayProduse();
		Magazin.adaugaProdus(p);
		int dimensiuneDupa=Magazin.getLenghtArrayProduse();
		assertEquals(dimensiuneInainte+1,dimensiuneDupa);
	}
	
	@Test
	public void testStergereProdus()
	{
		int dimensiuneInainte=Magazin.getLenghtArrayProduse();
		Magazin.adaugaProdus(p);
		Magazin.eliminaProdus(p);
		int dimensiuneDupa=Magazin.getLenghtArrayProduse();
		assertEquals(dimensiuneInainte,dimensiuneDupa);
	}
	
}

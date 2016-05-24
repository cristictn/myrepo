package testare;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Magazin;
import model.Produs;

public class ProdusTest {
	
	Produs p = new Produs("paine",1.2);

	@Test
	public void testDenumireSiPret(){
		assertEquals(p.getDenumire()+" "+p.getPret(),p.getDenumireSiPret());

	}
	
	@Test
	public void testGetterDenumire(){
		assertEquals("paine", p.getDenumire());
	}
	
	
	@Test
	public void testSetDenumire()
	{
		p.setDenumire("covrigi");
		assertEquals("covrigi", p.getDenumire());
	}
	
	@Test
	public void testToString()
	{
		assertEquals("Denumire produs: paine | Pret:1.2", p.toString());
	}

}

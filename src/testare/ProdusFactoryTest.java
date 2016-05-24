package testare;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import model.Produs;
import model.ProdusA;
import utils.ProdusFactory;

public class ProdusFactoryTest {

	@Test
	public void testGetProdus() {
		Produs a=ProdusFactory.getProdus("A");
		ProdusA ab=new ProdusA();
		//Assert.assertSame(ab, a);
		Assert.assertNotSame(ab, a);
	}

}

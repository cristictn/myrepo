package testare;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MagazinTest.class, ProdusFactoryTest.class, ProdusTest.class, TestMainController.class })
public class TestSuite {

}

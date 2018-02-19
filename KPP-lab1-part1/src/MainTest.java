import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Main.arraySize = 100;
		Main.fillingArraySequentially();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
		Main.fillingArrayRandomly();
	}

	@Test
	public void testSearchPrimeNumbers() {
//		assertEquals(checkPrimeNumbers(), Main.searchPrimeNumbers());
	}

//	public String checkPrimeNumbers() {
//		String result = new String("");
//		for(int i = 0; i < Main.arraySize; i++) {
//			for (int j = 2; j <= i; j++) {
//	            if (i % j == 0) {
//	                continue;
//	            }
//	            if ((double)j > Math.sqrt((double)i)) {
//	            	result += i;
//	            	result += " ";
//	            }
//	        }
//			if(i == 2) {
//				result += i;
//            	result += " ";
//			}
//		}
//		return result;
//	}

}

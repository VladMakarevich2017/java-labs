package test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import application.Main;

public class MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Ignore
	@Test
	public void testMain() {
		System.out.println("* MainTest: Main()");
	}

	@Ignore
	@Test
	public void testShowMenu() {
		System.out.println("* MainTest: ShowMenu()");
	}

	@Test
	public void testFunctionSelection() {
		System.out.println("* MainTest: testFunctionSelection()");
		for(int i = -100000; i < 100000; i++) {
			if(i == 1 || i == 2 || i == 3) {
				assertTrue(Main.functionSelection(i));
				continue;
			}
			assertFalse(Main.functionSelection(i));
		}
	}

	@Ignore
	@Test
	public void testFillingArrayManually() {
		System.out.println("* MainTest: FillingArrayManually()");
	}

	@Ignore
	@Test
	public void testFillingArrayRandomly() {
		System.out.println("* MainTest: FillingArrayRandomly()");
	}

	@Ignore
	@Test
	public void testFillingArraySequentially() {
		System.out.println("* MainTest: FillingArraySequentially()");
	}

	@Ignore
	@Test
	public void testSearchPrimeNumbers() {
		System.out.println("* MainTest: SearchPrimeNumbers()");
	}

	@Test
	public void testPrimeNumber() {
		System.out.println("* MainTest: testPrimeNumber()");
		for(int i = -100000; i <= 1; i++) {
			assertFalse(Main.primeNumber(i));
		}
		assertEquals(Main.primeNumber(2), isPrime(2));
		assertEquals(Main.primeNumber(23), isPrime(23));
		assertEquals(Main.primeNumber(701), isPrime(701));
		assertEquals(Main.primeNumber(2789), isPrime(2789));
		assertEquals(Main.primeNumber(3571), isPrime(3571));
	}
	
	public boolean isPrime(int n) {
		boolean isPrime = true;
		if(n == 2) { return true;}
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
            	isPrime = false;
                break;
            }
        }
        return isPrime;
	}

}

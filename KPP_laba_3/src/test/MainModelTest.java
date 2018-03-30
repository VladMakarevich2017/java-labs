package test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.MainModel;

public class MainModelTest {
	
	private MainModel model = new MainModel();

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

	@Test
	public void testCalculateResultSpeed() {
		System.out.println("* MainModel: testCalculateResultSpeed()");
//		assertEquals(model.calculateResultSpeed(123, 123, 123, 123), 123);
//		assertEquals(model.calculateResultSpeed(100, 60, 90, 70), 82);
//		assertEquals(model.calculateResultSpeed(10, 130, 20, 100), 94);
//		assertEquals(model.calculateResultSpeed(1200, 1450, 250, 400), 332);
//		assertEquals(model.calculateResultSpeed(1, 2, 3, 4), 3);
	}
	
	@Test
	public void testIsValidation() {
		System.out.println("* MainModel: testIsValidation()");
//		String[] array;
//		array = new String({"asdasd", "123"});
//		assertFalse(model.isValidation(array));
//		array = new String({"123"});
		
	}

}

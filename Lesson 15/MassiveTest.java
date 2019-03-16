package Lesson15home_work;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MassiveTest {
	Massive massiv;
	
	
	@BeforeTest
    public void before() {
		massiv = new Massive();
    }

	@Test
	public void tesGetLastItem() {		
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int lastItem = massiv.getLastItem(array);
		Assert.assertEquals(lastItem, 91);
	}
	
	@Test
	public void tesGetLastItemOfSmallArray() {		
		int[] array = {10,20,30};
		int lastItem = massiv.getLastItem(array);
		Assert.assertEquals(lastItem, 30);
	}
	
	
	@Test
	public void tesGetLenght() {		
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int lenght = massiv.getLenght(array);
		Assert.assertEquals(lenght, 10);
	}
	
	@Test
	public void tesGetLenghtOfEmptyArray() {		
		int[] array = {};
		int lenght = massiv.getLenght(array);
		Assert.assertEquals(lenght, 0);
	}
	
	@Test
	public void tesGetLenghtOfEmptyMassiv() {		
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int lenght = massiv.getLenght(array);
		Assert.assertEquals(lenght, 10);
	}
	
	@Test
	public void tesGetFirstItem() {		
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int firstItem = massiv.getFirstItem(array);
		Assert.assertEquals(firstItem, 10);
	}
	
	@Test
	public void tesGetFirstItemOfSmallArray() {		
		int[] array = {10,20,30};
		int firstItem = massiv.getFirstItem(array);
		Assert.assertEquals(firstItem, 10);
	}

	@Test(enabled = false)
	public void testExeption() {		
		massiv.setLength("abc");
	}
	
	@Test(expectedExceptions = ExampleException.class)
	public void testMariaExeption() {		
		massiv.methodWithException();
	}

	@Test(enabled = false)
	public void testIgnore() {		
		massiv.setLength("abc");
	}
}

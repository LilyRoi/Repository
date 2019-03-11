package Lesson14home_work;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class MassiveTest {
	
	
	@Test
	public void tesGetLastItem() {
		Massive massiv = new Massive();
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int lastItem = massiv.getLastItem(array);
		assertEquals(lastItem, 91);
	}
	
	@Test
	public void tesGetLastItemOfSmallArray() {
		Massive massiv = new Massive();
		int[] array = {10,20,30};
		int lastItem = massiv.getLastItem(array);
		assertEquals(lastItem, 30);
	}
	
	
	@Test
	public void tesGetLenght() {
		Massive massiv = new Massive();
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int lenght = massiv.getLenght(array);
		assertEquals(lenght, 10);
	}
	
	@Test
	public void tesGetLenghtOfEmptyArray() {
		Massive massiv = new Massive();
		int[] array = {};
		int lenght = massiv.getLenght(array);
		assertEquals(lenght, 0);
	}
	
	@Test
	public void tesGetLenghtOfEmptyMassiv() {
		Massive massiv = new Massive();
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int lenght = massiv.getLenght(array);
		assertEquals(lenght, 10);
	}
	
	@Test
	public void tesGetFirstItem() {
		Massive massiv = new Massive();
		int[] array = {10,20,30,40,50,60,71,80,90,91};
		int firstItem = massiv.getFirstItem(array);
		assertEquals(firstItem, 10);
	}
	
	@Test
	public void tesGetFirstItemOfSmallArray() {
		Massive massiv = new Massive();
		int[] array = {10,20,30};
		int firstItem = massiv.getFirstItem(array);
		assertEquals(firstItem, 10);
	}

	@Test(expected = NumberFormatException.class)
	public void testExeption() {
		Massive massiv = new Massive();
		massiv.setLength("abc");
	}
	
	@Test(expected = MariaException.class)
	public void testMariaExeption() {
		Massive massiv = new Massive();
		massiv.methodWithException();
	}

	@Ignore
	@Test(expected = NumberFormatException.class)
	public void testIgnore() {
		Massive massiv = new Massive();
		massiv.setLength("abc");
	}
	
	
}

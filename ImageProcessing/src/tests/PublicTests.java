package tests;

import static org.junit.Assert.*;
import imageprocessing.Image;
import static imageprocessing.Image.*;

import org.junit.Test;

public class PublicTests {
	
	@Test
	public void mirrorArrayTest1() {
		String[][] colors =  {{"blue","red","orange","black"},
                              {"white","blue","red","black"}};
		String[][] expColors =  {{"black", "orange", "red", "blue"},
                                 {"black", "red", "blue", "white"}};
		mirrorArray(colors);
		assertArrayEquals(expColors, colors);
	}
	
	@Test
	public void mirrorArrayTest2() {
		String[][] letters =  {{"A","B","C","D","A"},
                              {"E","F","G","H"},
                              {"I","J","K"}};
		String[][] expLetters =  {{"A","D", "C", "B", "A"},
                                 {"H", "G", "F", "E"},
                                 {"K","J","I"}};
		mirrorArray(letters);
		assertArrayEquals(expLetters, letters);
	}

	@Test
	public void mirrorImageTest1() {
		Image img1 = new Image("images/deer.png");
		Image img2 = new Image("images/deer-mirror.png");
		img1.mirror();
		boolean r =img1.equals(img2); 
		assertTrue(r);
	}
	
}

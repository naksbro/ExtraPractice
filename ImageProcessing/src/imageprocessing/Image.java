/**
 * In this project, you will write code to process images.
 * Please read the README.pdf for for details.
 */

package imageprocessing;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import edu.princeton.cs.introcs.Picture;

public class Image {
	
	private Picture pic;	//picture object
	private int width;		//width of the image
	private int height;		//height of the image
	
	/**
	 * This constructor loads the image and updates width, height member variables
	 * 
	 * @param fileName:  image file name
	 */
	public Image(String fileName){
		pic = new Picture(fileName);
		height = pic.height();
		width = pic.width();
	}
	/**
	 * 
	 * @param obj: input image object
	 * @return true if this image is same as the image in obj 
	 */
	public boolean equals(Image obj){
		return pic.equals(obj.pic);
	}
	
	/**
	 * This task is a warm up to the next one.
	 * Method accepts a 2D String array then 
	 * mirror/reverse values in each inner array
	 * EX:
	 * 	String[][] colors =  {{"blue","red","orange","black"},
			                 {"white","blue","red","black"}};
		mirrorArray(colors) -> [black, orange, red, blue]
							   [black, red, blue, white]
	 * 
	 * 
	 * @param 2D array strArray
	 * @return 2D string array with each inner array values reversed/mirrored
	 *
	 * RUN MAIN METHOD BELOW IN THIS CLASS TO TEST YOUR IMPLEMENTATION
	 *
	 */
	public static void mirrorArray(String[][] strArray) {
		//TODO
		String[][] clrs = new String[strArray.length][strArray[0].length];

		for(int i = 0; i < strArray.length; i++) {			
			String str = "";
			int end = strArray[i].length - 1;
			for(int j = 0; j < strArray[i].length / 2; j++) {
				str = strArray[i][j];
				strArray[i][j] = strArray[i][end];
				strArray[i][end] = str;
				end--;
			}
		}
	}
	
	/**
	 * Implement the mirror method, in which you flip the image, referenced by the Picture 
	 * type variable pic. 
	 *  
	 *  pic variable has image already loaded.
	 *  		-> you can call pic.get(col,row) to get Color object of that pixel/position:
	 *  			Color pixelColor = pic.get(col,row);	
	 *  		-> you can set that color to the new pixel/position :
	 *  			pic.set(newColPosition,newRowPosition,pixelColor);
	 *  height variable has already count of rows in the picture
	 *  width variable has already count of columns in the picture
	 *  
	 *  You need to reverse/mirror colors for each row in the image.
	 *  
	 *  MORE Explanation:
	 *  For example:
	 *  pic.get(x,y) will return the color (Java Color class) of the pixel(x,y). 
	 *  pixel (x, y) is column x and row y, where (0, 0) is upper left
	 *  pic.set(x,y,color) will update the color of the pixel(x,y). 
	 * 
	 *RUN MAIN METHOD BELOW IN THIS CLASS TO TEST YOUR IMPLEMENTATION
	 * 
	 */
	public void mirror(){
		//TODO PLEASE READ INSTRUCTIONS CAREFULLY
		//PLEASE USE pic, width, height VARIABLES. THEY ARE READY WITH VALUES!
			for(int i = 0; i < this.height; i++) {
			int index = this.width - 1;
			for(int j = 0; j < width/2; j++) {
				Color save = pic.get(j, i);
				pic.set(j, i, pic.get(index, i));
				pic.set(index, i, save);
				index--;
			}
		}
	}
	
	public void changeColor() {
		String fileName = "images/team.jpg";
		String fileNameNew = "images/team-mirror.jpg";
		File file = new File(fileNameNew);
		Image img = new Image(fileName);
		Image img_old = new Image(fileName);
		System.out.println("Width:"+ img.width);
		System.out.println("Height:"+ img.height);
		img_old.pic.show();
		img.mirror();
		img.pic.show();
		img.pic.save(file);
	}
	
	public static void main(String[] args) throws IOException{
		String fileName = "images/team.jpg";
		String fileNameNew = "images/team-mirror.team";
		File file = new File(fileNameNew);

		
		Image img = new Image(fileName);
		Image img_old = new Image(fileName);
		
		System.out.println("Width:"+ img.width);
		System.out.println("Height:"+ img.height);
		
		img_old.pic.show();
		
		
		img.mirror();
		img.pic.show();
		img.pic.save(file);
		
		String[][] arr = {{"blue","red","orange","black"},
			              {"white","blue","red","black"}};
		mirrorArray(arr);
		for (String[] strings : arr) {
			System.out.println(Arrays.toString(strings));
		}
	}
}

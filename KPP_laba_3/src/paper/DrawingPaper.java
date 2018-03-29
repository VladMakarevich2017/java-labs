package paper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class describing drawing paper. 
 * Extends from class paper
 * @author VladMakarevich
 *
 */

public class DrawingPaper extends Paper {
	public void writeDownContent() throws IOException {
		FileReader fr = new FileReader("drawing.txt");
		Scanner scan = new Scanner(fr);
		content = scan.nextLine();
		fr.close();
	}
}

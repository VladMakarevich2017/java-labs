package paper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class describing photo paper. 
 * Extends from class paper
 * @author VladMakarevich
 *
 */

public class PhotoPaper extends Paper {
	public void writeDownContent() throws IOException {
		FileReader fr = new FileReader("./database/photo.txt");
		Scanner scan = new Scanner(fr);
		content = scan.nextLine();
		fr.close();
	}

}

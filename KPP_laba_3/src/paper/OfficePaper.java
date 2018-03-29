package paper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class describing office paper. 
 * Extends from class paper
 * @author VladMakarevich
 *
 */

public class OfficePaper extends Paper {
	public void writeDownContent() throws IOException {
		FileReader fr = new FileReader("office.txt");
		Scanner scan = new Scanner(fr);
		content = scan.nextLine();
		fr.close();
	}

}

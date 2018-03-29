package printer;

import paper.Paper;

public class Xerox extends Printer {
	private String buffer;
	
	public Xerox() {
		buffer = "";
	}
	
	public void scanPaper(Paper paper) {
		buffer = paper.getContent();
		if(buffer == "") {
			try {
				throw new Exception();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer;
	}

}

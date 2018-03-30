package printer;

import paper.DrawingPaper;
import paper.Paper;

public class Xerox extends Printer {
	private double width;
	private double length;
	private String buffer;
	private DrawingPaper drawingPaper;
	
	public Xerox() {
		buffer = "";
		drawingPaper = new DrawingPaper();
	}
	
	public Xerox(DrawingPaper paper) {
		setDrawingPaper(paper);
	}
	
	public void scanPaper(Paper paper) {
		buffer = paper.getContent();
		width = paper.getWidth();
		length = paper.getLength();
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

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public DrawingPaper getDrawingPaper() {
		return drawingPaper;
	}

	public void setDrawingPaper(DrawingPaper drawingPaper) {
		this.drawingPaper = drawingPaper;
	}

}
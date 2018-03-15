package application;

import java.util.Random;

import paper.Paper;

public class Printer {
	
	private Paper officePaper;
	private Paper photoPaper;
	Random rnd;
	
	public Printer() {
		rnd = new Random(System.currentTimeMillis()); 
	}
	
	public void setPaper(Paper paper1, Paper paper2) {
		this.officePaper = paper1;
		this.setPhotoPaper(paper2);
	}
	
	public void printText() {
		officePaper.setLength(70 + rnd.nextInt(30));
		officePaper.setWidth(10 + rnd.nextInt(50));
	}
	
	public void printImage() {
		photoPaper.setLength(70 + rnd.nextInt(30));
		photoPaper.setWidth(10 + rnd.nextInt(50));
	}

	public Paper getPhotoPaper() {
		return photoPaper;
	}

	public void setPhotoPaper(Paper photoPaper) {
		this.photoPaper = photoPaper;
	}

	public Paper getOfficePaper() {
		return officePaper;
	}

	public void setOfficePaper(Paper officePaper) {
		this.officePaper = officePaper;
	}
	
	
	
	

}

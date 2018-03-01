package domain;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Catalog implements Serializable{
	private ArrayList<Document> documents;
	private ArrayList<Book> books;
	private ArrayList<Audio> audio;
	private ArrayList<Video> video;
	
	public Catalog() {
		documents = new ArrayList<Document>();
		books = new ArrayList<Book>();
		audio = new ArrayList<Audio>();
		video = new ArrayList<Video>();
	}
	
	public void addDocument(Document document) {
		documents.add(document);
	}
	
	public void addBook(Book book) {
		books.add(book);
	}
	
	public void addAudio(Audio audio) {
		this.audio.add(audio);
	}
	
	public void addVideo(Video video) {
		this.video.add(video);
	}
	
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	
	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}
	
	public ArrayList<Book> getBooks() {
		return books;
	}
	
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}
	
	public ArrayList<Audio> getAudio() {
		return audio;
	}
	
	public void setAudio(ArrayList<Audio> audio) {
		this.audio = audio;
	}
	
	public ArrayList<Video> getVideo() {
		return video;
	}
	
	public void setVideo(ArrayList<Video> video) {
		this.video = video;
	}
}

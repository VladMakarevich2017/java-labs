package domain;

import java.io.Serializable;
import java.util.Vector;

@SuppressWarnings("serial")
public class Catalog implements Serializable{
	private Vector<Document> documents;
	private Vector<Book> books;
	private Vector<Audio> audio;
	private Vector<Video> video;
	private String name;
	
	public Catalog(String name) {
		documents = new Vector<Document>();
		books = new Vector<Book>();
		audio = new Vector<Audio>();
		video = new Vector<Video>();
		this.name = name;
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
	
	public Vector<Document> getDocuments() {
		return documents;
	}
	
	public void setDocuments(Vector<Document> documents) {
		this.documents = documents;
	}
	
	public Vector<Book> getBooks() {
		return books;
	}
	
	public void setBooks(Vector<Book> books) {
		this.books = books;
	}
	
	public Vector<Audio> getAudio() {
		return audio;
	}
	
	public void setAudio(Vector<Audio> audio) {
		this.audio = audio;
	}
	
	public Vector<Video> getVideo() {
		return video;
	}
	
	public void setVideo(Vector<Video> video) {
		this.video = video;
	}
}

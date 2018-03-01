package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileConnection{
	private FileInputStream reader;
	private FileOutputStream writer;
	private String path;
	
	public FileConnection(String path) throws FileNotFoundException {
		this.path = path;
		reader = new FileInputStream(path);
		writer = new FileOutputStream(path);
	}

	public FileInputStream getReader() {
		return reader;
	}

	public void setReader(FileInputStream reader) {
		this.reader = reader;
	}

	public FileOutputStream getWriter() {
		return writer;
	}

	public void setWriter(FileOutputStream writer) {
		this.writer = writer;
	}
}

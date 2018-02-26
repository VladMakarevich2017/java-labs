package dao;

import java.util.List;

import domain.Book;

/** ������ ��� ���������� ������������� ���������� ������� Book */
public interface BookDao {
	/** ������� ����� ������ � ��������������� �� ������ */
	public Book create();

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public Book read(int key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(Book group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(Book group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public List<Book> getAll();
}

package dao;

import java.util.List;

import domain.Document;

/** ������ ��� ���������� ������������� ���������� ������� Document */
public interface DocumentDao {
	/** ������� ����� ������ � ��������������� �� ������ */
	public Document create();

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public Document read(int key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(Document group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(Document group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public List<Document> getAll();
}

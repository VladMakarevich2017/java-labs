package dao;

import java.util.Vector;

import domain.Catalog;

public interface CatalogDao {
	/** ������� ����� ������ � ��������������� �� ������ */
    public Catalog create(String name);

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public Catalog read(int key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(Catalog group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(Catalog group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public Vector<Catalog> getAll();
}

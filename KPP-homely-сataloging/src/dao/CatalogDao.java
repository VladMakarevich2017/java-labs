package dao;

import java.util.ArrayList;

import domain.Catalog;

public interface CatalogDao {
	/** ������� ����� ������ � ��������������� �� ������ */
    public Catalog create();

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public Catalog read(int key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(Catalog group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(Catalog group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public ArrayList<Catalog> getAll();
}

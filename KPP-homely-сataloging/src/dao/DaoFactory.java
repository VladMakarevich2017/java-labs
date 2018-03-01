package dao;

import file.FileConnection;

public interface DaoFactory {

    /** ���������� ����������� � ���� ������ */
    public FileConnection getConnection();

    /** ���������� ������ ��� ���������� ������������� ���������� ������� Group */
    public CatalogDao getCatalogDao(FileConnection connection);

}

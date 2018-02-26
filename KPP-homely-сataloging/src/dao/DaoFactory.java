package dao;

import file.FileConnection;

/** ������� �������� ��� ������ � ����� ������ */
public interface DaoFactory {

    /** ���������� ����������� � ���� ������ */
    public FileConnection getConnection();

    /** ���������� ������ ��� ���������� ������������� ���������� ������� Document */
    public DocumentDao getDocumentDao(FileConnection connection);

    /** ���������� ������ ��� ���������� ������������� ���������� ������� Book */
    public BookDao getBookDao(FileConnection connection);
    
    /** ���������� ������ ��� ���������� ������������� ���������� ������� Book */
    public AudioDao getAudioDao(FileConnection connection);
    
    /** ���������� ������ ��� ���������� ������������� ���������� ������� Book */
    public VideoDao getVideoDao(FileConnection connection);
}

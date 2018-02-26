package dao;

import java.util.List;

import domain.Video;

/** ������ ��� ���������� ������������� ���������� ������� Video */
public interface VideoDao {
	/** ������� ����� ������ � ��������������� �� ������ */
	public Video create();

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public Video read(int key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(Video group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(Video group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public List<Video> getAll();
}

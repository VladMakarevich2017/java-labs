package dao;

import java.util.List;

import domain.Audio;

/** ������ ��� ���������� ������������� ���������� ������� Audio */
public interface AudioDao {
	/** ������� ����� ������ � ��������������� �� ������ */
	public Audio create();

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public Audio read(int key);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(Audio group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(Audio group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public List<Audio> getAll();
}

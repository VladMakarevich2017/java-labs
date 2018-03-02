package dao;

import java.util.Vector;

import visitors.User;

public interface UserDao {
	/** ������� ����� ������ � ��������������� �� ������ */
    public User create(String login, String password);

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null */
    public User read(String login, String password);

    /** ��������� ��������� ������� group � ���� ������ */
    public void update(User group);

    /** ������� ������ �� ������� �� ���� ������ */
    public void delete(User group);

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ */
    public Vector<User> getAll();
}

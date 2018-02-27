package dao;

import java.io.Serializable;
import java.util.List;

import exeptionhandler.PersistException;

/**
 * ��������������� ��������� ���������� ������������� ���������� ��������
 * @param <T> ��� ������� ������������
 * @param <PK> ��� ���������� �����
 */
public interface GenericDao<T, PK extends Serializable> {
    /** ������� ����� ������, ��������������� ������� object 
     * @throws PersistException */
    public T persist(T object) throws PersistException;

    /** ���������� ������ ��������������� ������ � ��������� ������ key ��� null 
     * @throws PersistException */
    public T getByPK(int key) throws PersistException;

    /** ��������� ��������� ������� group � ���� ������ 
     * @throws PersistException */
    public void update(T object) throws PersistException;

    /** ������� ������ �� ������� �� ���� ������ 
     * @throws PersistException */
    public void delete(T object) throws PersistException;

    /** ���������� ������ �������� ��������������� ���� ������� � ���� ������ 
     * @throws PersistException */
    public List<T> getAll() throws PersistException;
}
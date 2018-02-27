package dao;

import java.io.Serializable;
import java.util.List;

import exeptionhandler.PersistException;

/**
 * Унифицированный интерфейс управления персистентным состоянием объектов
 * @param <T> тип объекта персистенции
 * @param <PK> тип первичного ключа
 */
public interface GenericDao<T, PK extends Serializable> {
    /** Создает новую запись, соответствующую объекту object 
     * @throws PersistException */
    public T persist(T object) throws PersistException;

    /** Возвращает объект соответствующий записи с первичным ключом key или null 
     * @throws PersistException */
    public T getByPK(int key) throws PersistException;

    /** Сохраняет состояние объекта group в базе данных 
     * @throws PersistException */
    public void update(T object) throws PersistException;

    /** Удаляет запись об объекте из базы данных 
     * @throws PersistException */
    public void delete(T object) throws PersistException;

    /** Возвращает список объектов соответствующих всем записям в базе данных 
     * @throws PersistException */
    public List<T> getAll() throws PersistException;
}
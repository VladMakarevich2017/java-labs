package dao;

import java.util.ArrayList;

import domain.Catalog;

public interface CatalogDao {
	/** Создает новую запись и соответствующий ей объект */
    public Catalog create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Catalog read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Catalog group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Catalog group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public ArrayList<Catalog> getAll();
}

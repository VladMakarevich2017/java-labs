package dao;

import java.util.List;

import domain.Document;

/** Объект для управления персистентным состоянием объекта Document */
public interface DocumentDao {
	/** Создает новую запись и соответствующий ей объект */
	public Document create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Document read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Document group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Document group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Document> getAll();
}

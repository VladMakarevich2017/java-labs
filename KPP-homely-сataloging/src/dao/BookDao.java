package dao;

import java.util.List;

import domain.Book;

/** Объект для управления персистентным состоянием объекта Book */
public interface BookDao {
	/** Создает новую запись и соответствующий ей объект */
	public Book create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Book read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Book group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Book group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Book> getAll();
}

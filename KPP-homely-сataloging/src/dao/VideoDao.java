package dao;

import java.util.List;

import domain.Video;

/** Объект для управления персистентным состоянием объекта Video */
public interface VideoDao {
	/** Создает новую запись и соответствующий ей объект */
	public Video create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Video read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Video group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Video group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Video> getAll();
}

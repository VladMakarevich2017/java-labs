package dao;

import java.util.List;

import domain.Audio;

/** Объект для управления персистентным состоянием объекта Audio */
public interface AudioDao {
	/** Создает новую запись и соответствующий ей объект */
	public Audio create();

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public Audio read(int key);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(Audio group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(Audio group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public List<Audio> getAll();
}

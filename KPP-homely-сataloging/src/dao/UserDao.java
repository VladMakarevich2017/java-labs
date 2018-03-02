package dao;

import java.util.Vector;

import visitors.User;

public interface UserDao {
	/** Создает новую запись и соответствующий ей объект */
    public User create(String login, String password);

    /** Возвращает объект соответствующий записи с первичным ключом key или null */
    public User read(String login, String password);

    /** Сохраняет состояние объекта group в базе данных */
    public void update(User group);

    /** Удаляет запись об объекте из базы данных */
    public void delete(User group);

    /** Возвращает список объектов соответствующих всем записям в базе данных */
    public Vector<User> getAll();
}

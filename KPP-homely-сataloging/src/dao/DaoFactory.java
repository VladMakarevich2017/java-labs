package dao;

import file.FileConnection;

public interface DaoFactory {

    /** Возвращает подключение к базе данных */
    public FileConnection getConnection();

    /** Возвращает объект для управления персистентным состоянием объекта Group */
    public CatalogDao getCatalogDao(FileConnection connection);

}

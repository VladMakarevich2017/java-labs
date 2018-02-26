package dao;

import file.FileConnection;

/** Фабрика объектов для работы с базой данных */
public interface DaoFactory {

    /** Возвращает подключение к базе данных */
    public FileConnection getConnection();

    /** Возвращает объект для управления персистентным состоянием объекта Document */
    public DocumentDao getDocumentDao(FileConnection connection);

    /** Возвращает объект для управления персистентным состоянием объекта Book */
    public BookDao getBookDao(FileConnection connection);
    
    /** Возвращает объект для управления персистентным состоянием объекта Book */
    public AudioDao getAudioDao(FileConnection connection);
    
    /** Возвращает объект для управления персистентным состоянием объекта Book */
    public VideoDao getVideoDao(FileConnection connection);
}

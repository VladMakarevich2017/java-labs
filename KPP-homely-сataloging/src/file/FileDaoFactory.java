package file;

import dao.CatalogDao;
import dao.DaoFactory;

public class FileDaoFactory implements DaoFactory{
	private String user = "root";//Логин пользователя
    private String password = "";//Пароль пользователя
    private String url = "jdbc:mysql://localhost:3306/daotalk";//URL адрес
    private String driver = "com.mysql.jdbc.Driver";//Имя драйвера
	
    public FileDaoFactory() {
//        try {
//            Class.forName(driver);//Регистрируем драйвер
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
	
	@Override
	public FileConnection getConnection() {
//	       return DriverManager.getConnection(url, user, password);
		return null;
	}

	@Override
	public CatalogDao getCatalogDao(FileConnection connection) {
        return new FileCatalogDao(connection);
	}

}

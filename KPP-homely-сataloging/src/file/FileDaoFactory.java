package file;

import dao.CatalogDao;
import dao.DaoFactory;

public class FileDaoFactory implements DaoFactory{
	private String user = "root";//����� ������������
    private String password = "";//������ ������������
    private String url = "jdbc:mysql://localhost:3306/daotalk";//URL �����
    private String driver = "com.mysql.jdbc.Driver";//��� ��������
	
    public FileDaoFactory() {
//        try {
//            Class.forName(driver);//������������ �������
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
	
	@Override
	public FileConnection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CatalogDao getCatalogDao(FileConnection connection) {
		// TODO Auto-generated method stub
		return null;
	}

}

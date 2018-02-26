package file;

import dao.AudioDao;
import dao.BookDao;
import dao.DaoFactory;
import dao.DocumentDao;
import dao.VideoDao;

public class FileDaoFactory implements DaoFactory {

    private String user = "root";//����� ������������
    private String password = "";//������ ������������
    private String url = "jdbc:mysql://localhost:3306/daotalk";//URL �����
    private String driver = "com.mysql.jdbc.Driver";//��� ��������

    public FileConnection getConnection(){
        return null;
    }

    public FileDaoFactory() {
        try {
            Class.forName(driver);//������������ �������
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	@Override
	public DocumentDao getDocumentDao(FileConnection connection) {
		return null;
	}

	@Override
	public BookDao getBookDao(FileConnection connection) {
		return null;
	}

	@Override
	public AudioDao getAudioDao(FileConnection connection) {
		return null;
	}

	@Override
	public VideoDao getVideoDao(FileConnection connection) {
		return null;
	}
}
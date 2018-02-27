package dao;

import domain.Audio;
import file.AbstractJDBCDao;
import file.FileConnection;

public class AudioDao extends AbstractJDBCDao<Audio, Integer> {

	public AudioDao(FileConnection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getSelectQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCreateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUpdateQuery() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeleteQuery() {
		// TODO Auto-generated method stub
		return null;
	}

}

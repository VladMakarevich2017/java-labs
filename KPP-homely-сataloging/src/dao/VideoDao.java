package dao;

import domain.Video;
import file.AbstractJDBCDao;
import file.FileConnection;

public class VideoDao extends AbstractJDBCDao<Video, Integer> {

	public VideoDao(FileConnection connection) {
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

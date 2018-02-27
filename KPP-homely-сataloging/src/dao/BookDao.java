package dao;

import domain.Book;
import file.AbstractJDBCDao;
import file.FileConnection;

public class BookDao extends AbstractJDBCDao<Book, Integer> {

	public BookDao(FileConnection connection) {
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

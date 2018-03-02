package file;

import java.util.Vector;

import dao.UserDao;
import visitors.User;

public class FileUserDao implements UserDao{
	private final FileConnection connection;
	private final String catalogPath = "config/users/";
	
	public FileUserDao(FileConnection connection) {
        this.connection = connection;
    }

	@Override
	public User create(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User read(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vector<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

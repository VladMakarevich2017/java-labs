package file;

import java.util.List;

import dao.DocumentDao;
import domain.Document;

public class FileDocumentDao implements DocumentDao {
    private final FileConnection connection;
    
    public FileDocumentDao(FileConnection connection) {
        this.connection = connection;
    }

    @Override
    public Document read(int key) {
//        String sql = "SELECT * FROM daotalk.Group WHERE id = ?;";
//        PreparedStatement stm = connection.prepareStatement(sql);
//
//        stm.setInt(1, key);
//
//        ResultSet rs = stm.executeQuery();
//        rs.next();
//        Group g = new Group();
//        g.setId(rs.getInt("id"));
//        g.setNumber(rs.getInt("number"));
//        g.setDepartment(rs.getString("department"));
//        return g;
    }

    @Override
    public List<Document> getAll() {
//        String sql = "SELECT * FROM daotalk.Group;";
//        PreparedStatement stm = connection.prepareStatement(sql);
//        ResultSet rs = stm.executeQuery();
//        List<Group> list = new ArrayList<Group>();
//        while (rs.next()) {
//            Group g = new Group();
//            g.setId(rs.getInt("id"));
//            g.setNumber(rs.getInt("number"));
//            g.setDepartment(rs.getString("department"));
//            list.add(g);
//        }
//        return list;
    }

	@Override
	public Document create() {
		return null;
	}

	@Override
	public void update(Document group) {
	}

	@Override
	public void delete(Document group) {
	}
}

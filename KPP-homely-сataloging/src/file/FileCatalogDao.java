package file;

import java.util.ArrayList;

import dao.CatalogDao;
import domain.Catalog;

public class FileCatalogDao implements CatalogDao {
	private final FileConnection connection;
	
	public FileCatalogDao(FileConnection connection) {
        this.connection = connection;
    }

	@Override
    public Catalog create() {
        return null;
    }

    @Override
    public Catalog read(int key) {
//        String sql = "SELECT * FROM daotalk.Catalog WHERE id = ?;";
//        PreparedStatement stm = connection.prepareStatement(sql);
//
//        stm.setInt(1, key);
//
//        ResultSet rs = stm.executeQuery();
//        rs.next();
//        Catalog g = new Catalog();
//        g.setId(rs.getInt("id"));
//        g.setNumber(rs.getInt("number"));
//        g.setDepartment(rs.getString("department"));
//        return g;
    	return null;
    }

    @Override
    public void update(Catalog group) {

    }

    @Override
    public void delete(Catalog group) {

    }

    @Override
    public ArrayList<Catalog> getAll() {
//        String sql = "SELECT * FROM daotalk.Catalog;";
//        PreparedStatement stm = connection.prepareStatement(sql);
//        ResultSet rs = stm.executeQuery();
//        List<Catalog> list = new ArrayList<Catalog>();
//        while (rs.next()) {
//            Catalog g = new Catalog();
//            g.setId(rs.getInt("id"));
//            g.setNumber(rs.getInt("number"));
//            g.setDepartment(rs.getString("department"));
//            list.add(g);
//        }
//        return list;
    	return null;
    }

}

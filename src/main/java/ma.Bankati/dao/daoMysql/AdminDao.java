package ma.Bankati.dao.daoMysql;

import dao.IDao;

import java.sql.Connection;
import java.util.List;

public class AdminDao  implements IDao <AdminDao , Long> {

    private Connection connection;
    public   AdminDao(Connection connection){this.connection=connection;}
    @Override
    public AdminDao trouverParId(Long aLong) {
        return null;
    }

    @Override
    public List<AdminDao> findAll() {
        return null;
    }

    @Override
    public AdminDao save(AdminDao adminDao) {
        return null;
    }

    @Override
    public AdminDao update(AdminDao adminDao) {
        return null;
    }

    @Override
    public Boolean delete(AdminDao adminDao) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}

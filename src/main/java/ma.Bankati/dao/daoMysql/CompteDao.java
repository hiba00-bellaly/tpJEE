package ma.Bankati.dao.daoMysql;

import dao.IDao;

import java.sql.Connection;
import java.util.List;

public class CompteDao  implements IDao<CompteDao , Long> {

    private Connection connection;
    public  CompteDao(Connection connection){this.connection=connection;}
    @Override
    public CompteDao trouverParId(Long aLong) {
        return null;
    }

    @Override
    public List<CompteDao> findAll() {
        return null;
    }

    @Override
    public CompteDao save(CompteDao compteDao) {
        return null;
    }

    @Override
    public CompteDao update(CompteDao compteDao) {
        return null;
    }

    @Override
    public Boolean delete(CompteDao compteDao) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}

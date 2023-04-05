package ma.Bankati.dao.daoMysql;

import dao.IDao;

import java.sql.Connection;
import java.util.List;

public class BanqueDao implements IDao <BanqueDao, Long>  {

    private Connection connection;
    public  BanqueDao(Connection connection){this.connection=connection;}
    @Override
    public BanqueDao trouverParId(Long aLong) {
        return null;
    }

    @Override
    public List<BanqueDao> findAll() {
        return null;
    }

    @Override
    public BanqueDao save(BanqueDao banqueDao) {
        return null;
    }

    @Override
    public BanqueDao update(BanqueDao banqueDao) {
        return null;
    }

    @Override
    public Boolean delete(BanqueDao banqueDao) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}

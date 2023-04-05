package ma.Bankati.dao.daoMysql;

import dao.IDao;

import java.sql.Connection;
import java.util.List;

public class ClientDao implements IDao<ClientDao, Long> {

    private Connection connection;
    public  ClientDao(Connection connection){this.connection=connection;}
    @Override
    public ClientDao trouverParId(Long aLong) {
        return null;
    }

    @Override
    public List<ClientDao> findAll() {
        return null;
    }

    @Override
    public ClientDao save(ClientDao clientDao) {
        return null;
    }

    @Override
    public ClientDao update(ClientDao clientDao) {
        return null;
    }

    @Override
    public Boolean delete(ClientDao clientDao) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }
}

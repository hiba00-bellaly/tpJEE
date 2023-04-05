package ma.Bankati.dao;

import model.Credit;

import java.sql.Connection;
import java.util.List;


public class CreditDao implements IDao <Credit, Long> {
    private Connection connection;
    public  CreditDao(Connection connection){this.connection=connection;}


    public Credit trouverParId(Long id){

        return null;
    }

    @Override
    public List<Credit> findAll() {
        return null;
    }

    @Override
    public Credit save(Credit credit) {
        return null;
    }

    @Override
    public Credit update(Credit credit) {
        return null;
    }

    @Override
    public Boolean delete(Credit credit) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }


}


package ma.Bankati.dao;


import dao.DaoExceptions.DaoConfigException;
import dao.daoMysql.AdminDao;
import dao.daoMysql.BanqueDao;
import dao.daoMysql.ClientDao;
import dao.daoMysql.CompteDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FactoryMysql  {
    private static  String PROPERTIES_FILE = "dao/dao.properties",
                           URL             = "SDB_Url",
                           DB              = "DB_Name",
                           DRIVER      = "SDB_Driver",
                           LOGIN       = "SDB_login",
                           PASS        = "SDB_pass";

    private static FactoryMysql INSTANCE;

    static {
        try {
            INSTANCE = getInstance();
        } catch (DaoConfigException e) {
            throw new RuntimeException(e);
        }
    }


    private static Connection connection;

    private String url, login , pass ;

    private FactoryMysql(String url, String login , String pass)throws SQLException {
        this.url= url;
        this.login= login;
        this.pass=pass;
        connection = DriverManager.getConnection(url, login,pass);

    }

    public static FactoryMysql getInstance() throws DaoConfigException {
        FactoryMysql instance= null;
        String property_Url, property_DBname, property_Login,proprty_Pass,property_Driver;
        Properties properties= new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);
        if (propertiesFile== null) throw new DaoConfigException(PROPERTIES_FILE+ "est introuvable");
        else {
            try {
                properties.load(propertiesFile);
                property_Url = properties.getProperty(URL);
                property_DBname = properties.getProperty(DB);
                property_Login = properties.getProperty(LOGIN);
                proprty_Pass = properties.getProperty(PASS);
                property_Driver = properties.getProperty(DRIVER);
                propertiesFile.close();
                Class.forName(property_Driver);

                property_Url= property_Url + "/"+ property_DBname;
                instance= new FactoryMysql(property_Url,property_Login,proprty_Pass);
                System.out.println("["+ property_DBname+"] ready ");


            }catch (IOException e) {}
            catch (ClassNotFoundException e){} catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                properties.clear();

            }
        }

        return instance;
    }

    public static Connection getConnection() throws DaoConfigException {
        if (connection==null) INSTANCE = getInstance();
        return connection;
    }

    public static void classConnection(){
        if (connection != null ){
            try {
                if (!connection.isClosed()) connection.close();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public IDao<ClientDao, Long> getClientDao() throws DaoConfigException {return new ClientDao(getConnection());}
    public IDao<CompteDao, Long> getCompteDao() throws DaoConfigException {return new CompteDao(getConnection());}
    public IDao<AdminDao, Long> getAdminDao() throws DaoConfigException {return new AdminDao(getConnection());}
    public IDao<BanqueDao, Long> getBanqueDao() throws DaoConfigException {return new BanqueDao(getConnection());}
    public CreditDao getCreditDao() throws DaoConfigException {return new CreditDao(getConnection());}

    }


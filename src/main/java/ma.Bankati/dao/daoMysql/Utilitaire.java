package ma.Bankati.dao.daoMysql;

import java.sql.*;

public class Utilitaire {


    public  static PreparedStatement initPS(Connection Cnx , String SQl , boolean generateKey, Object ...Columns)throws SQLException {
        PreparedStatement Ps = null;
        Ps = Cnx.prepareStatement(SQl , generateKey ? Statement.RETURN_GENERATED_KEYS: Statement.NO_GENERATED_KEYS);
        for (int i=0 ; i< Columns.length; i++)
            Ps.setObject(i+1, Columns[i]);
        return Ps;
    }

    public static void closeDAOObjets(ResultSet RS){
        try {
            if (RS != null) RS.close();
        } catch (SQLException e){
            System.out.println("Problem while closing ResultSet : ("+ e.getMessage()+")");
        }
    }



    public static void closeDAOObjets(PreparedStatement Ps) {
        try {
            if (Ps != null) Ps.close();

        } catch (SQLException e) {
            System.out.println("Problem while closing Statement : (" + e.getMessage());
        }
    }


        public static void closeDAOObjets(Connection cnx){
            try {
                if (cnx != null) {
                    cnx.close();
                }
            } catch (SQLException e) {
                System.out.println("Problem while closing Statement : (" + e.getMessage() + ")");
            }
        }


        public static  void closeDaoObjets(ResultSet Rs, PreparedStatement Ps, Connection cnx ){
        closeDAOObjets(Rs);closeDAOObjets(Ps); closeDAOObjets(cnx);
        }

        public static void closeDaoObjets(ResultSet Rs,PreparedStatement Ps){
        closeDAOObjets(Rs); closeDAOObjets(Ps);
        }





}

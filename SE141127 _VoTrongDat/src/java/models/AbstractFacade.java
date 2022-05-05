//SE141127 Vo Trong Dat
package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractFacade<T> {

    static String url = "jdbc:sqlserver://localhost;databaseName=Test2;user=sa;password=votrongdat68";

    public AbstractFacade() {
        try {
            //Loading a driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //CRUD
    protected abstract List<T> readAll(Connection con) throws SQLException;

    protected abstract void create(Connection con, T t) throws SQLException;

    protected abstract T read(Connection con, Object id) throws SQLException;//chua code

    protected abstract void update(Connection con, T t) throws SQLException;

    protected abstract void delete(Connection con, Object id) throws SQLException;

    public List<T> readAll() {
        List<T> list = new ArrayList<>();
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(url);
            //Executing the stm
            list = readAll(con);
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return list;
    }

    public T read(Object id) {
        T t = null;
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(url);
            //Executing the stm
            t = read(con, id);// chua coe{adasdas}
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return t;
    }

    public void create(T t) throws SQLException {
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(url);
            //Executing the stm
            create(con, t);
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            throw new SQLException(ex.getMessage());
        }
    }

    public void update(T t) {
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(url);
            //Executing the stm
            update(con, t);
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public void delete(Object id) throws Exception {
        try {
            //Connecting to a database
            Connection con = DriverManager.getConnection(url);
            //Executing the stm
            delete(con, id);
            //Closing the connection
            con.close();
        } catch (SQLException ex) {
            System.out.println("Exception: " + ex.getMessage());
            throw new Exception(ex.getMessage());
        }
    }

}

//SE141127 Vo Trong Dat
package models;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class EmployeeFacade extends AbstractFacade<Employee>{
    @Override
    protected List<Employee> readAll(Connection con) throws SQLException {
        List<Employee> list = new ArrayList<>();        
        String sql = "select * from Employee";
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        //Loading data into the list            
        while (rs.next()) {
            Employee employee = new Employee();
            employee.setId(rs.getString("id"));
            employee.setName(rs.getString("name"));
            employee.setSalary(rs.getBigDecimal("Salary"));
            employee.setDOB(rs.getDate("DOB"));
            list.add(employee);
        }
        return list;
    }

    @Override
    protected void create(Connection con, Employee employee) throws SQLException {
        String sql = "insert into Employee values(?, ?, ?, ?)";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, employee.getId());
        stm.setString(2, employee.getName());
        stm.setBigDecimal(3, employee.getSalary()); 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(4, df.format(employee.getDOB()));
        if(stm.executeUpdate() != 1){
            try {
                throw new Exception();
            } catch (Exception ex) {
                
            }
        }
    }

    @Override
    protected Employee read(Connection con, Object id) throws SQLException {
        Employee employee = null;
        String sql = "select * from Employee where id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id.toString());
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            employee = new Employee();
            employee.setId(rs.getString("id"));
            employee.setName(rs.getString("name"));
            employee.setSalary(rs.getBigDecimal("Salary"));
            employee.setDOB(rs.getDate("DOB"));
        }
        return employee;
        
    }

    @Override
    protected void update(Connection con, Employee employee) throws SQLException {
        String sql = "update Employee set name=?, Salary=?, DOB=? where id=?";
        PreparedStatement stm = con.prepareStatement(sql);        
        stm.setString(1, employee.getName());
        stm.setBigDecimal(2, employee.getSalary()); 
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        stm.setString(3, df.format(employee.getDOB()));
        stm.setString(4, employee.getId());
        stm.executeUpdate();
    }

    @Override
    protected void delete(Connection con, Object id) throws SQLException {
        String sql = "delete from Employee where id = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, id.toString());
        stm.executeUpdate();
    }
    
}

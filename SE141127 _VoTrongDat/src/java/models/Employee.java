//SE141127 Vo Trong Dat
package models;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {

    private String id;
    private String name;
    private BigDecimal salary;
    private Date DOB;

    public Employee() {
    }

    public Employee(String id, String name, BigDecimal salary, Date DOB) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.DOB = DOB;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }
}

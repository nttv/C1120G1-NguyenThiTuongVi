package model;

import java.sql.Date;

public class Employee {
    private String empName;
    private Date empBirthday;
    private String empAddress;

    public Employee(String empName, Date empBirthday, String empAddress) {
        this.empName = empName;
        this.empBirthday = empBirthday;
        this.empAddress = empAddress;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }
}

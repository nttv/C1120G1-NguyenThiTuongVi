package models;

public class Employee {
    private String employeeName;
    private int employeeAge;
    private String employeeAddress;

    public Employee() {
    }

    public Employee(String employeeName, int employeeAge, String employeeAddress) {
        this.employeeName = employeeName;
        this.employeeAge = employeeAge;
        this.employeeAddress = employeeAddress;
    }

    public Employee(String[] employeeInfo) {
        this.employeeName = employeeInfo[0];
        this.employeeAge = Integer.parseInt(employeeInfo[1]);
        this.employeeAddress = employeeInfo[2];
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    @Override
    public String toString() {
        return employeeName + ',' +
                employeeAge + ',' +
                employeeAddress;
    }

    public void showInfor() {
        System.out.println("Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeAddress='" + employeeAddress + '\'' +
                '}');
    }
}

package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.Employee;
import furama_resort.models.FilingCabinet;

import java.util.*;

public class EmployeeManager {
    static FuncReadAndWrite<Employee> funcReadAndWrite = new FuncReadAndWrite<>();

    public List<Employee> findAll() {
        List<String[]> list = funcReadAndWrite.readFile("Employee.csv");
        List<Employee> listEmployee = new ArrayList<>();
        for (String[] line : list) {
            Employee employee = new Employee(line);
            listEmployee.add(employee);
        }
        return listEmployee;
    }

    public Map<String, Employee> getEmployeesData() {
        List<Employee> listEmployee = findAll();
        Map<String, Employee> employeeMap = new LinkedHashMap<>();
        int employeeId = 1;
        for (Employee employee : listEmployee) {
            String id = employeeId + "";
            if (employeeId < 10) {
                id = "00" + employeeId;
            } else if (employeeId < 100) {
                id = "0" + employeeId;
            }
            employeeMap.put(id, employee);
            employeeId++;
        }
        return employeeMap;
    }

    public Map.Entry<String, Employee> getFile(String key) {
        FilingCabinet filingCabinet = new FilingCabinet();
        Stack<Map.Entry<String, Employee>> files = filingCabinet.getFilingCabinet();
        Map.Entry<String, Employee> file;
        while (!files.isEmpty()) {
            file = files.pop();
            System.out.print(file.getKey() + ". ");
            file.getValue().showInfor();
            if (file.getKey().equals(key)) {
                System.out.println("FOUND!");
                return file;
            }
        }
        return null;
    }
}

package furama_resort.models;

import furama_resort.services.EmployeeManager;

import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FilingCabinet {
    Stack<Map.Entry<String, Employee>> filingCabinet = new Stack<>();

    public FilingCabinet() {
        Map<String, Employee> employeeMap = new EmployeeManager().getEmployeesData();
        Set<Map.Entry<String, Employee>> entrySet = employeeMap.entrySet();
        for (Map.Entry<String, Employee> entry : entrySet) {
            filingCabinet.push(entry);
        }
    }

    public Stack<Map.Entry<String, Employee>> getFilingCabinet() {
        return filingCabinet;
    }

    public void setFilingCabinet(Stack<Map.Entry<String, Employee>> filingCabinet) {
        this.filingCabinet = filingCabinet;
    }
}

package Service;

import java.util.List;
import java.util.Map;

public abstract class DepartmentService {

    protected DepartmentService() {
    }

    public Employee findMinSalaryByDepartment(int departmentID) {
        return null;
    }

    public Employee findMaxSalaryByDepartment(int departmentID) {
        return null;
    }

    public int getTotalSalaryCostByDepartment(int departmentID) {
        return 0;
    }

    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(int departmentID) {
        return null;
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return null;
    }
}
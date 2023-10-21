package Service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public abstract class DepartmentServiceImpl extends DepartmentService {
    private final EmployeeService employeeService;

    @Autowired
    DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired
    public Employee findMinSalaryByDepartment(int numberOfDepartment) {
        return employeeService.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == numberOfDepartment)
                .min(Comparator.comparingInt(Employee.getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not Found"));
    }

    @Autowired
    public Employee findMaxSalaryByDepartment(int numberOfDepartment) {
        return employeeService.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == numberOfDepartment)
                .max(Comparator.comparingInt(Employee.getSalary))
                .orElseThrow(() -> new NoSuchElementException("Employee not Found"));
    }

    @Autowired
    public int getTotalSalaryCostByDepartment(int department) {
        return employeeService.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == department)
                .mapToInt(Employee.getSalary)
                .sum();
    }

    @Autowired
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(int department) {
        return employeeService.getEmployeeMap().stream()
                .filter(a -> a.getDepartment() == department)
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    @Autowired
    public Map<Integer, List<Employee>> getAllEmployee() {
        return employeeService.getEmployeeMap().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
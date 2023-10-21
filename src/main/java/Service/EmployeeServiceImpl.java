package Service;

import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employeeMap;

    public EmployeeServiceImpl() {
        this.employeeMap = new HashMap<>();
    }

    @Override
    public Collection<Employee> getEmployeeMap() {
        return this.employeeMap.values();
    }

    @Override
    public Employee addEmployee(String name, String surname, double salary, int department) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(surname)) {
        }
        return null;
    }

    @Override
    public Employee removeEmployee(String name, String surname) {
        return null;
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        return null;
    }

    public class EmployeeNotFoundException extends Exception {
    }

    public class MaximumEmployeeException extends Exception {
    }
}
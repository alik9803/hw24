package Service;
import java.util.Collection;

public interface EmployeeService {

    void addEmployee(String name, String surname, double salary, int department) throws EmployeeServiceImpl.MaximumEmployeeException, MaximumEmployeeException;

    Employee removeEmployee(String name, String surname) throws EmployeeServiceImpl.EmployeeNotFoundException;

    Employee findEmployee(String name, String surname) throws EmployeeServiceImpl.EmployeeNotFoundException;

    Collection<Employee> getEmployeeMap();}
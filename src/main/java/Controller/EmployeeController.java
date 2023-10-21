package Controller;
import Service.Employee;
import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String name, @RequestParam String surname, @RequestParam double salary, @RequestParam int department) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(surname)) {
            throw new IllegalArgumentException("Name and surname cannot be empty");
        }
        return employeeService.addEmployee(name, surname, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String name, @RequestParam String surname) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(surname)) {
            throw new IllegalArgumentException("Name and surname cannot be empty");
        }
        return employeeService.removeEmployee(name, surname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String name, @RequestParam String surname) {
        if (StringUtils.isEmpty(name) || StringUtils.isEmpty(surname)) {
            throw new IllegalArgumentException("Name and surname cannot be empty");
        }
        return employeeService.findEmployee(name, surname);
    }

    @GetMapping
    public Collection<Employee> showEmployee() {
        return employeeService.getEmployeeMap();
    }
}
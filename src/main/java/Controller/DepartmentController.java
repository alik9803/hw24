package Controller;

import Service.DepartmentService;
import Service.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam int departmentID) {
        return departmentService.findMinSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam int departmentID) {
        return departmentService.findMaxSalaryByDepartment(departmentID);
    }

    @GetMapping(path = "/sum-salary")
    public int sumSalaryByDepartment(@RequestParam int departmentID) {
        return departmentService.getTotalSalaryCostByDepartment(departmentID);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment(@RequestParam int departmentID) {
        return departmentService.getAllEmployeesByDepartment(departmentID);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesByDepartment() {
        return departmentService.getAllEmployees();
    }
}
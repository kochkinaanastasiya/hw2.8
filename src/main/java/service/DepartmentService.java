package service;

import com.homework28.hw28.Employee;
import exception.EmployeeNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentService(EmployeeServiceImpl employeeService){
        this.employeeService = employeeService;
    }

    public Employee getEmployeeWithMaxSalary(int department){
        return employeeService.getAll().stream()
                .filter(employee-> employee.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public Employee getEmployeeWithMinSalary(int department){
        return employeeService.getAll().stream()
                .filter(employee-> employee.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> getEmployeesInDepartment(int department){
        return employeeService.getAll().stream()
                .filter(employee-> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Map<Integer,List<Employee>> getEmployeesByDepartments(){
        return employeeService.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }





















}

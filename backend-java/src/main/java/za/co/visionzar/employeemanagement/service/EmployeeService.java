package za.co.visionzar.employeemanagement.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.visionzar.employeemanagement.exception.UserNotFoundException;
import za.co.visionzar.employeemanagement.model.Employee;
import za.co.visionzar.employeemanagement.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
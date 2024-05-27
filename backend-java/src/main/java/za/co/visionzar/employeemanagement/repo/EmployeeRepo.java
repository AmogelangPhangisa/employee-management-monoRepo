package za.co.visionzar.employeemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.visionzar.employeemanagement.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    void deleteEmployeeById(Long id);

    Optional <Employee>findEmployeeById(Long id);
}

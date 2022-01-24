package com.manager.employeeManager.service;

import com.manager.employeeManager.exception.UserNotFoundException;
import com.manager.employeeManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.manager.employeeManager.model.Employee;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    /**
     * @param employee Employee to be added to database
     * @return added Employee confirmation
     */
    public Employee addEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    /**
     * Returns a list of all employees
     *
     * @return list of all employees
     */
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    /**
     * Finds an employee by ID
     *
     * @param id employee ID
     * @return found employee or runtime exception
     */
    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID " + id + "does not exist"));
    }

    /**
     * Updates an employee's details
     *
     * @param employee employee details to be updated
     * @return updated information confirmation
     */
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    /**
     * Removes an employee
     *
     * @param id ID of the employee to be removed
     */
    public void deleteEmployee(Long id) {
        employeeRepo.deleteEmployeeById(id);
    }

}

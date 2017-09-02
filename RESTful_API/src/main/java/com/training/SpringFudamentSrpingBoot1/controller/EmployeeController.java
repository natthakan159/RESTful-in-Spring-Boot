package com.training.SpringFudamentSrpingBoot1.controller;

import com.training.SpringFudamentSrpingBoot1.domain.Employee;
import com.training.SpringFudamentSrpingBoot1.repository.EmployeeCrudRepository;
import com.training.SpringFudamentSrpingBoot1.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {
    List<Employee> employeeList = new ArrayList<>();

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Autowired
    private EmployeeCrudRepository employeeCrudRepository;
    {
        Employee natthakan = new Employee();
        natthakan.setId(1);
        natthakan.setFirstName("Natthakan");
        natthakan.setLastName("Puangroi");
        employeeList.add(natthakan);

        Employee john = new Employee();
        john.setId(2);
        john.setFirstName("John");
        john.setLastName("Mayer");
        employeeList.add(john);
    }
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> listAllEmployee() {

        return employeeJpaRepository.fileAllEmployee();
    }
    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody Employee employee) {

        //employeeList.add(employee);
         employeeJpaRepository.save(employee);
        return employee;

    }
    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeParam) {
        /* Employee employee = getEmployee(id);
        employee.setFirstName(employeeParam.getFirstName());
        employee.setLastName(employeeParam.getLastName());
        return employee; */
        employeeJpaRepository.updateEmployee(id);
        return null;
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployee(@PathVariable Integer id) {
        System.out.println("display id : " + id);

        return  employeeJpaRepository.getEmployeeById(id);
    }
    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable Integer id) {
        Employee employee = getEmployee(id);
       employeeJpaRepository.deleteEmployee(employee);
    }
}

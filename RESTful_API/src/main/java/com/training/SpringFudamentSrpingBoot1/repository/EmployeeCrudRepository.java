package com.training.SpringFudamentSrpingBoot1.repository;

import com.training.SpringFudamentSrpingBoot1.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeCrudRepository extends JpaRepository<Employee, Integer> {

}

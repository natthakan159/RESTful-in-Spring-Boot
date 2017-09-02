package com.training.SpringFudamentSrpingBoot1.repository;

import com.training.SpringFudamentSrpingBoot1.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> fileAllEmployee() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }
    public  Employee fileByLastName(String lastName) {
        Query query = entityManager.createQuery("from Employee e where e.lastName");
        query.setParameter("LAST_NAME", lastName);
        List resultList = query.getResultList();
        return resultList.isEmpty()? null:(Employee)resultList.get(0);
    }
    public List<Employee> findAllByNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("select id, first_name, last_name from employee", Employee.class);
        return nativeQuery.getResultList();
    }
    public Employee getEmployeeById(Integer id) {

        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public void save(Employee employee) {
       entityManager.persist(employee);

    }
    @Transactional
    public void deleteEmployee(Employee employee) {
       entityManager.remove(employee);
    }

    public  void updateEmployee(Integer id) {
            entityManager.persist(id);
    }
}

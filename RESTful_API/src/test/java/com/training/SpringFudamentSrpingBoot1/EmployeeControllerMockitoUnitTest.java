package com.training.SpringFudamentSrpingBoot1;

import com.training.SpringFudamentSrpingBoot1.controller.EmployeeController;
import com.training.SpringFudamentSrpingBoot1.domain.Employee;
import com.training.SpringFudamentSrpingBoot1.repository.EmployeeJpaRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SpringRunner.class)
public class EmployeeControllerMockitoUnitTest {

    private MockMvc mockMvc;

    @InjectMocks
    private EmployeeController controller = new EmployeeController();

    @Mock
    private EmployeeJpaRepository employeeRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
//        this.controller.setEmployeeRepository(employeeRepository);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getEmployeesShouldReturnListOfEmployees() throws Exception {

        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("john");
        employee.setLastName("doe");
        employees.add(employee);

        BDDMockito.given(employeeRepository.fileAllEmployee()).willReturn(employees);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/employees"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].id", equalTo(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].firstName", equalTo("john")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.[0].lastName", equalTo("doe")))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}

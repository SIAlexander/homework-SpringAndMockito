package pro.sky.homeworkspringandmockito.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homeworkspringandmockito.model.Employee;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    public static final Collection<Employee> EMPLOYEES = Arrays.asList(
            new Employee("Александр", "Александров", 10000.0, 1),
            new Employee("Иван", "Иванов", 15000.0, 1),
            new Employee("Антон", "Антонов", 20000.0, 2),
            new Employee("Василий", "Васильев", 40000.0, 2),
            new Employee("Петр", "Петров", 50000.0, 3)
    );
    @Mock
    EmployeeBookServiceImpl employeeBookService;

    @InjectMocks
    DepartmentServiceImpl departmentService;

    @BeforeEach
    void init() {
        when(employeeBookService.getAll()).thenReturn(EMPLOYEES);
    }

    @Test
    void getSumOfSalariesByDepartment() {
        double actual = departmentService.getSumOfSalariesByDepartment(1);
        assertEquals(25000.0, actual);
    }

    @Test
    void getMaxSalaryDepartment() {
        double actual = departmentService.getMaxSalaryDepartment(2);
        assertEquals(40000.0, actual);
    }

    @Test
    void getMinSalaryDepartment() {
        double actual = departmentService.getMinSalaryDepartment(1);
        assertEquals(10000.0, actual);
    }

    @Test
    void getDepartmentAll() {
        List<Employee> actual = departmentService.getDepartmentAll(3);
        Collection<Employee> expected = Collections.singletonList(
                new Employee("Петр", "Петров", 50000.0, 3));
        assertIterableEquals(expected, actual);
    }

    @Test
    void getAll() {
        Map<Integer, List<Employee>> actual = departmentService.getDepartmentAll();

        Employee petr = new Employee("Петр", "Петров", 50000.0, 3);
        assertTrue(actual.get(3).contains(petr));
        assertFalse(actual.get(2).contains(petr));

        assertEquals(3, actual.keySet().size());
    }

    @Test
    void getAllByWrongDepartment() {
        List<Employee> all = departmentService.getDepartmentAll(4);
        assertTrue(all.isEmpty());
    }
}

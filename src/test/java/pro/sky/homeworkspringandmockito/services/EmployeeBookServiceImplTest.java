package pro.sky.homeworkspringandmockito.services;

import org.junit.jupiter.api.Test;
import pro.sky.homeworkspringandmockito.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkspringandmockito.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkspringandmockito.model.Employee;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeBookServiceImplTest {

    EmployeeBookServiceImpl employeeBookService = new EmployeeBookServiceImpl();

    @Test
    void whenNotUniqThenThrowException() {
        employeeBookService.addEmployee("name", "sur_name", 1, 1);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeBookService.addEmployee("name", "sur_name", 1, 1));
    }

    @Test
    void addEmployeePositive() {
        employeeBookService.addEmployee("name", "sur_name", 1, 1);
        assertTrue(employeeBookService.getAll()
                .contains(new Employee("name", "sur_name", 1, 1)));
    }

    @Test
    void findEmployeePositive() {
        Employee employee = employeeBookService.addEmployee("name", "sur_name", 1, 1);
        Employee actual = employeeBookService.findEmployee("name", "sur_name", 1, 1);
        assertNotNull(actual);
        assertEquals(employee, actual);
    }

    @Test
    void findEmployeeNegative() {
        Employee employee = employeeBookService.addEmployee("name", "sur_name", 1, 1);
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeBookService.findEmployee("no_name", "no_sur_name", 1, 1));
    }

    @Test
    void removeEmployeePositive() {
        Employee employee = employeeBookService.addEmployee("name", "sur_name", 1, 1);
        Employee actual = employeeBookService.removeEmployee("name", "sur_name", 1, 1);
        assertNotNull(actual);
        assertEquals(employee, actual);
    }

    @Test
    void whenNotFoundThenThrowException() {
        employeeBookService.addEmployee("name", "sur_name", 1, 1);
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeBookService.removeEmployee("no_name", "no_sur_name", 1, 1));
    }
}

package pro.sky.homeworkspringandmockito.services;

import org.springframework.stereotype.Service;
import pro.sky.homeworkspringandmockito.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkspringandmockito.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentServiceInterface {

    private final EmployeeBookServiceImpl service;

    public DepartmentServiceImpl(EmployeeBookServiceImpl service) {
        this.service = service;
    }

    @Override
    public double getMaxSalaryDepartment(int department) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public double getMinSalaryDepartment(int department) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .map(Employee::getSalary)
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> getDepartmentAll(int department) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public double getSumOfSalariesByDepartment(int department) {
        return service.getAll().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Map<Integer, List<Employee>> getDepartmentAll() {
        return service.getAll().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}

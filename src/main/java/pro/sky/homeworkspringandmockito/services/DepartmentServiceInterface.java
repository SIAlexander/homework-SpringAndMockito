package pro.sky.homeworkspringandmockito.services;


import pro.sky.homeworkspringandmockito.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {

    double getMaxSalaryDepartment(int department);

    double getMinSalaryDepartment(int department);

    List<Employee> getDepartmentAll(int department);

    double getSumOfSalariesByDepartment(int department);

    Map<Integer, List<Employee>> getDepartmentAll();
}

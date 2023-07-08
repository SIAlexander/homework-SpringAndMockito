package pro.sky.homeworkspringandmockito.controllers;

import org.springframework.web.bind.annotation.*;
import pro.sky.homeworkspringandmockito.model.Employee;
import pro.sky.homeworkspringandmockito.services.DepartmentServiceInterface;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentServiceInterface service;

    public DepartmentController(DepartmentServiceInterface service) {
        this.service = service;
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getDepartmentEmployees() {
        return service.getDepartmentAll();
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> getDepartmentEmployees(@PathVariable int id) {
        return service.getDepartmentAll(id);
    }

    @GetMapping(path = "{id}/salary/max")
    public double getMaxSalaryDepartment(@PathVariable int id) {
        return service.getMaxSalaryDepartment(id);
    }

    @GetMapping(path = "{id}/salary/min")
    public double getMinSalaryDepartment(@PathVariable int id) {
        return service.getMinSalaryDepartment(id);
    }

    @GetMapping("{id}/salary/sum")
    public double getSumOfSalariesByDepartment(@PathVariable int id) {
        return service.getSumOfSalariesByDepartment(id);
    }

}
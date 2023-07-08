package pro.sky.homeworkspringandmockito.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homeworkspringandmockito.model.Employee;
import pro.sky.homeworkspringandmockito.services.EmployeeBookServiceInterface;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeBookController {

    private final EmployeeBookServiceInterface service;

    public EmployeeBookController(EmployeeBookServiceInterface service) {
        this.service = service;
    }


    @GetMapping("/add")
    public Employee addEmployee(@RequestParam("name") String name,
                                @RequestParam("surname") String surname,
                                @RequestParam("salary") double salary,
                                @RequestParam("department") int department
    ) {
        return service.addEmployee(name, surname, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("name") String name,
                                   @RequestParam("surname") String surname,
                                   @RequestParam("salary") double salary,
                                   @RequestParam("department") int department
    ) {
        return service.removeEmployee(name, surname, salary, department);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("name") String name,
                                 @RequestParam("surname") String surname,
                                 @RequestParam("salary") double salary,
                                 @RequestParam("department") int department
    ) {
        return service.findEmployee(name, surname, salary, department);
    }

    @GetMapping
    public Collection<Employee> printAll() {
        return service.getAll();
    }
}

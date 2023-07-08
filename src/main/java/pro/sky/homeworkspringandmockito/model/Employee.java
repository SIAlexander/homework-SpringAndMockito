package pro.sky.homeworkspringandmockito.model;

import java.util.Objects;

public class Employee {
    private final String name;
    private final String surName;
    private final double salary;
    private int department;

    public Employee(String name, String surName, double salary, int department) {
        this.name = name;
        this.surName = surName;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getFullName() {
        return (name + surName).toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surName, employee.surName) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}

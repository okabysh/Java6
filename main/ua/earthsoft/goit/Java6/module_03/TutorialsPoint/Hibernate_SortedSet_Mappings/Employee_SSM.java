package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_SortedSet_Mappings;

import java.util.SortedSet;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class Employee_SSM {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private SortedSet certificates;

    public Employee_SSM() {}

    public Employee_SSM(String firstName, String lastName, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public SortedSet getCertificates() {
        return certificates;
    }

    public void setCertificates(SortedSet certificates) {
        this.certificates = certificates;
    }

    @Override
    public String toString() {
        return "Employee_SSM{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", certificates=" + certificates +
                '}';
    }
}

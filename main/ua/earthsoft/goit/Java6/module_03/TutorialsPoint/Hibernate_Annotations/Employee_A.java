package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oleg Kabysh on 31.07.2017.
 */
@Entity
@Table(name = "ts_employee")
public class Employee_A {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="ts_certificate")
    private List<Certificate_A> certificateList;

    public Employee_A() {}

    public Employee_A(String firstName, String lastName, int salary) {
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

    public List<Certificate_A> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate_A> certificateList) {
        this.certificateList = certificateList;
    }

    @Override
    public String toString() {
        return "Employee_A{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

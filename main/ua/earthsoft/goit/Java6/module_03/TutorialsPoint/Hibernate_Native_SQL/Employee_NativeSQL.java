package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Native_SQL;

import java.util.Set;

/**
 * Created by Oleg Kabysh on 03.08.2017.
 */
public class Employee_NativeSQL {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee_NativeSQL() {}

    public Employee_NativeSQL(String fname, String lname, int salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary( int salary ) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee_NativeSQL{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}

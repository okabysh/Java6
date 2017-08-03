package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Associations.XML._1_One_to_One;

/**
 * Created by Oleg Kabysh on 02.08.2017.
 */

public class Employee_A1 {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private Address_A1 address;

    public Employee_A1() {}

    public Employee_A1(String fname, String lname,
                       int salary, Address_A1 address ) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
        this.address = address;
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
    public Address_A1 getAddress() {
        return address;
    }
    public void setAddress( Address_A1 address ) {
        this.address = address;
    }

}

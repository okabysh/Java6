package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Component_Mappings;

/**
 * Created by Oleg Kabysh on 03.08.2017.
 */
public class Employee_A5 implements java.io.Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;
    private Address_A5 address;

    public Employee_A5() {}

    public Employee_A5(String fname, String lname,
                       int salary, Address_A5 address ) {
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
    public Address_A5 getAddress() {
        return address;
    }
    public void setAddress( Address_A5 address ) {
        this.address = address;
    }
}

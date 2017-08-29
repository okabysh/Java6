package ua.earthsoft.goit.Java6.module_03.home_task.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg Kabysh on 30.06.2017.
 */

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "city")
    private String city;

    @Column(name = "identificationCode")
    private String identificationCode;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "mtm_company_customer", joinColumns = {@JoinColumn(name = "company") },
            inverseJoinColumns = { @JoinColumn(name = "customer") })
    private Set<Customer> customers = new HashSet<Customer>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", identificationCode='" + identificationCode + '\'' +
                '}';
    }
}

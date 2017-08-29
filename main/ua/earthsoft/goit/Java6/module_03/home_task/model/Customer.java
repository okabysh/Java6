package ua.earthsoft.goit.Java6.module_03.home_task.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Oleg Kabysh on 02.07.2017.
 */

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "identificationCode")
    private String identificationCode;

    @Column(name = "phone")
    private String phone;

//    private Set<Company> companies = new HashSet<Company>(0);

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

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "companies")
//    public Set<Company> getCompanies() {
//        return companies;
//    }
//
//    public void setCompanies(Set<Company> companies) {
//        this.companies = companies;
//    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", identificationCode='" + identificationCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

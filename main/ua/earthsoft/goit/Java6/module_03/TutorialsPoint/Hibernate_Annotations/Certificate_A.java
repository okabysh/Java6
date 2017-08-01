package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Oleg Kabysh on 01.08.2017.
 */

@Entity
@Table(name = "ts_certificate")
public class Certificate_A {
    @Id @GeneratedValue
    private int id;

    @Column(name = "certificate_name")
    private String name;

    @Column(name = "employee_id")
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    private int emloyee_id;

    public Certificate_A() {
    }

    public Certificate_A(String name) {
        this.name = name;
    }

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

    public int getEmloyee_id() {
        return emloyee_id;
    }

    public void setEmloyee_id(int emloyee_id) {
        this.emloyee_id = emloyee_id;
    }

    @Override
    public String toString() {
        return "Certificate_A{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emloyee_id=" + emloyee_id +
                '}';
    }
}

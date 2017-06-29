package earthsoft.goit.Java6.Module_02.HomeTask.Model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Developer {
    private int id;

    private String firstName;
    private String surName;
    private String identificationCode;
    private java.sql.Date birthday;
    private String phone;
    private BigDecimal salary;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public java.sql.Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", identificationCode='" + identificationCode + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                '}';
    }
}

package earthsoft.goit.Java6.Module_02.HomeTask.model;

import java.math.BigDecimal;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Developer {
    private String firstName;
    private String surName;
    private String identificationCode;
    private java.sql.Date birthday;
    private String phone;
    private BigDecimal salary;

    public Developer(String firstName, String surName, String identificationCode,
                     java.sql.Date birthday, String phone, BigDecimal salary) {
        this.firstName = firstName;
        this.surName = surName;
        this.identificationCode = identificationCode;
        this.birthday = birthday;
        this.phone = phone;
        this.salary = salary;
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

}

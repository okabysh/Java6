package earthsoft.goit.Java6.Module_02.Mrachkovskiy.HomeTask.Branch1;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Developer {
    private String firstName;
    private String surName;
    private String identificationCode;
    private Date birthday;
    private String phone;
    private BigDecimal salary;

    public Developer(String firstName, String surName, String identificationCode,
                     Date birthday, String phone, BigDecimal salary) {
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

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public BigDecimal getSalary() {
        return salary;
    }

}

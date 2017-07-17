package ua.earthsoft.goit.Java6.module_02.home_task.model;

/**
 * Created by Oleg Kabysh on 30.06.2017.
 */
public class Company {
    private int id;
    private String name;
    private String fullName;
    private String city;
    private String identificationCode;

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

package earthsoft.goit.Java6.Module_02.HomeTask.Model;

/**
 * Created by Oleg Kabysh on 02.07.2017.
 */
public class Customer {
    private int id;
    private String name;
    private String identificationCode;
    private String phone;

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

package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Set_Mappings;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class Certificate {
    private int id;
    private String name;

    public Certificate() {
    }

    public Certificate(String name) {
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

    @Override
    public String toString() {
        return "Certificate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!this.getClass().equals(obj.getClass())) {
            return false;
        }

        Certificate obj2 = (Certificate) obj;
        if ((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
            return true;
        }
        return false;
    }

    public int hashcode() {
        int tmp = 0;
        tmp = (id + name).hashCode();
        return tmp;
    }
}

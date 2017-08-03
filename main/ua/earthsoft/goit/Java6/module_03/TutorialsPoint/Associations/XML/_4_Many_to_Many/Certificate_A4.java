package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Associations.XML._4_Many_to_Many;

/**
 * Created by Oleg Kabysh on 03.08.2017.
 */
public class Certificate_A4 {
    private int id;
    private String name;

    public Certificate_A4() {}

    public Certificate_A4(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName( String name ) {
        this.name = name;
    }
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!this.getClass().equals(obj.getClass())) return false;
        Certificate_A4 obj2 = (Certificate_A4) obj;
        if((this.id == obj2.getId()) && (this.name.equals(obj2.getName())))
        {
            return true;
        }

        return false;
    }
    public int hashCode() {
        int tmp = 0;
        tmp = ( id + name ).hashCode();
        return tmp;
    }
}

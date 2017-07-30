package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_SortedSet_Mappings;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class Certificate_SSM implements Comparable <Certificate_SSM>{
    private int id;
    private String name;

    public Certificate_SSM() {}

    public Certificate_SSM(String name) {
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
    public int compareTo(Certificate_SSM that){
        final int BEFORE = -1;
        final int AFTER = 1;
        if (that == null) {
            return BEFORE;
        }
        Comparable thisCertificate = this.getName();
        Comparable thatCertificate = that.getName();
        if(thisCertificate == null) {
            return AFTER;
        } else if(thatCertificate == null) {
            return BEFORE;
        } else {
            return thisCertificate.compareTo(thatCertificate);
        }
    }

    @Override
    public String toString() {
        return "Certificate_SSM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations.Associations._1_One_to_One;

/**
 * Created by Oleg Kabysh on 02.08.2017.
 */
public class Address_A1 {
    private int id;
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public Address_A1() {}

    public Address_A1(String street, String city,
                      String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet( String street ) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState( String state ) {
        this.state = state;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode( String zipcode ) {
        this.zipcode = zipcode;
    }
}
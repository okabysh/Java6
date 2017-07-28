package ua.earthsoft.goit.Java6.module_03.suleimanov.hibernateTutorial.model;

/**
 * Created by Oleg Kabysh on 28.07.2017.
 */
public class Developer {
    private int id;
    private String firstName;
    private String lastName;
    private String speciality;
    private int experience;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String speciality, int experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.speciality = speciality;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", speciality='" + speciality + '\'' +
                ", experience=" + experience +
                '}';
    }
}

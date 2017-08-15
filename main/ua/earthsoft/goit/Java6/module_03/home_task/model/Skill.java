package ua.earthsoft.goit.Java6.module_03.home_task.model;

import javax.persistence.*;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
@Entity
@Table(name = "skills")
public class Skill {
    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

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
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


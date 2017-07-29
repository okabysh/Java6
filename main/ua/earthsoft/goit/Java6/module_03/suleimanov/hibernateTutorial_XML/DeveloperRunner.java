package ua.earthsoft.goit.Java6.module_03.suleimanov.hibernateTutorial_XML;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.earthsoft.goit.Java6.module_03.suleimanov.hibernateTutorial_XML.model.Developer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Kabysh on 28.07.2017.
 */
public class DeveloperRunner {
    private static SessionFactory sessionFactory;

    public static void main(String[] args) {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Add developer's record to DB ");
        developerRunner.addDeveloper("Ivan","Sidorov","Java", 2);
        developerRunner.addDeveloper("Sergey", "Ivanov", "C#", 3);
        developerRunner.addDeveloper("John", "Connor", "C++", 4);
        developerRunner.addDeveloper("Illya", "Chobot", "PHP", 5);

        List<Developer> developers = developerRunner.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer.toString());
        }

        System.out.println("\n");

        developerRunner.updateDeveloper(8,11);
        developers = developerRunner.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer.toString());
        }

        System.out.println("\n");

        developerRunner.removeDeveloper(8);
        developers = developerRunner.listDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer.toString());
        }
    }

    public void addDeveloper(String firstName, String lastName, String speciality, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        Developer developer = new Developer(firstName, lastName, speciality, experience);
        session.save(developer);
        transaction.commit();
        session.close();
    }

    public List listDevelopers() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();

        List developers = new ArrayList<Developer>();

        developers = session.createQuery("FROM Developer").list();

        transaction.commit();
        session.close();

        return developers;
    }

    public void updateDeveloper(int developerId, int experience) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        Developer developer = session.get(Developer.class, developerId);
        developer.setExperience(experience);
        session.update(developer);

        transaction.commit();
        session.close();
    }

    public void removeDeveloper(int developerId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();

        //update
        Developer developer = session.get(Developer.class, developerId);
        session.delete(developer);
        transaction.commit();
        session.close();
    }
}

package ua.earthsoft.goit.Java6.module_03.home_task;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations.Employee_A;
import ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations.ManageEmployee_A;
import ua.earthsoft.goit.Java6.module_03.home_task.driver.RegisterDriver;
import ua.earthsoft.goit.Java6.module_03.home_task.model.*;
import ua.earthsoft.goit.Java6.module_03.home_task.view.MainView;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Launch {
    public static SessionFactory factory;

    public static void main(String[] args) throws IOException, ParseException {

        try {
            factory = new AnnotationConfiguration().
                    configure("ua/earthsoft/goit/Java6/module_03/home_task/resources/hibernate-annotations.cfg.xml").
                    addPackage("ua.earthsoft.goit.Java6.module_03.home_task").
                    addAnnotatedClass(Company.class).
                    addAnnotatedClass(Customer.class).
                    addAnnotatedClass(Developer.class).
                    addAnnotatedClass(Project.class).
                    addAnnotatedClass(Skill.class).
                    buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

//        RegisterDriver registerDriver = new RegisterDriver();
//        if (!registerDriver.register()) {
//            System.out.println("Do not registered driver.");
//            System.exit(1);
//        }

        MainView mainView = new MainView();
        mainView.view();

    }

}

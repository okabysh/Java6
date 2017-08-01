package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by Oleg Kabysh on 31.07.2017.
 */
public class ManageEmployee_A {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            /*factory = new AnnotationConfiguration().configure("/earthsoft/goit/Java6/module_03/TutorialsPoint/Hibernate_Annotations/resources/hibernate-annotations.cfg.xml").
                    //addPackage("ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations").
                    addAnnotatedClass(Employee_A.class).
                    buildSessionFactory();*/

            factory = new AnnotationConfiguration().
                    configure("ua/earthsoft/goit/Java6/module_03/TutorialsPoint/Hibernate_Annotations/resources/hibernate-annotations.cfg.xml").
                    addPackage("ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations").
                    addAnnotatedClass(Employee_A.class).
                    buildSessionFactory();
                //new Configuration().configure().addAnnotatedClass()

        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmployee_A ME = new ManageEmployee_A();

        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);

        ME.listEmployees();

        ME.updateEmployee(empID1, 20000);

        ME.deleteEmployee(empID2);

        ME.listEmployees();

    }

    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee_A employee = new Employee_A();
            employee.setFirstName(fname);
            employee.setLastName(lname);
            employee.setSalary(salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List<Employee_A> employees = (List<Employee_A>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Annotations.Employee_A").list();
            for (Employee_A employee : employees) {
                System.out.println(employee.toString());
            }
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee_A employee = (Employee_A) session.get(Employee_A.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee_A employee = (Employee_A) session.get(Employee_A.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

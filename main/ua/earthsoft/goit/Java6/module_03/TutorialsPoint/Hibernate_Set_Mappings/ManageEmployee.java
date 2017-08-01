package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Set_Mappings;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object."+ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmployee ME = new ManageEmployee();
        Integer empID1 = ME.addEmloyee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmloyee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmloyee("John", "Paul", 10000);
        ME.listEmployees();

        ME.updateEmployee(empID1, 5000);

        ME.deleteEmployee(empID2);

        ME.listEmployees();
    }

    public Integer addEmloyee(String fname, String lname, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }

    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx=session.beginTransaction();
            List<Employee> employees = session.createQuery("FROM Employee").list();
            System.out.println("\nList employees:");
            for (Employee employee: employees) {
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
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
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
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}

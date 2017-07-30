package ua.earthsoft.goit.Java6.module_03.TutorialsPoint;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class ManageEmloyeeCertificate {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object."+ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmloyeeCertificate ME = new ManageEmloyeeCertificate();

        HashSet set1 = new HashSet();
        set1.add(new Certificate("MCA"));
        set1.add(new Certificate("MBA"));
        set1.add(new Certificate("PMP"));
        Integer empID1 = ME.addEmloyee("Manoj", "Kumar", 4000, set1);

        HashSet set2 = new HashSet();
        set2.add(new Certificate("BCA"));
        set2.add(new Certificate("BA"));
        Integer empID2 = ME.addEmloyee("Dilip", "Kumar", 3000, set2);

        ME.listEmployees();

        ME.updateEmployee(empID1, 5000);

        ME.deleteEmployee(empID2);

        ME.listEmployees();
//        ME.deleteEmployee(16);

    }

    public Integer addEmloyee(String fname, String lname, int salary, Set cert) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeId = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee(fname, lname, salary);
            employee.setCertificates(cert);
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
//                Set<Certificate> certificates = employee.getCertificates();
//                if (!certificates.isEmpty()) {
//                    System.out.println("   List certificates:");
//                }
//                for (Certificate certificate : certificates) {
//                    System.out.println("   "+certificate.toString());
//                }
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
            Employee employee = session.get(Employee.class, EmployeeID);
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
            Employee employee = session.get(Employee.class, EmployeeID);
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

package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_SortedSet_Mappings;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.*;

/**
 * Created by Oleg Kabysh on 30.07.2017.
 */
public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmployee ME = new ManageEmployee();
/* Let us have a set of certificates for the first employee */
        TreeSet set1 = new TreeSet();
        set1.add(new Certificate_SSM("MCA"));
        set1.add(new Certificate_SSM("MBA"));
        set1.add(new Certificate_SSM("PMP"));
/* Add employee records in the database */
        Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);

/* Another set of certificates for the second employee */
        TreeSet set2 = new TreeSet();
        set2.add(new Certificate_SSM("BCA"));
        set2.add(new Certificate_SSM("BA"));
/* Add another employee record in the database */
        Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);
/* List down all the employees */
        ME.listEmployees();
/* Update employee's salary records */
        ME.updateEmployee(empID1, 5000);
/* Delete an employee from the database */
        ME.deleteEmployee(empID2);
/* List down all the employees */
        ME.listEmployees();
    }

    /* Method to add an employee record in the database */
    public Integer addEmployee(String fname, String lname,
                               int salary, SortedSet cert) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try {
            tx = session.beginTransaction();
            Employee_SSM employee = new Employee_SSM(fname, lname, salary);
            employee.setCertificates(cert);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeID;
    }

    /* Method to list all the employees detail */
    public void listEmployees() {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();
            for (Iterator iterator1 =
                 employees.iterator(); iterator1.hasNext(); ) {
                Employee_SSM employee = (Employee_SSM) iterator1.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print(" Last Name: " + employee.getLastName());
                System.out.println(" Salary: " + employee.getSalary());
                SortedSet certificates = employee.getCertificates();
                for (Iterator iterator2 =
                     certificates.iterator(); iterator2.hasNext(); ) {
                    Certificate_SSM certName = (Certificate_SSM) iterator2.next();
                    System.out.println("Certificate: " + certName.getName());
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /* Method to update salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee_SSM employee =
                    (Employee_SSM) session.get(Employee_SSM.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to delete an employee from the records */
    public void deleteEmployee(Integer EmployeeID) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee_SSM employee =
                    (Employee_SSM) session.get(Employee_SSM.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

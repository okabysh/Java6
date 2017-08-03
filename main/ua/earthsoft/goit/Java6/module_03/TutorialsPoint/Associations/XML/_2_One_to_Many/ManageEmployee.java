package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Associations.XML._2_One_to_Many;

/**
 * Created by Oleg Kabysh on 02.08.2017.
 */
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ManageEmployee {
    private static SessionFactory factory;

    public static void main(String[] args) {
        try{
            factory = new Configuration().
                    configure("ua/earthsoft/goit/Java6/module_03/TutorialsPoint/Associations/XML/_2_One_to_Many/resources/hibernate_a2.cfg.xml").
                    buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageEmployee ME = new ManageEmployee();
/* Let us have a set of certificates for the first employee */
        HashSet set1 = new HashSet();
        set1.add(new Certificate_A2("MCA"));
        set1.add(new Certificate_A2("MBA"));
        set1.add(new Certificate_A2("PMP"));
/* Add employee records in the database */
        Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);
/* Another set of certificates for the second employee */
        HashSet set2 = new HashSet();
        set2.add(new Certificate_A2("BCA"));
        set2.add(new Certificate_A2("BA"));
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
                               int salary, Set cert){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Employee_A2 employee = new Employee_A2(fname, lname, salary);
            employee.setCertificates(cert);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }
    /* Method to list all the employees detail */
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee_A2").list();
            for (Iterator iterator1 =
                 employees.iterator(); iterator1.hasNext();){
                Employee_A2 employee = (Employee_A2) iterator1.next();
                System.out.print("First Name: " + employee.getFirstName());
                System.out.print(" Last Name: " + employee.getLastName());
                System.out.println(" Salary: " + employee.getSalary());
                Set certificates = employee.getCertificates();
                for (Iterator iterator2 =
                     certificates.iterator(); iterator2.hasNext();){
                    Certificate_A2 certName = (Certificate_A2) iterator2.next();
                    System.out.println("Certificate: " + certName.getName());
                }
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to update salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee_A2 employee =
                    (Employee_A2) session.get(Employee_A2.class, EmployeeID);
            employee.setSalary( salary );
            session.update(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to delete an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee_A2 employee =
                    (Employee_A2) session.get(Employee_A2.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}

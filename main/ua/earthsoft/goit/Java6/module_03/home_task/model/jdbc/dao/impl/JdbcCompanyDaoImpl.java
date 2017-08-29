package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.*;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Company;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.ICompanyDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.SQLQueryUtil;

import javax.persistence.*;
import java.sql.*;
import java.util.*;

/**
 * Created by Oleg Kabysh on 30.06.2017.
 */
public class JdbcCompanyDaoImpl implements ICompanyDAO {
    private static final JdbcCompanyDaoImpl instance = new JdbcCompanyDaoImpl();
    private Set<Customer> customers = new HashSet<Customer>(0);

    private JdbcCompanyDaoImpl() {}

    public static JdbcCompanyDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void create(Company company) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(company);
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

    @Override
    public List<Company> read() {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Company> companyList = (List<Company>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Company").list();
            return companyList;
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Company company) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Company companyForUpdate = (Company) session.get(Company.class, company.getId());
            companyForUpdate.setName(company.getName());
            companyForUpdate.setFullName(company.getFullName());
            companyForUpdate.setCity(company.getCity());
            companyForUpdate.setIdentificationCode(company.getIdentificationCode());
            session.update(companyForUpdate);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Company companyForDelete = (Company) session.get(Company.class, id);
            session.delete(companyForDelete);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Company getById(int id) {
        String sql = SQLQueryUtil.GET_COMPANY_BY_ID;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, id);
            query.addEntity(Company.class);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                Company company = (Company) iterator.next();
                return company;
            }
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomersByCompany(int companyId) {
        List<Customer> customerList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_CUSTOMERS_BY_COMPANY;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, companyId);
            query.addEntity(Customer.class);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                customerList.add((Customer) iterator.next());
            }
            return customerList;
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomers(Company company) {
        List<Customer> customerList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_CUSTOMERS_BY_COMPANY;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            customerList = (List<Customer>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Customer WHERE (select * FROM company = :paramCompany").list();
            tx.commit();
            for (Iterator iterator = customerList.iterator(); iterator.hasNext();){
                //(Company) iterator.next();
            }
            return customerList;
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void addCustomer(int customerId, int companyId) {
        String sql = SQLQueryUtil.ADD_CUSTOMER_TO_COMPANY;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, companyId);
            query.setInteger(1, customerId);
            List result = query.list();
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

    @Override
    public void deleteCustomer(int customerId, int companyId) {
        String sql = SQLQueryUtil.DELETE_CUSTOMER_FROM_COMPANY;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, companyId);
            ps.setInt(2, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillStatement(Company company, PreparedStatement ps) throws SQLException {
        ps.setString(1, company.getName());
        ps.setString(2, company.getFullName());
        ps.setString(3, company.getCity());
        ps.setString(4, company.getIdentificationCode());
        ps.executeUpdate();
    }
}

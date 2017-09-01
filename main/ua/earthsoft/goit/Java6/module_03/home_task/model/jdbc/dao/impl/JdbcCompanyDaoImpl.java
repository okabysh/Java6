package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.*;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Company;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.ICompanyDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.QueryUtil;

import java.lang.reflect.*;
import java.lang.reflect.Array;
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
        String hql = QueryUtil.HQL_GET_COMPANY_BY_ID;
        Session session = Launch.factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setInteger("parameter", id);
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
        String sql = QueryUtil.GET_CUSTOMERS_BY_COMPANY;
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
        //TODO return List Customers by company
        List<Customer> customerList = new ArrayList<>();
        String sql = QueryUtil.GET_CUSTOMERS_BY_COMPANY;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            customerList = (List<Customer>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Company comp WHERE ua.earthsoft.goit.Java6.module_03.home_task.model.Company.customers = :paramCompany").list();
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
//        String sql = QueryUtil.ADD_CUSTOMER_TO_COMPANY;
//        Session session = Launch.factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            SQLQuery query = session.createSQLQuery(sql);
//            query.setInteger(0, companyId);
//            query.setInteger(1, customerId);
//            List result = query.list();
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx!=null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }

//        DomesticCat pk = new DomesticCat();
//        pk.setColor(Color.TABBY);
//        pk.setSex('F');
//        pk.setName("PK");
//        pk.setKittens( new HashSet() );
//        pk.addKitten(fritz);
//        sess.save( pk, new Long(1234) );

        JdbcCustomerDaoImpl jdbcCustomerDao = JdbcCustomerDaoImpl.getInstance();
        Company company = getInstance().getById(companyId);
        Customer customer = jdbcCustomerDao.getById(customerId);


        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            HashSet<Customer> setCustomers = new HashSet<>();
            setCustomers.add(customer);
            company.setCustomers(setCustomers);
            session.update(company);
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
        String sql = QueryUtil.DELETE_CUSTOMER_FROM_COMPANY;

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

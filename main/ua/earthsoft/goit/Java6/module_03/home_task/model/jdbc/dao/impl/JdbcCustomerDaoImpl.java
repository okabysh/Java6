package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.*;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.*;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.ICustomerDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.QueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Oleg Kabysh on 02.07.2017.
 */
public class JdbcCustomerDaoImpl implements ICustomerDAO {
    public static final JdbcCustomerDaoImpl instance = new JdbcCustomerDaoImpl();

    private JdbcCustomerDaoImpl() {}

    public static JdbcCustomerDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void create(Customer customer) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(customer);
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
    public List<Customer> read() {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Customer> customerList = (List<Customer>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Customer").list();
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
    public void update(Customer customer) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Customer customerForUpdate = (Customer) session.get(Customer.class, customer.getId());
            customerForUpdate.setName(customer.getName());
            customerForUpdate.setIdentificationCode(customer.getIdentificationCode());
            customerForUpdate.setPhone(customer.getPhone());
            session.update(customerForUpdate);
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
            Customer customerForDelete = (Customer) session.get(Customer.class, id);
            session.delete(customerForDelete);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Customer getById(int id) {
        //String sql = QueryUtil.SQL_GET_CUSTOMER_BY_ID;
        String hql = QueryUtil.HQL_GET_CUSTOMER_BY_ID;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setInteger("parameter", id);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                Customer customer = (Customer) iterator.next();
                return customer;
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
    public List<Project> getProjects(int id) {
        List<Project> projectList = new ArrayList<>();
        String sql = QueryUtil.GET_PROJECTS_BY_CUSTOMER;

        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, id);
            query.addEntity(Project.class);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                projectList.add((Project) iterator.next());
            }
            return projectList;
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
    public List<Developer> getDevelopersByCustomer(int customerId) {
        List<Developer> developerList = new ArrayList<>();
        String sql = QueryUtil.GET_DEVELOPERS_BY_CUSTOMER;
        JdbcDeveloperDaoImpl jdbcDeveloperDaoImpl = JdbcDeveloperDaoImpl.getInstance();

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                developerList.add(jdbcDeveloperDaoImpl.getById(rs.getInt("developer")));
            }
            return developerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addProject(int projectId, int customerId) {
        String sql = QueryUtil.ADD_PROJECT_TO_CUSTOMER;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, customerId);
            ps.setInt(2, projectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProject(int projectId, int customerId) {
        String sql = QueryUtil.DELETE_PROJECT_FROM_CUSTOMER;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, customerId);
            ps.setInt(2, projectId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillStatement(Customer customer, PreparedStatement ps) throws SQLException {
        ps.setString(1, customer.getName());
        ps.setString(2, customer.getIdentificationCode());
        ps.setString(3, customer.getPhone());
        ps.executeUpdate();
    }
}

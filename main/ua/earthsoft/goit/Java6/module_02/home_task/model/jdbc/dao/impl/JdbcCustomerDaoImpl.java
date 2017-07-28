package ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl;

import ua.earthsoft.goit.Java6.module_02.home_task.model.*;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.ICustomerDAO;
import ua.earthsoft.goit.Java6.module_02.home_task.util.CrudUtil;
import ua.earthsoft.goit.Java6.module_02.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_02.home_task.util.SQLQueryUtil;

import java.sql.*;
import java.util.ArrayList;
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
        String sql = SQLQueryUtil.getQuery("customers", CrudUtil.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(customer, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> read() {
        List<Customer> customerList = new ArrayList<Customer>();

        String sql = SQLQueryUtil.getQuery("customers", CrudUtil.READ, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs  = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setIdentificationCode(rs.getString("identificationCode"));
                customer.setPhone(rs.getString("phone"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Customer customer) {
        String sql = SQLQueryUtil.getQuery("customers", CrudUtil.UPDATE, customer.getId());
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(customer, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = SQLQueryUtil.getQuery("customers", CrudUtil.DELETE, id);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getById(int id) {
        String sql = SQLQueryUtil.GET_CUSTOMER_BY_ID;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setIdentificationCode(rs.getString("identificationCode"));
                customer.setPhone(rs.getString("phone"));
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Project> getProjects(int projectId) {
        List<Project> projectList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_PROJECTS_BY_CUSTOMER;
        JdbcProjectDaoImpl jdbcProjectDaoImpl = JdbcProjectDaoImpl.getInstance();

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                projectList.add(jdbcProjectDaoImpl.getById(rs.getInt("project")));
            }
            return projectList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Developer> getDevelopers(int customerId) {
        List<Developer> developerList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_DEVELOPERS_BY_CUSTOMER;
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
        String sql = SQLQueryUtil.ADD_PROJECT_TO_CUSTOMER;

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
        String sql = SQLQueryUtil.DELETE_PROJECT_FROM_CUSTOMER;

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

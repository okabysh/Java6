package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import ua.earthsoft.goit.Java6.module_03.home_task.model.Company;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.ICompanyDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.util.CrudUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.SQLQueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Kabysh on 30.06.2017.
 */
public class JdbcCompanyDaoImpl implements ICompanyDAO {
    private static final JdbcCompanyDaoImpl instance = new JdbcCompanyDaoImpl();

    private JdbcCompanyDaoImpl() {}

    public static JdbcCompanyDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void create(Company company) {
//        String sql = SQLQueryUtil.getQuery("companies", CrudUtil.CREATE, 0);
//        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
//             PreparedStatement ps = connection.prepareStatement(sql)) {
//            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
//            connection.setAutoCommit(false);
//            fillStatement(company, ps);
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public List<Company> read() {
        List<Company> companyList = new ArrayList<Company>();

        String sql = SQLQueryUtil.getQuery("companies", CrudUtil.READ, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs  = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getInt("id"));
                company.setName(rs.getString("name"));
                company.setFullName(rs.getString("fullName"));
                company.setCity(rs.getString("city"));
                company.setIdentificationCode(rs.getString("identificationCode"));
                companyList.add(company);
            }
            return companyList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Company company) {
        String sql = SQLQueryUtil.getQuery("companies", CrudUtil.UPDATE, company.getId());
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(company, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = SQLQueryUtil.getQuery("companies", CrudUtil.DELETE, id);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Company getById(int id) {
        String sql = SQLQueryUtil.GET_COMPANY_BY_ID;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Company company = new Company();
                company.setId(rs.getInt("id"));
                company.setName(rs.getString("name"));
                company.setFullName(rs.getString("fullName"));
                company.setCity(rs.getString("city"));
                company.setIdentificationCode(rs.getString("identificationCode"));
                return company;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Customer> getCustomers(int companyId) {
        List<Customer> customerList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_CUSTOMERS_BY_COMPANY;
        JdbcCustomerDaoImpl jdbcCustomerDaoImpl = JdbcCustomerDaoImpl.getInstance();

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, companyId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customerList.add(jdbcCustomerDaoImpl.getById(rs.getInt("customer")));
            }
            return customerList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCustomer(int customerId, int companyId) {
        String sql = SQLQueryUtil.ADD_CUSTOMER_TO_COMPANY;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, companyId);
            ps.setInt(2, customerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

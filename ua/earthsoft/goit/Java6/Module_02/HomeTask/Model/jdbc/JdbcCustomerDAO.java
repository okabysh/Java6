package earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc;

import earthsoft.goit.Java6.Module_02.HomeTask.Model.Customer;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.ICustomerDAO;
import earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;
import earthsoft.goit.Java6.Module_02.HomeTask.Other.Constants;
import earthsoft.goit.Java6.Module_02.HomeTask.Other.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Kabysh on 02.07.2017.
 */
public class JdbcCustomerDAO implements ICustomerDAO{
    SQLQuery sqlQuery = new SQLQuery();

    @Override
    public void create(Customer customer) {
        String sql = sqlQuery.getQuery("customers", CRUD.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(customer, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> read() {
        List<Customer> customerList = new ArrayList<Customer>();

        String sql = sqlQuery.getQuery("customers", CRUD.READ, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
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
        String sql = sqlQuery.getQuery("customers", CRUD.UPDATE, customer.getId());
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(customer, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = sqlQuery.getQuery("customers", CRUD.DELETE, id);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
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

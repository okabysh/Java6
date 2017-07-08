package ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.Company;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.ICompanyDAO;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.Constants;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg Kabysh on 30.06.2017.
 */
public class JdbcCompanyDAO implements ICompanyDAO {
    SQLQuery sqlQuery = new SQLQuery();

    @Override
    public void create(Company company) {
        String sql = sqlQuery.getQuery("companies", CRUD.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(company, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Company> read() {
        List<Company> companyList = new ArrayList<Company>();

        String sql = sqlQuery.getQuery("companies", CRUD.READ, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
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
        String sql = sqlQuery.getQuery("companies", CRUD.UPDATE, company.getId());
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(company, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = sqlQuery.getQuery("companies", CRUD.DELETE, id);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
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

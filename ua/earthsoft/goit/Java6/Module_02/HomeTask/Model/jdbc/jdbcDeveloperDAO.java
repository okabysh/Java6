package earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc;

import earthsoft.goit.Java6.Module_02.HomeTask.Other.*;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class jdbcDeveloperDAO implements IDeveloperDAO {
    SQLQuery sqlQuery = new SQLQuery();

    @Override
    public void create(Developer dev) {
        String sql = sqlQuery.getQuery("developers", CRUD.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(dev, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Developer> read() {
        List<Developer> developerList = new ArrayList<Developer>();

        String sql = sqlQuery.getQuery("developers", CRUD.READ, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet rs  = statement.executeQuery(sql))
            {
                while (rs.next()) {
                    Developer developer = new Developer();
                    developer.setId(rs.getInt("id"));
                    developer.setFirstName(rs.getString("firstName"));
                    developer.setSurName(rs.getString("surName"));
                    developer.setIdentificationCode(rs.getString("identificationCode"));
                    developer.setBirthday(rs.getDate("birthday"));
                    developer.setPhone(rs.getString("phone"));
                    developer.setSalary(rs.getBigDecimal("salary"));
                    developerList.add(developer);
                }
                return developerList;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        return null;
    }

    @Override
    public void update(Developer dev) {
        String sql = sqlQuery.getQuery("developers", CRUD.UPDATE, dev.getId());
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(dev, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = sqlQuery.getQuery("developers", CRUD.DELETE, id);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             Statement statement = connection.createStatement())
            {statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillStatement(Developer dev, PreparedStatement ps) throws SQLException {
        ps.setString(1, dev.getFirstName() + " " + dev.getSurName());
        ps.setString(2, dev.getFirstName());
        ps.setString(3, dev.getSurName());
        ps.setString(4, dev.getIdentificationCode());
        ps.setDate(5, dev.getBirthday());
        ps.setString(6, dev.getPhone());
        ps.setBigDecimal(7, dev.getSalary());
        ps.executeUpdate();
    }
}

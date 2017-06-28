package earthsoft.goit.Java6.Module_02.HomeTask.model.jdbc;

import earthsoft.goit.Java6.Module_02.HomeTask.Ather.*;
import earthsoft.goit.Java6.Module_02.HomeTask.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class jdbcDeveloperDAO implements IDeveloperDAO {
    SQLQuery sqlQuery = new SQLQuery();

    public void create(Developer dev) {
        String sql = sqlQuery.getQuery("developers", CRUD.CREATE);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dev.getFirstName() + " " + dev.getSurName());
            ps.setString(2, dev.getFirstName());
            ps.setString(3, dev.getSurName());
            ps.setString(4, dev.getIdentificationCode());
            ps.setDate(5, dev.getBirthday());
            ps.setString(6, dev.getPhone());
            ps.setBigDecimal(7, dev.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Developer> read() {
        List<Developer> developerList = new ArrayList<Developer>();

        String sql = sqlQuery.getQuery("developers", CRUD.READ);
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

    public void update(Developer developer) {

    }

    public void delete(int id) {
        String sql = sqlQuery.getQuery("developers", CRUD.DELETE);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, dev.getFirstName() + " " + dev.getSurName());
            ps.setString(2, dev.getFirstName());
            ps.setString(3, dev.getSurName());
            ps.setString(4, dev.getIdentificationCode());
            ps.setDate(5, dev.getBirthday());
            ps.setString(6, dev.getPhone());
            ps.setBigDecimal(7, dev.getSalary());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

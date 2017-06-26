package earthsoft.goit.Java6.Module_02.HomeTask.model.jdbc;

import earthsoft.goit.Java6.Module_02.HomeTask.Constants;
import earthsoft.goit.Java6.Module_02.HomeTask.model.Developer;
import earthsoft.goit.Java6.Module_02.HomeTask.model.IDeveloperDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class jdbcDeveloperDAO implements IDeveloperDAO{

    public void create(Developer dev) {
        Connection connection = null;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
            String sql = "INSERT INTO developers " +
                    "(fullName, firstName, surName, identificationCode, birthday, phone, salary) " +
                    "VALUES (?,?,?,?,?,?,?)"  ;
            ps = connection.prepareStatement(sql);
            ps.setString(1, dev.getFirstName() + " " + dev.getSurName());
            ps.setString(2, dev.getFirstName());
            ps.setString(3, dev.getSurName());
            ps.setString(4, dev.getIdentificationCode());
            ps.setDate(5, dev.getBirthday());
            ps.setString(6, dev.getPhone());
            ps.setBigDecimal(7, dev.getSalary());
            int result = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Developer> read() {
        Statement statement = null;
        List<Developer> developerList = new ArrayList<Developer>();
            try {
                Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
                String sql = "SELECT * FROM developers";
                statement = connection.createStatement();
                ResultSet rs  = statement.executeQuery(sql);
                while (rs.next()) {
                    Developer developer = new Developer();
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

    public void delete(Developer developer) {

    }
}

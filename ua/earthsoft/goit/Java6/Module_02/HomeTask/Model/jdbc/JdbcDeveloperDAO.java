package ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.*;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class JdbcDeveloperDAO implements IDeveloperDAO {
    SQLQuery sqlQuery = new SQLQuery();

    @Override
    public void create(Developer developer) {
        String sql = sqlQuery.getQuery("developers", CRUD.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(developer, ps);
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
    public void update(Developer developer) {
        String sql = sqlQuery.getQuery("developers", CRUD.UPDATE, developer.getId());
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(developer, ps);
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

    @Override
    public Developer getById(int id) {
        String sql = SQLQuery.GET_DEVELOPER_BY_ID;

        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Developer developer = new Developer();
                developer.setId(rs.getInt("id"));
                developer.setFirstName(rs.getString("firstName"));
                developer.setSurName(rs.getString("surName"));
                developer.setIdentificationCode(rs.getString("identificationCode"));
                developer.setBirthday(rs.getDate("birthday"));
                developer.setPhone(rs.getString("phone"));
                developer.setSalary(rs.getBigDecimal("salary"));
                return developer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Skill> getSkillsByDeveloper(int developerId) {
        List<Skill> skillList = new ArrayList<>();
        String sql = SQLQuery.GET_SKILLS_BY_DEVELOPER;
        JdbcSkillDAO jdbcSkillDAO = new JdbcSkillDAO();

        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
             //   Statement ps = connection.createStatement();)
        { ps.setInt(1, developerId);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Skill skill = new Skill();
                    skillList.add(jdbcSkillDAO.getById(rs.getInt("skill")));
                }
            return skillList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addSkillByDeveloper(int developerId, int skillId) {
        String sql = SQLQuery.ADD_SKILL_BY_DEVELOPER;
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, developerId);
            ps.setInt(2, skillId);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSkillByDeveloper(int developerId, int skillId) {
        String sql = SQLQuery.DELETE_SKILL_BY_DEVELOPER;
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, developerId);
            ps.setInt(2, skillId);
            ResultSet rs = ps.executeQuery();
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

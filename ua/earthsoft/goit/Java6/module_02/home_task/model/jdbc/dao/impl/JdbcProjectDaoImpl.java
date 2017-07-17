package ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl;

import ua.earthsoft.goit.Java6.module_02.home_task.model.*;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.IProjectDAO;
import ua.earthsoft.goit.Java6.module_02.home_task.util.CrudUtil;
import ua.earthsoft.goit.Java6.module_02.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_02.home_task.util.SQLQueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public class JdbcProjectDaoImpl implements IProjectDAO {
    SQLQueryUtil sqlQueryUtil = new SQLQueryUtil();

    @Override
    public void create(Project project) {
        String sql = sqlQueryUtil.getQuery("projects", CrudUtil.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(project, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> read() {
        List<Project> projectList = new ArrayList<Project>();

        String sql = sqlQueryUtil.getQuery("projects", CrudUtil.READ, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs  = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setCost(rs.getBigDecimal("cost"));
                projectList.add(project);
            }
            return projectList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Project project) {
        String sql = sqlQueryUtil.getQuery("projects", CrudUtil.UPDATE, project.getId());
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(project, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = sqlQueryUtil.getQuery("projects", CrudUtil.DELETE, id);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getById(int id) {
        String sql = SQLQueryUtil.GET_PROJECT_BY_ID;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Project project = new Project();
                project.setId(rs.getInt("id"));
                project.setName(rs.getString("name"));
                project.setCost(rs.getBigDecimal("cost"));
                return project;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Developer> getDevelopers(int projectId) {
        List<Developer> developerList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_DEVELOPERS_BY_PROJECT;
        JdbcDeveloperDaoImpl jdbcDeveloperDaoImpl = new JdbcDeveloperDaoImpl();

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, projectId);
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
    public List<Skill> getSkills(int developerId) {
        List<Skill> skillList = new ArrayList<>();
        String sql = SQLQueryUtil.GET_SKILLS_BY_DEVELOPER;
        JdbcSkillDaoImpl jdbcSkillDaoImpl = new JdbcSkillDaoImpl();

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, developerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                skillList.add(jdbcSkillDaoImpl.getById(rs.getInt("skill")));
            }
            return skillList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void fillStatement(Project project, PreparedStatement ps) throws SQLException {
        ps.setString(1, project.getName());
        ps.setBigDecimal(2, project.getCost());
        ps.executeUpdate();
    }
}

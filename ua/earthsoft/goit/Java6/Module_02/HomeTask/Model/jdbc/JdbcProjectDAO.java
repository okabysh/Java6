package ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.Customer;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.Developer;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.IProjectDAO;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.Project;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.Constants;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.SQLQuery;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public class JdbcProjectDAO implements IProjectDAO {
    SQLQuery sqlQuery = new SQLQuery();

    @Override
    public void create(Project project) {
        String sql = sqlQuery.getQuery("projects", CRUD.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(project, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Project> read() {
        List<Project> projectList = new ArrayList<Project>();

        String sql = sqlQuery.getQuery("projects", CRUD.READ, 0);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
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
        String sql = sqlQuery.getQuery("projects", CRUD.UPDATE, project.getId());
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(project, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = sqlQuery.getQuery("projects", CRUD.DELETE, id);
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Project getById(int id) {
        String sql = SQLQuery.GET_PROJECT_BY_ID;

        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
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
        String sql = SQLQuery.GET_DEVELOPERS_BY_PROJECT;
        JdbcDeveloperDAO jdbcDeveloperDAO = new JdbcDeveloperDAO();

        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                developerList.add(jdbcDeveloperDAO.getById(rs.getInt("developer")));
            }
            return developerList;
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

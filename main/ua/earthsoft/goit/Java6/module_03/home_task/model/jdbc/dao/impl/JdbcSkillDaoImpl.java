package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.ISkillDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Skill;
import ua.earthsoft.goit.Java6.module_03.home_task.util.CrudUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.ConstantsUtil;
import ua.earthsoft.goit.Java6.module_03.home_task.util.SQLQueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public class JdbcSkillDaoImpl implements ISkillDAO {
    public static final JdbcSkillDaoImpl instance = new JdbcSkillDaoImpl();

    private JdbcSkillDaoImpl() {}

    public static JdbcSkillDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void create(Skill skill) {
        String sql = SQLQueryUtil.getQuery("skills", CrudUtil.CREATE, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(skill, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Skill> read() {
        List<Skill> skillList = new ArrayList<Skill>();

        String sql = SQLQueryUtil.getQuery("skills", CrudUtil.READ, 0);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs  = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Skill skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("name"));
                skillList.add(skill);
            }
            return skillList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Skill skill) {
        String sql = SQLQueryUtil.getQuery("skills", CrudUtil.UPDATE, skill.getId());
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql)) {
            fillStatement(skill, ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = SQLQueryUtil.getQuery("skills", CrudUtil.DELETE, id);
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             Statement statement = connection.createStatement())
        {statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill getById(int id) {
        String sql = SQLQueryUtil.GET_SKILL_BY_ID;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Skill skill = new Skill();
                skill.setId(rs.getInt("id"));
                skill.setName(rs.getString("name"));
                return skill;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void fillStatement(Skill skill, PreparedStatement ps) throws SQLException {
        ps.setString(1, skill.getName());
        ps.executeUpdate();
    }
}

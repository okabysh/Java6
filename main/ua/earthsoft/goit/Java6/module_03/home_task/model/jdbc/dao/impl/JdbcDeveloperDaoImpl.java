package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.IDeveloperDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.util.*;
import ua.earthsoft.goit.Java6.module_03.home_task.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class JdbcDeveloperDaoImpl implements IDeveloperDAO {
    public static final JdbcDeveloperDaoImpl instance = new JdbcDeveloperDaoImpl();

    private JdbcDeveloperDaoImpl() {}

    public static JdbcDeveloperDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void create(Developer developer) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(developer);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Developer> read() {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Developer> developerList = (List<Developer>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Developer").list();
            return developerList;
        } catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void update(Developer developer) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Developer developerForUpdate = (Developer) session.get(Developer.class, developer.getId());
            developerForUpdate.setFirstName(developer.getFirstName());
            developerForUpdate.setSurName(developer.getSurName());
            developerForUpdate.setIdentificationCode(developer.getIdentificationCode());
            developerForUpdate.setBirthday(developer.getBirthday());
            developerForUpdate.setPhone(developer.getPhone());
            developerForUpdate.setSalary(developer.getSalary());
            session.update(developerForUpdate);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(int id) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Developer developerForDelete = (Developer) session.get(Developer.class, id);
            session.delete(developerForDelete);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Developer getById(int id) {
        String sql = SQLQueryUtil.GET_DEVELOPER_BY_ID;

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
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
        String sql = SQLQueryUtil.GET_SKILLS_BY_DEVELOPER;
        JdbcSkillDaoImpl jdbcSkillDaoImpl = JdbcSkillDaoImpl.getInstance();

        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
             //   Statement ps = connection.createStatement();)
        { ps.setInt(1, developerId);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Skill skill = new Skill();
                    skillList.add(jdbcSkillDaoImpl.getById(rs.getInt("skill")));
                }
            return skillList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addSkillByDeveloper(int developerId, int skillId) {
        String sql = SQLQueryUtil.ADD_SKILL_TO_DEVELOPER;
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, developerId);
            ps.setInt(2, skillId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSkillByDeveloper(int developerId, int skillId) {
        String sql = SQLQueryUtil.DELETE_SKILL_FROM_DEVELOPER;
        try (Connection connection = DriverManager.getConnection(ConstantsUtil.DATABASE_URL, ConstantsUtil.USER, ConstantsUtil.PASSWORD);
             PreparedStatement ps = connection.prepareStatement(sql))
        { ps.setInt(1, developerId);
            ps.setInt(2, skillId);
            ps.executeUpdate();
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

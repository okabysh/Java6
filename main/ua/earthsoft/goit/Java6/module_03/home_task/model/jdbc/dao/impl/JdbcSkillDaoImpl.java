package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Company;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Project;
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
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(skill);
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
    public List<Skill> read() {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Skill> skillList = (List<Skill>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Skill").list();
            return skillList;
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
    public void update(Skill skill) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Skill skillForUpdate = (Skill) session.get(Skill.class, skill.getId());
            skillForUpdate.setName(skill.getName());
            session.update(skillForUpdate);
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
            Skill skillForDelete = (Skill) session.get(Skill.class, id);
            session.delete(skillForDelete);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
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

package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.ISkillDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Skill;
import ua.earthsoft.goit.Java6.module_03.home_task.util.QueryUtil;

import java.util.Iterator;
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
        String sql = QueryUtil.GET_SKILL_BY_ID;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, id);
            query.addEntity(Skill.class);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                Skill skill = (Skill) iterator.next();
                return skill;
            }
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
}

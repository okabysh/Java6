package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.earthsoft.goit.Java6.module_03.home_task.Launch;
import ua.earthsoft.goit.Java6.module_03.home_task.model.*;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.IProjectDAO;
import ua.earthsoft.goit.Java6.module_03.home_task.util.QueryUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public class JdbcProjectDaoImpl implements IProjectDAO {
    public static final JdbcProjectDaoImpl instance = new JdbcProjectDaoImpl();

    private JdbcProjectDaoImpl() {}

    public static JdbcProjectDaoImpl getInstance() {
        return instance;
    }

    @Override
    public void create(Project project) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(project);
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
    public List<Project> read() {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<Project> projectList = (List<Project>) session.createQuery("FROM ua.earthsoft.goit.Java6.module_03.home_task.model.Project").list();
            return projectList;
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
    public void update(Project project) {
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Project projectForUpdate = (Project) session.get(Project.class, project.getId());
            projectForUpdate.setName(project.getName());
            projectForUpdate.setCost(project.getCost());
            session.update(projectForUpdate);
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
            Project projectForDelete = (Project) session.get(Project.class, id);
            session.delete(projectForDelete);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Project getById(int id) {
        String sql = QueryUtil.GET_PROJECT_BY_ID;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, id);
            query.addEntity(Project.class);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                Project project = (Project) iterator.next();
                return project;
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

    @Override
    public List<Developer> getDevelopersByProject(int id) {
        List<Developer> developerList = new ArrayList<>();
        String sql = QueryUtil.GET_DEVELOPERS_BY_PROJECT;
        Session session = Launch.factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            SQLQuery query = session.createSQLQuery(sql);
            query.setInteger(0, id);
            query.addEntity(Developer.class);
            List result = query.list();
            tx.commit();
            for (Iterator iterator = result.iterator(); iterator.hasNext();){
                developerList.add((Developer) iterator.next());
            }
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

    private void fillStatement(Project project, PreparedStatement ps) throws SQLException {
        ps.setString(1, project.getName());
        ps.setBigDecimal(2, project.getCost());
        ps.executeUpdate();
    }
}

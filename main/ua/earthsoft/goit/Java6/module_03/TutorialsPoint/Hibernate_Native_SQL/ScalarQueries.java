package ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Native_SQL;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Associations.XML._1_One_to_One.Address_A1;
import ua.earthsoft.goit.Java6.module_03.TutorialsPoint.Hibernate_Component_Mappings.Employee_A5;

import java.util.List;

/**
 * Created by Oleg Kabysh on 04.08.2017.
 */
public class ScalarQueries {
    private static SessionFactory factory;
    public static void main(String[] args) {
        try {
            factory = new Configuration().
                    configure("ua/earthsoft/goit/Java6/module_03/TutorialsPoint/Hibernate_Native_SQL/resources/hibernate_NativeSQL.cfg.xml").
                    buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();

            String sql = "SELECT first_name, salary FROM ts_a1_employee";
            SQLQuery query = session.createSQLQuery(sql);
            query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
            List results = query.list();

            for (Object employee: results) {
                System.out.println(employee.toString());
            }

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();

        }finally {
            session.close();
        }

    }
}
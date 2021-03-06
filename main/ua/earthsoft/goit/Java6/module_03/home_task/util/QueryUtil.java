package ua.earthsoft.goit.Java6.module_03.home_task.util;

/**
 * Created by Oleg Kabysh on 28.06.2017.
 */
public class QueryUtil {
    public static final String SQL_GET_COMPANY_BY_ID = "SELECT * FROM companies WHERE id = ?";
    public static final String HQL_GET_COMPANY_BY_ID = "FROM Company WHERE id = :parameter";
    public static final String ADD_CUSTOMER_TO_COMPANY = "INSERT INTO mtm_company_customer VALUES(?, ?)";
    public static final String DELETE_CUSTOMER_FROM_COMPANY = "DELETE FROM mtm_company_customer WHERE company=? AND customer=?";
    public static final String ADD_PROJECT_TO_CUSTOMER = "INSERT INTO mtm_customer_project VALUES(?, ?)";
    public static final String DELETE_PROJECT_FROM_CUSTOMER = "DELETE FROM mtm_customer_project WHERE customer=? AND project=?";
    public static final String GET_SKILL_BY_ID = "SELECT * FROM skills WHERE id = ?";
    public static final String HQL_GET_SKILL_BY_ID = "FROM Skill WHERE id = :parameter";
    //public static final String GET_SKILLS_BY_DEVELOPER = "SELECT skill FROM mtm_developer_skill WHERE developer = ?";
    public static final String GET_SKILLS_BY_DEVELOPER = "SELECT * FROM skills WHERE id IN (SELECT skill FROM mtm_developer_skill WHERE developer = ? GROUP BY skill)";
    public static final String ADD_SKILL_TO_DEVELOPER = "INSERT INTO mtm_developer_skill VALUES(?, ?)";
    public static final String DELETE_SKILL_FROM_DEVELOPER = "DELETE FROM mtm_developer_skill WHERE developer = ? AND skill = ?";
    public static final String SQL_GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    public static final String HQL_GET_CUSTOMER_BY_ID = "FROM Customer WHERE id = :parameter";
    //public static final String GET_CUSTOMERS_BY_COMPANY = "SELECT customer FROM mtm_company_customer WHERE company = ?";
    public static final String GET_CUSTOMERS_BY_COMPANY = "SELECT * FROM customers WHERE id IN (SELECT customer FROM mtm_company_customer WHERE company = ? GROUP BY customer)";
    public static final String GET_PROJECT_BY_ID = "SELECT * FROM projects WHERE id = ?";
    public static final String HQL_GET_PROJECT_BY_ID = "FROM Project WHERE id = :parameter";
    //public static final String GET_PROJECTS_BY_CUSTOMER = "SELECT project FROM mtm_customer_project WHERE customer = ?";
    public static final String GET_PROJECTS_BY_CUSTOMER = "SELECT * FROM projects WHERE id IN (SELECT project FROM mtm_customer_project WHERE customer = ? GROUP BY project)";
    public static final String GET_DEVELOPER_BY_ID = "SELECT * FROM developers WHERE id = ?";
    public static final String HQL_GET_DEVELOPER_BY_ID = "FROM Developers WHERE id = :parameter";
    public static final String GET_DEVELOPERS_BY_CUSTOMER = "SELECT developer FROM mtm_customer_project_developer WHERE customer = ? GROUP BY developer";
    //public static final String GET_DEVELOPERS_BY_PROJECT = "SELECT developer FROM mtm_customer_project_developer WHERE project = ? GROUP BY developer";
    public static final String GET_DEVELOPERS_BY_PROJECT = "SELECT * FROM developers WHERE id IN (SELECT developer FROM mtm_customer_project_developer WHERE project = ? GROUP BY developer)";

    private QueryUtil() {}

    public static String getQuery(String tableName, CrudUtil crudUtil, int id) {
        String sql = "";
        String CreateColumnsNames = "";
        String CreateColumnsValues = "";
        String UpdateColumnsNames = "";

        if (crudUtil == CrudUtil.CREATE) {
            sql = "INSERT INTO [TABLE] [COLUMNS] VALUES [VALUES]";
            sql = sql.replace("[TABLE]",tableName);
            if (tableName == "developers") {
                CreateColumnsNames = "(fullName, firstName, surName, identificationCode, birthday, phone, salary)";
                CreateColumnsValues = "(?,?,?,?,?,?,?)";
            } else if (tableName == "companies") {
                CreateColumnsNames = "(name, fullName, city, identificationCode)";
                CreateColumnsValues = "(?,?,?,?)";
            } else if (tableName == "skills") {
                CreateColumnsNames = "(name)";
                CreateColumnsValues = "(?)";
            } else if (tableName == "projects") {
                CreateColumnsNames = "(name, cost)";
                CreateColumnsValues = "(?, ?)";
            } else if (tableName == "customers") {
                CreateColumnsNames = "(name, identificationCode, phone)";
                CreateColumnsValues = "(?, ?, ?)";
            }
            sql = sql.replace("[COLUMNS]", CreateColumnsNames);
            sql = sql.replace("[VALUES]", CreateColumnsValues);

        } else if (crudUtil == CrudUtil.READ) {
            sql = "SELECT * FROM [TABLE]";
            sql = sql.replace("[TABLE]",tableName);

        }  else if (crudUtil == CrudUtil.UPDATE) {
            if (tableName == "developers") {
                UpdateColumnsNames = "fullName=?, firstName=?, surName=?, identificationCode=?, birthday=?, phone=?, salary=?";
            } else if (tableName == "companies") {
                UpdateColumnsNames = "name=?, fullName=?, city=?, identificationCode=?";
            } else if (tableName == "skills") {
                UpdateColumnsNames = "name=?";
            } else if (tableName == "projects") {
                UpdateColumnsNames = "name=?, cost=?";
            } else if (tableName == "customers") {
                UpdateColumnsNames = "name=?, identificationCode=?, phone=?";
            }
            sql = "UPDATE [TABLE] SET [COLUMNS] WHERE id = [ID]";
            sql = sql.replace("[TABLE]",tableName);
            sql = sql.replace("[COLUMNS]",UpdateColumnsNames);
            sql = sql.replace("[ID]",String.valueOf(id));

        } else if (crudUtil == CrudUtil.DELETE) {
            sql = "DELETE FROM [TABLE] WHERE id = [ID]";
            sql = sql.replace("[TABLE]",tableName);
            sql = sql.replace("[ID]",String.valueOf(id));
        }
        return sql;
    }
}

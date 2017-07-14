package ua.earthsoft.goit.Java6.Module_02.HomeTask.Other;

/**
 * Created by Oleg Kabysh on 28.06.2017.
 */
public class SQLQuery {
    public static final String EMPTY = "";
    public static final String GET_COMPANY_BY_ID = "SELECT * FROM companies WHERE id = ?";
    public static final String GET_SKILL_BY_ID = "SELECT * FROM skills WHERE id = ?";
    public static final String GET_SKILLS_BY_DEVELOPER = "SELECT skill FROM mtm_developer_skill WHERE developer = ?";
    public static final String ADD_SKILL_BY_DEVELOPER = "INSERT INTO mtm_developer_skill VALUES(?, ?)";
    public static final String DELETE_SKILL_BY_DEVELOPER = "DELETE FROM mtm_developer_skill WHERE developer = ? AND skill = ?";
    public static final String GET_CUSTOMER_BY_ID = "SELECT * FROM customers WHERE id = ?";
    public static final String GET_CUSTOMERS_BY_COMPANY = "SELECT customer FROM mtm_company_customer WHERE company = ?";
    public static final String GET_PROJECT_BY_ID = "SELECT * FROM projects WHERE id = ?";
    public static final String GET_PROJECTS_BY_CUSTOMER = "SELECT project FROM mtm_customer_project WHERE customer = ?";
    public static final String GET_DEVELOPER_BY_ID = "SELECT * FROM developers WHERE id = ?";
    public static final String GET_DEVELOPERS_BY_CUSTOMER = "SELECT developer FROM mtm_customer_project_developer WHERE customer = ? GROUP BY developer";
    public static final String GET_DEVELOPERS_BY_PROJECT = "SELECT developer FROM mtm_customer_project_developer WHERE project = ? GROUP BY developer";

    public String getQuery(String tableName, CRUD crud, int id) {
        String sql = "";
        String CreateColumnsNames = "";
        String CreateColumnsValues = "";
        String UpdateColumnsNames = "";

        if (crud == CRUD.CREATE) {
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

        } else if (crud == CRUD.READ) {
            sql = "SELECT * FROM [TABLE]";
            sql = sql.replace("[TABLE]",tableName);

        }  else if (crud == CRUD.UPDATE) {
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

        } else if (crud == CRUD.DELETE) {
            sql = "DELETE FROM [TABLE] WHERE id = [ID]";
            sql = sql.replace("[TABLE]",tableName);
            sql = sql.replace("[ID]",String.valueOf(id));
        }
        return sql;
    }
}

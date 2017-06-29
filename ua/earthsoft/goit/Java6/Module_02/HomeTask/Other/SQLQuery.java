package earthsoft.goit.Java6.Module_02.HomeTask.Other;

/**
 * Created by Oleg Kabysh on 28.06.2017.
 */
public class SQLQuery {
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
            }
            sql = sql.replace("[COLUMNS]", CreateColumnsNames);
            sql = sql.replace("[VALUES]", CreateColumnsValues);

        } else if (crud == CRUD.READ) {
            sql = "SELECT * FROM [TABLE]";
            sql = sql.replace("[TABLE]",tableName);

        }  else if (crud == CRUD.UPDATE) {
            if (tableName == "developers") {
                UpdateColumnsNames = "fullName=?, firstName=?, surName=?, identificationCode=?, birthday=?, phone=?, salary=?";
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

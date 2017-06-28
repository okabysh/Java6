package earthsoft.goit.Java6.Module_02.HomeTask.Ather;

/**
 * Created by Oleg Kabysh on 28.06.2017.
 */
public class SQLQuery {
    String sql = null;
    String developerColumnsNames = "(fullName, firstName, surName, identificationCode, birthday, phone, salary)";
    String developerColumnsValues = "(?,?,?,?,?,?,?)";

    public String getQuery(String tableName, CRUD crud) {
        if (crud == CRUD.READ) {
            sql = "SELECT * FROM [TABLE]";
            sql = sql.replace("[TABLE]",tableName);
        } else if (crud == CRUD.CREATE) {
            sql = "INSERT INTO [TABLE] [COLUMNS] VALUES [VALUES]";
            sql = sql.replace("[TABLE]",tableName);
            if (tableName == "developers") {
                sql = sql.replace("[COLUMNS]", developerColumnsNames);
                sql = sql.replace("[VALUES]", developerColumnsValues);
            }
        } else if (crud == CRUD.CREATE) {
            sql = "DELETE FROM [TABLE] WHERE id = [id]";
        }
        return sql;
    }
}

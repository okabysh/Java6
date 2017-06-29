package earthsoft.goit.Java6.Module_02.HomeTask.Ather;

/**
 * Created by Oleg Kabysh on 28.06.2017.
 */
public class SQLQuery {
    String sql = null;
    String developerCreateColumnsNames = "(fullName, firstName, surName, identificationCode, birthday, phone, salary)";
    String developerCreateColumnsValues = "(?,?,?,?,?,?,?)";
    String developerUpdateColumnsNames = "fullName=?, firstName=?, surName=?, identificationCode=?, birthday=?, phone=?, salary=?";

    public String getQuery(String tableName, CRUD crud, int id) {
        if (crud == CRUD.READ) {
            sql = "SELECT * FROM [TABLE]";
            sql = sql.replace("[TABLE]",tableName);
        } else if (crud == CRUD.CREATE) {
            sql = "INSERT INTO [TABLE] [COLUMNS] VALUES [VALUES]";
            sql = sql.replace("[TABLE]",tableName);
            if (tableName == "developers") {
                sql = sql.replace("[COLUMNS]", developerCreateColumnsNames);
                sql = sql.replace("[VALUES]", developerCreateColumnsValues);
            }
        } else if (crud == CRUD.DELETE) {
            sql = "DELETE FROM [TABLE] WHERE id = [ID]";
            sql = sql.replace("[TABLE]",tableName);
            sql = sql.replace("[ID]",String.valueOf(id));
        } else if (crud == CRUD.UPDATE) {
            sql = "UPDATE [TABLE] SET [COLUMNS] WHERE id = [ID]";
            sql = sql.replace("[TABLE]",tableName);
            sql = sql.replace("[COLUMNS]",developerUpdateColumnsNames);
            sql = sql.replace("[ID]",String.valueOf(id));
        }
        return sql;
    }
}

package earthsoft.goit.Java6.Module_02.Mrachkovskiy.HomeTask.Branch1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class DeveloperDAO {
    public boolean create(Developer dev, Connection connection) {
        Statement statement = null;
        //ResultSet resultSet = 0;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        if (statement != null) {
            String sql = "INSERT INTO developers (fullName, firstName, surName, identificationCode, birthday, phone, salary) VALUES " +
                    "(\"" + dev.getFirstName() + " " + dev.getSurName() + "\",\"" + dev.getFirstName() + "\",\"" + dev.getSurName() +
                    "\",\"" + dev.getIdentificationCode() + "\",\'" + dev.getBirthday() + "\',\"" + dev.getPhone() + "\","+ dev.getSalary() + ")";
            try {
                int result = statement.executeUpdate(sql);
                if (result>0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return true;
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return true;
            }
        }
//        if (resultSet != null) {
//            try {
//                resultSet.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//                return true;
//            }
//        }
        return true;
    }
}
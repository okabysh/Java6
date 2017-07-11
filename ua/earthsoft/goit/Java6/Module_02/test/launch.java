/*
package ua.earthsoft.goit.Java6.Module_02.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

*/
/**
 * Created by Oleg Kabysh on 02.07.2017.
 *//*

public class launch {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String sql = "select * from ";
        try (Connection connection = DriverManager.getConnection(Constants.DATABASE_URL, Constants.USER, Constants.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs  = statement.executeQuery(sql))
        {
            while (rs.next()) {
                Company company = new Company();
                company.setId(rs.getInt("id"));
                company.setName(rs.getString("name"));
                company.setFullName(rs.getString("fullName"));
                company.setCity(rs.getString("city"));
                company.setIdentificationCode(rs.getString("identificationCode"));
                companyList.add(company);
            }
            return companyList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
*/

package earthsoft.goit.Java6.Module_02.HomeTask;

import earthsoft.goit.Java6.Module_02.HomeTask.model.Developer;
import earthsoft.goit.Java6.Module_02.HomeTask.model.jdbc.jdbcDeveloperDAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Launch {
    public static void main(String[] args) {
        LoadDriver loadDriver = new LoadDriver();
        Connection connection = loadDriver.getConnection();

        // Вопрос пользователю: хочешь ли ты создать девелопера?
        // Пользователь, да.
        // Вопрос пользователю: Введи Имя, Фамилию, ИНН, Дату рождения, телефон, зарплату
        // вносим все что ввели в класс Developer
        Developer developer = new Developer("Ivan","Tsarevich", "3232323232",
                Date.valueOf("1990-01-01"), "+380670001122", new BigDecimal("1500.00"));

        jdbcDeveloperDAO jdbcDeveloperDAO = new jdbcDeveloperDAO();
        jdbcDeveloperDAO.create(developer, connection);



    }

}

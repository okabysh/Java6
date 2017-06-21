package earthsoft.goit.Java6.Module_02.Mrachkovskiy.HomeTask.Branch1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;

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
                new Date(), "+380670001122", new BigDecimal("1500.00"));

        DeveloperDAO developerDAO = new DeveloperDAO();
        developerDAO.create(developer, connection);



    }

}

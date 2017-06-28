package earthsoft.goit.Java6.Module_02.HomeTask;

import earthsoft.goit.Java6.Module_02.HomeTask.Drivers.RegisterDriver;
import earthsoft.goit.Java6.Module_02.HomeTask.model.Developer;
import earthsoft.goit.Java6.Module_02.HomeTask.model.jdbc.jdbcDeveloperDAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Launch {

    public static void main(String[] args) {

        RegisterDriver registerDriver = new RegisterDriver();
        if (!registerDriver.register()) {
            System.out.println("Do not registered driver.");
            System.exit(1);
        }

        // Вопрос пользователю: хочешь ли ты создать девелопера?
        // Пользователь, да.
        // Вопрос пользователю: Введи Имя, Фамилию, ИНН, Дату рождения, телефон, зарплату
        // вносим все что ввели в класс Developer
        Developer developer = new Developer();
        developer.setFirstName("Ivan3");
        developer.setSurName("Tsarevich3");
        developer.setIdentificationCode("3232323232");
        developer.setBirthday(Date.valueOf("1990-01-01"));
        developer.setPhone("+380670001122");
        developer.setSalary(new BigDecimal("1500.00"));

        jdbcDeveloperDAO jdbcDeveloperDAO = new jdbcDeveloperDAO();

        jdbcDeveloperDAO.create(developer);

//        List<Developer> developerList = jdbcDeveloperDAO.read();
//        for (Developer dev:developerList) {
//            System.out.println(dev.toString());
//        }

    }

}

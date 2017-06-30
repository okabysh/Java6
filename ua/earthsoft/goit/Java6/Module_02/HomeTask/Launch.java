package earthsoft.goit.Java6.Module_02.HomeTask;

import earthsoft.goit.Java6.Module_02.HomeTask.Drivers.RegisterDriver;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.Company;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.Developer;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc.*;
import earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;

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

        //String table = "companies"; CRUD crud = CRUD.CREATE; //test 5 - OK
        //String table = "companies"; CRUD crud = CRUD.READ; //test 6 - OK
        //String table = "companies"; CRUD crud = CRUD.UPDATE; //test 7 - OK
        String table = "companies"; CRUD crud = CRUD.DELETE; //test 8 - OK

        jdbcDeveloperDAO jdbcDeveloperDAO = new jdbcDeveloperDAO();
        jdbcCompanyDAO jdbcCompanyDAO = new jdbcCompanyDAO();



        // create new developer
//        Developer developer = new Developer();
//        developer.setFirstName("Ivan3");
//        developer.setSurName("Tsarevich3");
//        developer.setIdentificationCode("3232323232");
//        developer.setBirthday(Date.valueOf("1990-01-01"));
//        developer.setPhone("+380670001122");
//        developer.setSalary(new BigDecimal("1500.00"));
        //jdbcDeveloperDAO.create(developer);

        // read all developers from developers table
//        List<Developer> developerList = jdbcDeveloperDAO.read();
//        for (Developer dev:developerList) {
//            System.out.println(dev.toString());
//        }

        // update developer
//        Developer developer = new Developer();
//        developer.setId(10);
//        developer.setFirstName("Ivan4");
//        developer.setSurName("Tsarevich4");
//        developer.setIdentificationCode("3232323232");
//        developer.setBirthday(Date.valueOf("1990-04-04"));
//        developer.setPhone("+380670001144");
//        developer.setSalary(new BigDecimal("4444.00"));
//        jdbcDeveloperDAO.update(developer);

        // delete developer
//        jdbcDeveloperDAO.delete(9);


        if (table == "companies" && crud == CRUD.CREATE) {
            //test 5, create new company
            Company company = new Company();
            company.setName("EarthSoft LVIV");
            company.setFullName("EarthSoft LVIV Ltd.");
            company.setCity("LVIV");
            company.setIdentificationCode("05565846");
            jdbcCompanyDAO.create(company);

        } else if (table == "companies" && crud == CRUD.READ) {
            //test 6, read all companies from companies table
            List<Company> companyList = jdbcCompanyDAO.read();
            for (Company company : companyList) {
                System.out.println(company.toString());
            }

        } else if (table == "companies" && crud == CRUD.UPDATE) {
            //test 7, update company
            Company company = new Company();
            company.setId(3);
            company.setName("EarthSoft LVIV -up");
            company.setFullName("EarthSoft LVIV Ltd. -up");
            company.setCity("LVIV-up");
            company.setIdentificationCode("05565846-up");
            jdbcCompanyDAO.update(company);

        } else if (table == "companies" && crud == CRUD.DELETE) {
            //test 8, delete company
            jdbcCompanyDAO.delete(3);

        }


    }

}

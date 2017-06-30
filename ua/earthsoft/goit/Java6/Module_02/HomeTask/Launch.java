package earthsoft.goit.Java6.Module_02.HomeTask;

import earthsoft.goit.Java6.Module_02.HomeTask.Drivers.RegisterDriver;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.Company;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.Skill;
import earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc.*;
import earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;

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
        //String table = "companies"; CRUD crud = CRUD.DELETE; //test 8 - OK

        String table = "skills"; CRUD crud = CRUD.CREATE; //test 9 - OK
        //String table = "skills"; CRUD crud = CRUD.READ; //test 10 - OK
        //String table = "skills"; CRUD crud = CRUD.UPDATE; //test 11 - OK
        //String table = "skills"; CRUD crud = CRUD.DELETE; //test 12 - OK

        JdbcDeveloperDAO jdbcDeveloperDAO = new JdbcDeveloperDAO();
        JdbcCompanyDAO jdbcCompanyDAO = new JdbcCompanyDAO();
        JdbcSkillDAO jdbcSkillDAO = new JdbcSkillDAO();


        // create new developer
//        Developer developer = new Developer();
//        developer.setFirstName("Ivan3");
//        developer.setSurName("Tsarevich3");
//        developer.setIdentificationCode("3232323232");
//        developer.setBirthday(Date.valueOf("1990-01-01"));
//        developer.setPhone("+380670001122");
//        developer.setSalary(new BigDecimal("1500.00"));
        //JdbcDeveloperDAO.create(developer);

        // read all developers from developers table
//        List<Developer> developerList = JdbcDeveloperDAO.read();
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
//        JdbcDeveloperDAO.update(developer);

        // delete developer
//        JdbcDeveloperDAO.delete(9);


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

        } else if (table == "skills" && crud == CRUD.CREATE) {
            //test 9, create new skill
            Skill skill = new Skill();
            skill.setName("noSQL");
            jdbcSkillDAO.create(skill);

        } else if (table == "skills" && crud == CRUD.READ) {
            //test 10, read all skills from skills table
            List<Skill> skillList = jdbcSkillDAO.read();
            for (Skill skill : skillList) {
                System.out.println(skill.toString());
            }

        } else if (table == "skills" && crud == CRUD.UPDATE) {
            //test 11, update skill
            Skill skill = new Skill();
            skill.setId(13);
            skill.setName("noSQL -up");
            jdbcSkillDAO.update(skill);

        } else if (table == "skills" && crud == CRUD.DELETE) {
            //test 12, delete company
            jdbcSkillDAO.delete(13);

        }


    }

}

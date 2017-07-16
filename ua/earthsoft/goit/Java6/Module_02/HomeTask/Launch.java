package ua.earthsoft.goit.Java6.Module_02.HomeTask;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Drivers.RegisterDriver;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.*;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc.*;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.SQLQuery;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.View.Console;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Launch {

    public static void main(String[] args) throws IOException, ParseException {
        // true - it is the manual mode
        // false - it is the console mode
        //Boolean testMode = true;
        Boolean testMode = false;
        Console console = new Console();

        RegisterDriver registerDriver = new RegisterDriver();
        if (!registerDriver.register()) {
            System.out.println("Do not registered driver.");
            System.exit(1);
        }

        if (testMode) {
            // This is input data for test (uncomment only one row for "table")
            String table = "";
            CRUD crud = CRUD.READ; //Empty

            //String table = "developers"; CRUD crud = CRUD.CREATE; //test 1 - OK
            //String table = "developers"; CRUD crud = CRUD.READ; //test 2 - OK
            //String table = "developers"; CRUD crud = CRUD.UPDATE; //test 3 - OK
            //String table = "developers"; CRUD crud = CRUD.DELETE; //test 4 - OK

            //String table = "companies"; CRUD crud = CRUD.CREATE; //test 5 - OK
            //String table = "companies"; CRUD crud = CRUD.READ; //test 6 - OK
            //String table = "companies"; CRUD crud = CRUD.UPDATE; //test 7 - OK
            //String table = "companies"; CRUD crud = CRUD.DELETE; //test 8 - OK

            //String table = "skills"; CRUD crud = CRUD.CREATE; //test 9 - OK
            //String table = "skills"; CRUD crud = CRUD.READ; //test 10 - OK
            //String table = "skills"; CRUD crud = CRUD.UPDATE; //test 11 - OK
            //String table = "skills"; CRUD crud = CRUD.DELETE; //test 12 - OK

            //String table = "projects"; CRUD crud = CRUD.CREATE; //test 13 - OK
            //String table = "projects"; CRUD crud = CRUD.READ; //test 14 - OK
            //String table = "projects"; CRUD crud = CRUD.UPDATE; //test 15 - OK
            //String table = "projects"; CRUD crud = CRUD.DELETE; //test 16 - OK

            //String table = "customers"; CRUD crud = CRUD.CREATE; //test 17 - OK
            //String table = "customers"; CRUD crud = CRUD.READ; //test 18 - OK
            //String table = "customers"; CRUD crud = CRUD.UPDATE; //test 19 - OK
            //String table = "customers"; CRUD crud = CRUD.DELETE; //test 20 - OK

            // (uncomment only one row for "typeQuery")
            String typeQuery = SQLQuery.EMPTY;
            //String typeQuery = SQLQuery.GET_SKILLS_BY_DEVELOPER;
            //String typeQuery = SQLQuery.GET_CUSTOMERS_BY_COMPANY;
            //String typeQuery = SQLQuery.GET_PROJECTS_BY_CUSTOMER;
            //String typeQuery = SQLQuery.GET_DEVELOPERS_BY_PROJECT;
            //String typeQuery = SQLQuery.GET_DEVELOPERS_BY_CUSTOMER;

            JdbcDeveloperDAO jdbcDeveloperDAO = new JdbcDeveloperDAO();
            JdbcCompanyDAO jdbcCompanyDAO = new JdbcCompanyDAO();
            JdbcSkillDAO jdbcSkillDAO = new JdbcSkillDAO();
            JdbcProjectDAO jdbcProjectDAO = new JdbcProjectDAO();
            JdbcCustomerDAO jdbcCustomerDAO = new JdbcCustomerDAO();

            if (table == "") {
            } else if (table == "developers" && crud == CRUD.CREATE) {
                //test 1, create new developer
                Developer developer = new Developer();
                developer.setFirstName("John");
                developer.setSurName("Connor");
                developer.setIdentificationCode("931-72-2540");
                developer.setBirthday(Date.valueOf("1985-02-28"));
                developer.setPhone("+145721543322");
                developer.setSalary(BigDecimal.valueOf(1599.99));
                jdbcDeveloperDAO.create(developer);
            } else if (table == "developers" && crud == CRUD.READ) {
                //test 2, read all developers from developers table
                List<Developer> developerList = jdbcDeveloperDAO.read();
                for (Developer developer : developerList) {
                    System.out.println(developer.toString());
                }
            } else if (table == "developers" && crud == CRUD.UPDATE) {
                //test 3, update developer
                Developer developer = new Developer();
                developer.setId(5);
                developer.setFirstName("John-up");
                developer.setSurName("Connor-up");
                developer.setIdentificationCode("931-72-2540-up");
                developer.setBirthday(Date.valueOf("1995-02-28"));
                developer.setPhone("+145721543333");
                developer.setSalary(BigDecimal.valueOf(1600.00));
                jdbcDeveloperDAO.update(developer);
            } else if (table == "developers" && crud == CRUD.DELETE) {
                //test 4, delete developer
                jdbcDeveloperDAO.delete(5);

            } else if (table == "companies" && crud == CRUD.CREATE) {
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

            } else if (table == "projects" && crud == CRUD.CREATE) {
                //test 13, create new project
                Project project = new Project();
                project.setName("Migrate to new version Java");
                project.setCost(BigDecimal.valueOf(79499.99));
                jdbcProjectDAO.create(project);
            } else if (table == "projects" && crud == CRUD.READ) {
                //test 14, read all projects from project table
                List<Project> projectList = jdbcProjectDAO.read();
                for (Project project : projectList) {
                    System.out.println(project.toString());
                }
            } else if (table == "projects" && crud == CRUD.UPDATE) {
                //test 14, update project
                Project project = new Project();
                project.setId(12);
                project.setName("Migrate to new version Java -up");
                project.setCost(BigDecimal.valueOf(75999.99));
                jdbcProjectDAO.update(project);
            } else if (table == "projects" && crud == CRUD.DELETE) {
                //test 16, delete project
                jdbcProjectDAO.delete(13);

            } else if (table == "customers" && crud == CRUD.CREATE) {
                //test 17, create new customer
                Customer customer = new Customer();
                customer.setName("Migrate to new version Java");
                customer.setIdentificationCode("Migrate to new version Java");
                customer.setPhone("Migrate to new version Java");
                jdbcCustomerDAO.create(customer);
            } else if (table == "customers" && crud == CRUD.READ) {
                //test 18, read all customers from customer table
                List<Customer> customerList = jdbcCustomerDAO.read();
                for (Customer customer : customerList) {
                    System.out.println(customer.toString());
                }
            } else if (table == "customers" && crud == CRUD.UPDATE) {
                //test 19, update customer
                Customer customer = new Customer();
                customer.setId(12);
                customer.setName("Migrate to new version Java -up");
                customer.setIdentificationCode("Migrate to new version Java -up");
                customer.setPhone("Migrate to new version Java -up");
                jdbcCustomerDAO.update(customer);
            } else if (table == "customers" && crud == CRUD.DELETE) {
                //test 20, delete customer
                jdbcCustomerDAO.delete(13);
            }

            if (typeQuery == SQLQuery.EMPTY) {
            } else if (typeQuery == SQLQuery.GET_SKILLS_BY_DEVELOPER) {
                List<Skill> skillList = jdbcDeveloperDAO.getSkillsByDeveloper(1);
                for (Skill skill : skillList) {
                    System.out.println(skill.toString());
                }
            } else if (typeQuery == SQLQuery.GET_CUSTOMERS_BY_COMPANY) {
                List<Customer> customerList = jdbcCompanyDAO.getCustomers(2);
                for (Customer customer : customerList) {
                    System.out.println(customer.toString());
                }
            } else if (typeQuery == SQLQuery.GET_PROJECTS_BY_CUSTOMER) {
                List<Project> projectList = jdbcCustomerDAO.getProjects(1);
                for (Project project : projectList) {
                    System.out.println(project.toString());
                }
            } else if (typeQuery == SQLQuery.GET_DEVELOPERS_BY_PROJECT) {
                List<Developer> developerList = jdbcProjectDAO.getDevelopers(1);
                for (Developer developer : developerList) {
                    System.out.println(developer.toString());
                }
            } else if (typeQuery == SQLQuery.GET_DEVELOPERS_BY_CUSTOMER) {
                List<Developer> developerList = jdbcCustomerDAO.getDevelopers(1);
                for (Developer developer : developerList) {
                    System.out.println(developer.toString());
                }
            }
        } else {
            // code for console
            System.out.println("Welcome to CRUD via JDBC application!");
            console.start();
        }

    }

}

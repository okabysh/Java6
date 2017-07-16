package ua.earthsoft.goit.Java6.Module_02.HomeTask.View;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.*;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc.*;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.sql.Date;
import java.util.List;

/**
 * Created by Oleg Kabysh on 12.07.2017.
 */
public class Console {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private String chooseTable;
    private CRUD crud;

    public String inputString() throws IOException {
        return bufferedReader.readLine();
    }

    private int inputInt() throws IOException {
        int number = 0;
        try {
            number = Integer.parseInt(bufferedReader.readLine());
        }catch (NumberFormatException e){
            System.out.println("Incorrect input data! Please enter valid value (type: int).");
            inputInt();
        }
        return number;
    }

    private BigDecimal inputBigDecimal() throws IOException {
        BigDecimal number = BigDecimal.valueOf(0);
        try {
            number = BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine()));
        }catch (NumberFormatException e){
            System.out.println("Incorrect input data! Please enter valid value (type: DigDecimal).");
            inputBigDecimal();
        }
        return number;
    }

    private Date inputDate() throws IOException, ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //Date date = sdf.parse("1900-01-01");
        Date date = Date.valueOf("1900-01-01");
        try {
            date = Date.valueOf(bufferedReader.readLine());
        }catch (NumberFormatException e){
            System.out.println("Incorrect input date! Please enter valid value (type: Data[yyyy.MM.dd]).");
            inputDate();
        }
        return date;
    }

    public void start() throws IOException, ParseException {
        String mainMenu = "\n#Main menu# Please choose table: 1-Companies | 2-Customers | 3-Projects | 4-Developers | 5-Skills | 0-Exit";
        String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";

        String tableCompanies = "\n#Main menu -> table: Companies#";
        String addActionCompanies = "5-Read customers from company | 6-Add customer to company | 7-Delete customer from company";
        String tableCompaniesAction1 = "\n#Main menu -> table: Companies -> Create new company#";
        String tableCompaniesAction2 = "\n#Main menu -> table: Companies -> Read all companies#";
        String tableCompaniesAction3 = "\n#Main menu -> table: Companies -> Update company#";
        String tableCompaniesAction4 = "\n#Main menu -> table: Companies -> Delete company#";
        String tableCompaniesAction5 = "\n#Main menu -> table: Companies -> Read customers from company#";
        String tableCompaniesAction6 = "\n#Main menu -> table: Companies -> Add customer to company#";
        String tableCompaniesAction7 = "\n#Main menu -> table: Companies -> Delete customer from company#";

        String tableCustomers = "\n#Main menu -> table: Customers#";
        String addActionCustomers = "5-Read projects from customer | 6-Add project to customer | 7-Delete project from customer";
        String tableCustomersAction1 = "\n#Main menu -> table: Customers -> Create new customer#";
        String tableCustomersAction2 = "\n#Main menu -> table: Customers -> Read all customers#";
        String tableCustomersAction3 = "\n#Main menu -> table: Customers -> Update customer#";
        String tableCustomersAction4 = "\n#Main menu -> table: Customers -> Delete customer#";
        String tableCustomersAction5 = "\n#Main menu -> table: Customers -> Read projects from customer#";
        String tableCustomersAction6 = "\n#Main menu -> table: Customers -> Add project to customer#";
        String tableCustomersAction7 = "\n#Main menu -> table: Customers -> Delete project from customer#";

        String tableProjects = "\n#Main menu -> table: Projects#";
        String addActionProjects = "5-Read developers from project";
        String tableProjectsAction1 = "\n#Main menu -> table: Customers -> Create new project#";
        String tableProjectsAction2 = "\n#Main menu -> table: Customers -> Read all projects#";
        String tableProjectsAction3 = "\n#Main menu -> table: Customers -> Update project#";
        String tableProjectsAction4 = "\n#Main menu -> table: Customers -> Delete project#";
        String tableProjectsAction5 = "\n#Main menu -> table: Customers -> Read developers from project#";

        String tableDevelopers = "\n#Main menu -> table: Developers#";
        String addActionDevelopers = "5-Read skills from developer | 6-Add skill to developer | 7-Delete skill from developer";
        String tableDevelopersAction1 = "\n#Main menu -> table: Developers -> Create new developer#";
        String tableDevelopersAction2 = "\n#Main menu -> table: Developers -> Read all developers#";
        String tableDevelopersAction3 = "\n#Main menu -> table: Developers -> Update developer#";
        String tableDevelopersAction4 = "\n#Main menu -> table: Developers -> Delete developer#";
        String tableDevelopersAction5 = "\n#Main menu -> table: Developers -> Read skills from developer#";
        String tableDevelopersAction6 = "\n#Main menu -> table: Developers -> Add skill to developer#";
        String tableDevelopersAction7 = "\n#Main menu -> table: Developers -> Delete skill from developer#";

        String tableSkills = "\n#Main menu -> table: Skills#";
        String tableSkillsAction1 = "\n#Main menu -> table: Skills -> Create new skill#";
        String tableSkillsAction2 = "\n#Main menu -> table: Skills -> Read all skills#";
        String tableSkillsAction3 = "\n#Main menu -> table: Skills -> Update skill#";
        String tableSkillsAction4 = "\n#Main menu -> table: Skills -> Delete skill#";

        int chooseKeyboard;
        JdbcCompanyDAO jdbcCompanyDAO = new JdbcCompanyDAO();
        JdbcCustomerDAO jdbcCustomerDAO = new JdbcCustomerDAO();
        JdbcProjectDAO jdbcProjectDAO = new JdbcProjectDAO();
        JdbcDeveloperDAO jdbcDeveloperDAO = new JdbcDeveloperDAO();
        JdbcSkillDAO jdbcSkillDAO = new JdbcSkillDAO();

        while (true) {
            System.out.println(mainMenu);
            chooseKeyboard = inputInt();
            if (chooseKeyboard == 0) {
                System.out.println("\nThank you for you time!");
                System.out.println("Team Earthsoft.");
                return;
            } else if (chooseKeyboard == 1) {
                chooseTable = "companies";
                System.out.println(tableCompanies);
                System.out.println(crudAction);
                System.out.println(addActionCompanies);
                while (true) {
                    chooseKeyboard = inputInt();
                    if (chooseKeyboard == 0) {
                        chooseKeyboard = 1;
                        break;
                    } else if (chooseKeyboard == 1) {
                        // create
                        String name;
                        String fullName;
                        String city;
                        String identificationCode;

                        System.out.println(tableCompaniesAction1);
                        System.out.println("Please enter all parameters for new company:");
                        System.out.println("Enter name:");
                        name = inputString();
                        System.out.println("Enter full name:");
                        fullName = inputString();
                        System.out.println("Enter city:");
                        city = inputString();
                        System.out.println("Enter identification code:");
                        identificationCode = inputString();

                        Company company = new Company();
                        company.setName(name);
                        company.setFullName(fullName);
                        company.setCity(city);
                        company.setIdentificationCode(identificationCode);

                        jdbcCompanyDAO.create(company);

                        System.out.println("Company created successfully:");
                        System.out.println(company.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 2) {
                        // read
                        System.out.println(tableCompaniesAction2);
                        List<Company> companyList = jdbcCompanyDAO.read();
                        for (Company company : companyList) {
                            System.out.println(company.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 3) {
                        // update
                        int id;
                        Company company;

                        System.out.println(tableCompaniesAction3);
                        System.out.println("Please enter id for update company:");
                        System.out.println("Enter id:");
                        id = inputInt();
                        System.out.println("Current company data:");
                        company = jdbcCompanyDAO.getById(id);
                        System.out.println(company.toString());

                        System.out.println("Enter new name:");
                        company.setName(inputString());
                        System.out.println("Enter new full name:");
                        company.setFullName(inputString());
                        System.out.println("Enter new city:");
                        company.setCity(inputString());
                        System.out.println("Enter identification code:");
                        company.setIdentificationCode(inputString());

                        jdbcCompanyDAO.update(company);

                        System.out.println("Company updated successfully:");
                        System.out.println(company.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 4) {
                        // delete
                        int id;

                        System.out.println(tableCompaniesAction4);
                        System.out.println("Please enter id for delete company:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        jdbcCompanyDAO.delete(id);
                        System.out.println("Company deleted successfully.");

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 5) {
                        // Read customers from company
                        int id;
                        Company company;

                        System.out.println(tableCompaniesAction5);
                        System.out.println("Please enter id company for read customers:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        System.out.println("Customers from "+jdbcCompanyDAO.getById(id).getName()+":");
                        List<Customer> customerList = jdbcCompanyDAO.getCustomers(id);
                        for (Customer customer : customerList) {
                            System.out.println(customer.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 6) {
                        // Add customer to company
                        int idCustomer;
                        int idCompany;
                        Company company;
                        Customer customer;

                        System.out.println(tableCompaniesAction6);
                        System.out.println("Please enter id customer and id company for add customer to company:");
                        System.out.println("Enter id customer:");
                        idCustomer = inputInt();
                        System.out.println("Enter id company:");
                        idCompany = inputInt();

                        jdbcCompanyDAO.addCustomer(idCustomer, idCompany);
                        System.out.println("Customer: " + jdbcCustomerDAO.getById(idCustomer).getName() + " was successfully added to "+
                            jdbcCompanyDAO.getById(idCompany).getName());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 7) {
                        // Delete customer from company
                        int idCustomer;
                        int idCompany;
                        Company company;
                        Customer customer;

                        System.out.println(tableCompaniesAction7);
                        System.out.println("Please enter id customer and id company for delete customer from company:");
                        System.out.println("Enter id customer:");
                        idCustomer = inputInt();
                        System.out.println("Enter id company:");
                        idCompany = inputInt();

                        jdbcCompanyDAO.deleteCustomer(idCustomer, idCompany);
                        System.out.println("Customer: " + jdbcCustomerDAO.getById(idCustomer).getName() + " was successfully delete from "+
                                jdbcCompanyDAO.getById(idCompany).getName());

                        chooseKeyboard = 1;
                        break;
                    }
                }
            } else if (chooseKeyboard == 2) {
                chooseTable = "customers";
                System.out.println(tableCustomers);
                System.out.println(crudAction);
                System.out.println(addActionCustomers);
                while (true) {
                    chooseKeyboard = inputInt();
                    if (chooseKeyboard == 0) {
                        chooseKeyboard = 1;
                        break;
                    } else if (chooseKeyboard == 1) {
                        // create
                        String name;
                        String identificationCode;
                        String phone;

                        System.out.println(tableCustomersAction1);
                        System.out.println("Please enter all parameters for new customer:");
                        System.out.println("Enter name:");
                        name = inputString();
                        System.out.println("Enter identification code:");
                        identificationCode = inputString();
                        System.out.println("Enter phone:");
                        phone = inputString();

                        Customer customer = new Customer();
                        customer.setName(name);
                        customer.setIdentificationCode(identificationCode);
                        customer.setPhone(phone);

                        jdbcCustomerDAO.create(customer);

                        System.out.println("Customer created successfully:");
                        System.out.println(customer.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 2) {
                        // read
                        System.out.println(tableCustomersAction2);
                        List<Customer> customerList = jdbcCustomerDAO.read();
                        for (Customer customer : customerList) {
                            System.out.println(customer.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 3) {
                        // update
                        int id;
                        Customer customer;

                        System.out.println(tableCustomersAction3);
                        System.out.println("Please enter id for update customer:");
                        System.out.println("Enter id:");
                        id = inputInt();
                        System.out.println("Current customer data:");
                        customer = jdbcCustomerDAO.getById(id);
                        System.out.println(customer.toString());

                        System.out.println("Enter new name:");
                        customer.setName(inputString());
                        System.out.println("Enter identification code:");
                        customer.setIdentificationCode(inputString());
                        System.out.println("Enter new phone:");
                        customer.setPhone(inputString());

                        jdbcCustomerDAO.update(customer);

                        System.out.println("Customer updated successfully:");
                        System.out.println(customer.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 4) {
                        // delete
                        int id;

                        System.out.println(tableCustomersAction4);
                        System.out.println("Please enter id for delete customer:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        jdbcCustomerDAO.delete(id);

                        System.out.println("Customer deleted successfully.");

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 5) {
                        // Read projects from customer
                        int id;
                        Customer customer;

                        System.out.println(tableCustomersAction5);
                        System.out.println("Please enter id customer for read projects:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        System.out.println("Projects from "+jdbcCustomerDAO.getById(id).getName()+":");
                        List<Project> projectList = jdbcCustomerDAO.getProjects(id);
                        for (Project project : projectList) {
                            System.out.println(project.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 6) {
                        // Add project to customer
                        int idProject;
                        int idCustomer;
                        Project project;
                        Customer customer;

                        System.out.println(tableCustomersAction6);
                        System.out.println("Please enter id project and id customer for add project to customer:");
                        System.out.println("Enter id project:");
                        idProject = inputInt();
                        System.out.println("Enter id customer:");
                        idCustomer = inputInt();

                        jdbcCustomerDAO.addProject(idProject, idCustomer);
                        System.out.println("Project: " + jdbcProjectDAO.getById(idProject).getName() + " was successfully added to "+
                                jdbcCustomerDAO.getById(idCustomer).getName());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 7) {
                        // Delete project from customer
                        int idProject;
                        int idCustomer;
                        Project project;
                        Customer customer;

                        System.out.println(tableCustomersAction7);
                        System.out.println("Please enter id project and id customer for delete project from customer:");
                        System.out.println("Enter id project:");
                        idProject = inputInt();
                        System.out.println("Enter id customer:");
                        idCustomer = inputInt();

                        jdbcCustomerDAO.deleteProject(idProject, idCustomer);
                        System.out.println("Project: " + jdbcProjectDAO.getById(idProject).getName() + " was successfully delete from "+
                                jdbcCustomerDAO.getById(idCustomer).getName());

                        chooseKeyboard = 1;
                        break;
                    }
                }
            }  else if (chooseKeyboard == 3) {
                chooseTable = "projects";
                System.out.println(tableProjects);
                System.out.println(crudAction);
                System.out.println(addActionProjects);
                while (true) {
                    chooseKeyboard = inputInt();
                    if (chooseKeyboard == 0) {
                        chooseKeyboard = 1;
                        break;
                    } else if (chooseKeyboard == 1) {
                        // create
                        String name;
                        BigDecimal cost;

                        System.out.println(tableProjectsAction1);
                        System.out.println("Please enter all parameters for new project:");
                        System.out.println("Enter name:");
                        name = inputString();
                        System.out.println("Enter cost:");
                        cost = inputBigDecimal();

                        Project project = new Project();
                        project.setName(name);
                        project.setCost(cost);

                        jdbcProjectDAO.create(project);

                        System.out.println("Project created successfully:");
                        System.out.println(project.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 2) {
                        // read
                        System.out.println(tableProjectsAction2);
                        List<Project> projectList = jdbcProjectDAO.read();
                        for (Project project : projectList) {
                            System.out.println(project.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 3) {
                        // update
                        int id;
                        Project project;

                        System.out.println(tableProjectsAction3);
                        System.out.println("Please enter id for update project:");
                        System.out.println("Enter id:");
                        id = inputInt();
                        System.out.println("Current project data:");
                        project = jdbcProjectDAO.getById(id);
                        System.out.println(project.toString());

                        System.out.println("Enter new name:");
                        project.setName(inputString());
                        System.out.println("Enter cost:");
                        project.setCost(inputBigDecimal());

                        jdbcProjectDAO.update(project);

                        System.out.println("Project updated successfully:");
                        System.out.println(project.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 4) {
                        // delete
                        int id;

                        System.out.println(tableProjectsAction4);
                        System.out.println("Please enter id for delete project:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        jdbcProjectDAO.delete(id);

                        System.out.println("Project deleted successfully.");

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 5) {
                        // Read skills from project
                        int id;
                        Project project;

                        System.out.println(tableProjectsAction5);
                        System.out.println("Please enter id project for read skills:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        System.out.println("Skills from "+jdbcProjectDAO.getById(id).getName()+":");
                        List<Skill> skillList = jdbcProjectDAO.getSkills(id);
                        for (Skill skill : skillList) {
                            System.out.println(skill.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    }
                }
            } else if (chooseKeyboard == 4) {
                chooseTable = "developers";
                System.out.println(tableDevelopers);
                System.out.println(crudAction);
                System.out.println(addActionDevelopers);
                while (true) {
                    chooseKeyboard = inputInt();
                    if (chooseKeyboard == 0) {
                        chooseKeyboard = 1;
                        break;
                    } else if (chooseKeyboard == 1) {
                        // create
                        String firstName;
                        String surName;
                        String identificationCode;
                        Date birthday;
                        String phone;
                        BigDecimal salary;

                        System.out.println(tableDevelopersAction1);
                        System.out.println("Please enter all parameters for new developer:");
                        System.out.println("Enter first name:");
                        firstName = inputString();
                        System.out.println("Enter sur name:");
                        surName = inputString();
                        System.out.println("Enter identification code:");
                        identificationCode = inputString();
                        System.out.println("Enter birthday:");
                        birthday = inputDate();
                        System.out.println("Enter phone:");
                        phone = inputString();
                        System.out.println("Enter salary:");
                        salary = inputBigDecimal();

                        Developer developer = new Developer();
                        developer.setFirstName(firstName);
                        developer.setSurName(surName);
                        developer.setIdentificationCode(identificationCode);
                        developer.setBirthday((java.sql.Date) birthday);
                        developer.setPhone(phone);
                        developer.setSalary(salary);

                        jdbcDeveloperDAO.create(developer);

                        System.out.println("Developer created successfully:");
                        System.out.println(developer.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 2) {
                        // read
                        System.out.println(tableDevelopersAction2);
                        List<Developer> developerList = jdbcDeveloperDAO.read();
                        for (Developer developer : developerList) {
                            System.out.println(developer.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 3) {
                        // update
                        int id;
                        Developer developer;

                        System.out.println(tableDevelopersAction3);
                        System.out.println("Please enter id for update developer:");
                        System.out.println("Enter id:");
                        id = inputInt();
                        System.out.println("Current developer data:");
                        developer = jdbcDeveloperDAO.getById(id);
                        System.out.println(developer.toString());

                        System.out.println("Enter new first name:");
                        developer.setFirstName(inputString());
                        System.out.println("Enter sur name:");
                        developer.setSurName(inputString());
                        System.out.println("Enter new identification code:");
                        developer.setIdentificationCode(inputString());
                        System.out.println("Enter new bithday:");
                        developer.setBirthday((java.sql.Date) inputDate());
                        System.out.println("Enter new phone:");
                        developer.setPhone(inputString());
                        System.out.println("Enter new salary:");
                        developer.setSalary(inputBigDecimal());

                        jdbcDeveloperDAO.update(developer);

                        System.out.println("Developer updated successfully:");
                        System.out.println(developer.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 4) {
                        // delete
                        int id;

                        System.out.println(tableDevelopersAction4);
                        System.out.println("Please enter id for delete developer:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        jdbcDeveloperDAO.delete(id);

                        System.out.println("Developer deleted successfully.");

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 5) {
                        // Read skills from developer
                        int id;
                        Developer developer;

                        System.out.println(tableCustomersAction5);
                        System.out.println("Please enter id developer for read skills:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        System.out.println("Skills from "+jdbcDeveloperDAO.getById(id).getFirstName()+jdbcDeveloperDAO.getById(id).getSurName()+":");
                        List<Skill> skillList = jdbcDeveloperDAO.getSkillsByDeveloper(id);
                        for (Skill skill : skillList) {
                            System.out.println(skill.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 6) {
                        // Add skill to developer
                        int idSkill;
                        int idDeveloper;
                        Skill skill;
                        Developer developer;

                        System.out.println(tableDevelopersAction6);
                        System.out.println("Please enter id skill and id developer for add skill to developer:");
                        System.out.println("Enter id skill:");
                        idSkill = inputInt();
                        System.out.println("Enter id developer:");
                        idDeveloper = inputInt();

                        jdbcDeveloperDAO.addSkillByDeveloper(idDeveloper, idSkill);
                        System.out.println("Skill: " + jdbcSkillDAO.getById(idSkill).getName() + " was successfully added to "+
                                jdbcDeveloperDAO.getById(idDeveloper).getFirstName()+" "+jdbcDeveloperDAO.getById(idDeveloper).getSurName());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 7) {
                        // Delete skill from developer
                        int idSkill;
                        int idDeveloper;
                        Skill skill;
                        Developer developer;

                        System.out.println(tableDevelopersAction7);
                        System.out.println("Please enter id skill and id developer for delete skill from developer:");
                        System.out.println("Enter id skill:");
                        idSkill = inputInt();
                        System.out.println("Enter id developer:");
                        idDeveloper = inputInt();

                        jdbcDeveloperDAO.deleteSkillByDeveloper(idDeveloper, idSkill);
                        System.out.println("Skill: " + jdbcSkillDAO.getById(idSkill).getName() + " was successfully delete from "+
                                jdbcDeveloperDAO.getById(idDeveloper).getFirstName()+" "+jdbcDeveloperDAO.getById(idDeveloper).getSurName());

                        chooseKeyboard = 1;
                        break;
                    }
                }
            }  else if (chooseKeyboard == 5) {
                chooseTable = "skills";
                System.out.println(tableSkills);
                System.out.println(crudAction);

                while (true) {
                    chooseKeyboard = inputInt();
                    if (chooseKeyboard == 0) {
                        chooseKeyboard = 1;
                        break;
                    } else if (chooseKeyboard == 1) {
                        // create
                        String name;

                        System.out.println(tableCustomersAction1);
                        System.out.println("Please enter all parameters for new skill:");
                        System.out.println("Enter name:");
                        name = inputString();

                        Skill skill = new Skill();
                        skill.setName(name);

                        jdbcSkillDAO.create(skill);

                        System.out.println("Skill created successfully:");
                        System.out.println(skill.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 2) {
                        // read
                        System.out.println(tableSkillsAction2);
                        List<Skill> skillList = jdbcSkillDAO.read();
                        for (Skill skill : skillList) {
                            System.out.println(skill.toString());
                        }

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 3) {
                        // update
                        int id;
                        Skill skill;

                        System.out.println(tableSkillsAction3);
                        System.out.println("Please enter id for update skill:");
                        System.out.println("Enter id:");
                        id = inputInt();
                        System.out.println("Current skill data:");
                        skill = jdbcSkillDAO.getById(id);
                        System.out.println(skill.toString());

                        System.out.println("Enter new name:");
                        skill.setName(inputString());

                        jdbcSkillDAO.update(skill);

                        System.out.println("Skill updated successfully:");
                        System.out.println(skill.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 4) {
                        // delete
                        int id;

                        System.out.println(tableSkillsAction4);
                        System.out.println("Please enter id for delete skill:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        jdbcSkillDAO.delete(id);

                        System.out.println("Skill deleted successfully.");

                        chooseKeyboard = 1;
                        break;

                    }
                }
            }
        }
    }

}

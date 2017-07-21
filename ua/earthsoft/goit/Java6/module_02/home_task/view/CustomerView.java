package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Project;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.JdbcCustomerDaoImpl;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.JdbcProjectDaoImpl;
import ua.earthsoft.goit.Java6.module_02.home_task.util.KeyboardUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class CustomerView {
    private final String tableCustomers = "\n#Main menu -> table: Customers#";
    private final String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";
    private final String addActionCustomers = "5-Read projects from customer | 6-Add project to customer | 7-Delete project from customer";
    private final String tableCustomersAction1 = "\n#Main menu -> table: Customers -> Create new customer#";
    private final String tableCustomersAction2 = "\n#Main menu -> table: Customers -> Read all customers#";
    private final String tableCustomersAction3 = "\n#Main menu -> table: Customers -> Update customer#";
    private final String tableCustomersAction4 = "\n#Main menu -> table: Customers -> Delete customer#";
    private final String tableCustomersAction5 = "\n#Main menu -> table: Customers -> Read projects from customer#";
    private final String tableCustomersAction6 = "\n#Main menu -> table: Customers -> Add project to customer#";
    private final String tableCustomersAction7 = "\n#Main menu -> table: Customers -> Delete project from customer#";

    private KeyboardUtil keyboardUtil = new KeyboardUtil();
    JdbcCustomerDaoImpl jdbcCustomerDao = JdbcCustomerDaoImpl.getInstance();
    JdbcProjectDaoImpl jdbcProjectDao = JdbcProjectDaoImpl.getInstance();
    int chooseKeyboard;

    private final int create=1;
    private final int readAll=2;
    private final int update=3;
    private final int delete=4;
    private final int readProjectsFromCustomer=5;
    private final int addProjectToCustomer=6;
    private final int deleteProjectFromCustomer=7;
    private final int returnToMainMenu=0;

    public void view() throws IOException {
        System.out.println(tableCustomers);
        System.out.println(crudAction);
        System.out.println(addActionCustomers);
        while (true) {
            chooseKeyboard = keyboardUtil.inputInt();
            switch (chooseKeyboard) {
                case returnToMainMenu: {
                    chooseKeyboard = 1;
                    break;
                }
                case create: {
                    String name;
                    String identificationCode;
                    String phone;

                    System.out.println(tableCustomersAction1);
                    System.out.println("Please enter all parameters for new customer:");
                    System.out.println("Enter name:");
                    name = keyboardUtil.inputString();
                    System.out.println("Enter identification code:");
                    identificationCode = keyboardUtil.inputString();
                    System.out.println("Enter phone:");
                    phone = keyboardUtil.inputString();

                    Customer customer = new Customer();
                    customer.setName(name);
                    customer.setIdentificationCode(identificationCode);
                    customer.setPhone(phone);

                    jdbcCustomerDao.create(customer);

                    System.out.println("Customer created successfully:");
                    System.out.println(customer.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case readAll: {
                    System.out.println(tableCustomersAction2);
                    List<Customer> customerList = jdbcCustomerDao.read();
                    for (Customer customer : customerList) {
                        System.out.println(customer.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case update: {
                    int id;
                    Customer customer;

                    System.out.println(tableCustomersAction3);
                    System.out.println("Please enter id for update customer:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();
                    System.out.println("Current customer data:");
                    customer = jdbcCustomerDao.getById(id);
                    System.out.println(customer.toString());

                    System.out.println("Enter new name:");
                    customer.setName(keyboardUtil.inputString());
                    System.out.println("Enter identification code:");
                    customer.setIdentificationCode(keyboardUtil.inputString());
                    System.out.println("Enter new phone:");
                    customer.setPhone(keyboardUtil.inputString());

                    jdbcCustomerDao.update(customer);

                    System.out.println("Customer updated successfully:");
                    System.out.println(customer.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case delete: {
                    int id;

                    System.out.println(tableCustomersAction4);
                    System.out.println("Please enter id for delete customer:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();

                    jdbcCustomerDao.delete(id);

                    System.out.println("Customer deleted successfully.");

                    chooseKeyboard = 1;
                    break;
                }
                case readProjectsFromCustomer: {
                    int id;
                    Customer customer;

                    System.out.println(tableCustomersAction5);
                    System.out.println("Please enter id customer for read projects:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();

                    System.out.println("Projects from "+ jdbcCustomerDao.getById(id).getName()+":");
                    List<Project> projectList = jdbcCustomerDao.getProjects(id);
                    for (Project project : projectList) {
                        System.out.println(project.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case addProjectToCustomer: {
                    int idProject;
                    int idCustomer;
                    Project project;
                    Customer customer;

                    System.out.println(tableCustomersAction6);
                    System.out.println("Please enter id project and id customer for add project to customer:");
                    System.out.println("Enter id project:");
                    idProject = keyboardUtil.inputInt();
                    System.out.println("Enter id customer:");
                    idCustomer = keyboardUtil.inputInt();

                    jdbcCustomerDao.addProject(idProject, idCustomer);
                    System.out.println("Project: " + jdbcProjectDao.getById(idProject).getName() + " was successfully added to "+
                            jdbcCustomerDao.getById(idCustomer).getName());

                    chooseKeyboard = 1;
                    break;
                }
                case deleteProjectFromCustomer: {
                    int idProject;
                    int idCustomer;
                    Project project;
                    Customer customer;

                    System.out.println(tableCustomersAction7);
                    System.out.println("Please enter id project and id customer for delete project from customer:");
                    System.out.println("Enter id project:");
                    idProject = keyboardUtil.inputInt();
                    System.out.println("Enter id customer:");
                    idCustomer = keyboardUtil.inputInt();

                    jdbcCustomerDao.deleteProject(idProject, idCustomer);
                    System.out.println("Project: " + jdbcProjectDao.getById(idProject).getName() + " was successfully delete from "+
                            jdbcCustomerDao.getById(idCustomer).getName());

                    chooseKeyboard = 1;
                    break;
                }
            }
            break;
        }
    }
}

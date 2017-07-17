package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Project;

import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class CustomerView {
    //        String tableCustomers = "\n#Main menu -> table: Customers#";
//        String addActionCustomers = "5-Read projects from customer | 6-Add project to customer | 7-Delete project from customer";
//        String tableCustomersAction1 = "\n#Main menu -> table: Customers -> Create new customer#";
//        String tableCustomersAction2 = "\n#Main menu -> table: Customers -> Read all customers#";
//        String tableCustomersAction3 = "\n#Main menu -> table: Customers -> Update customer#";
//        String tableCustomersAction4 = "\n#Main menu -> table: Customers -> Delete customer#";
//        String tableCustomersAction5 = "\n#Main menu -> table: Customers -> Read projects from customer#";
//        String tableCustomersAction6 = "\n#Main menu -> table: Customers -> Add project to customer#";
//        String tableCustomersAction7 = "\n#Main menu -> table: Customers -> Delete project from customer#";

    public void view() {
//        chooseTable = "customers";
//        System.out.println(tableCustomers);
//        System.out.println(crudAction);
//        System.out.println(addActionCustomers);
//        while (true) {
//            chooseKeyboard = inputInt();
//            if (chooseKeyboard == 0) {
//                chooseKeyboard = 1;
//                break;
//            } else if (chooseKeyboard == 1) {
//                // create
//                String name;
//                String identificationCode;
//                String phone;
//
//                System.out.println(tableCustomersAction1);
//                System.out.println("Please enter all parameters for new customer:");
//                System.out.println("Enter name:");
//                name = inputString();
//                System.out.println("Enter identification code:");
//                identificationCode = inputString();
//                System.out.println("Enter phone:");
//                phone = inputString();
//
//                Customer customer = new Customer();
//                customer.setName(name);
//                customer.setIdentificationCode(identificationCode);
//                customer.setPhone(phone);
//
//                jdbcCustomerDaoImpl.create(customer);
//
//                System.out.println("Customer created successfully:");
//                System.out.println(customer.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 2) {
//                // read
//                System.out.println(tableCustomersAction2);
//                List<Customer> customerList = jdbcCustomerDaoImpl.read();
//                for (Customer customer : customerList) {
//                    System.out.println(customer.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 3) {
//                // update
//                int id;
//                Customer customer;
//
//                System.out.println(tableCustomersAction3);
//                System.out.println("Please enter id for update customer:");
//                System.out.println("Enter id:");
//                id = inputInt();
//                System.out.println("Current customer data:");
//                customer = jdbcCustomerDaoImpl.getById(id);
//                System.out.println(customer.toString());
//
//                System.out.println("Enter new name:");
//                customer.setName(inputString());
//                System.out.println("Enter identification code:");
//                customer.setIdentificationCode(inputString());
//                System.out.println("Enter new phone:");
//                customer.setPhone(inputString());
//
//                jdbcCustomerDaoImpl.update(customer);
//
//                System.out.println("Customer updated successfully:");
//                System.out.println(customer.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 4) {
//                // delete
//                int id;
//
//                System.out.println(tableCustomersAction4);
//                System.out.println("Please enter id for delete customer:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                jdbcCustomerDaoImpl.delete(id);
//
//                System.out.println("Customer deleted successfully.");
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 5) {
//                // Read projects from customer
//                int id;
//                Customer customer;
//
//                System.out.println(tableCustomersAction5);
//                System.out.println("Please enter id customer for read projects:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                System.out.println("Projects from "+ jdbcCustomerDaoImpl.getById(id).getName()+":");
//                List<Project> projectList = jdbcCustomerDaoImpl.getProjects(id);
//                for (Project project : projectList) {
//                    System.out.println(project.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 6) {
//                // Add project to customer
//                int idProject;
//                int idCustomer;
//                Project project;
//                Customer customer;
//
//                System.out.println(tableCustomersAction6);
//                System.out.println("Please enter id project and id customer for add project to customer:");
//                System.out.println("Enter id project:");
//                idProject = inputInt();
//                System.out.println("Enter id customer:");
//                idCustomer = inputInt();
//
//                jdbcCustomerDaoImpl.addProject(idProject, idCustomer);
//                System.out.println("Project: " + jdbcProjectDaoImpl.getById(idProject).getName() + " was successfully added to "+
//                        jdbcCustomerDaoImpl.getById(idCustomer).getName());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 7) {
//                // Delete project from customer
//                int idProject;
//                int idCustomer;
//                Project project;
//                Customer customer;
//
//                System.out.println(tableCustomersAction7);
//                System.out.println("Please enter id project and id customer for delete project from customer:");
//                System.out.println("Enter id project:");
//                idProject = inputInt();
//                System.out.println("Enter id customer:");
//                idCustomer = inputInt();
//
//                jdbcCustomerDaoImpl.deleteProject(idProject, idCustomer);
//                System.out.println("Project: " + jdbcProjectDaoImpl.getById(idProject).getName() + " was successfully delete from "+
//                        jdbcCustomerDaoImpl.getById(idCustomer).getName());
//
//                chooseKeyboard = 1;
//                break;
//            }
//        }
    }

}

package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Company;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.JdbcCompanyDaoImpl;

import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class CompanyView {
    String tableCompanies = "\n#Main menu -> table: Companies#";
    String addActionCompanies = "5-Read customers from company | 6-Add customer to company | 7-Delete customer from company";
    String tableCompaniesAction1 = "\n#Main menu -> table: Companies -> Create new company#";
    String tableCompaniesAction2 = "\n#Main menu -> table: Companies -> Read all companies#";
    String tableCompaniesAction3 = "\n#Main menu -> table: Companies -> Update company#";
    String tableCompaniesAction4 = "\n#Main menu -> table: Companies -> Delete company#";
    String tableCompaniesAction5 = "\n#Main menu -> table: Companies -> Read customers from company#";
    String tableCompaniesAction6 = "\n#Main menu -> table: Companies -> Add customer to company#";
    String tableCompaniesAction7 = "\n#Main menu -> table: Companies -> Delete customer from company#";
    JdbcCompanyDaoImpl jdbcCompanyDaoImpl = new JdbcCompanyDaoImpl();
    int chooseKeyboard;

    public void view() {
//        chooseTable = "companies";
//        System.out.println(tableCompanies);
//        System.out.println(crudAction);
//        System.out.println(addActionCompanies);
//        while (true) {
//            chooseKeyboard = inputInt();
//            if (chooseKeyboard == 0) {
//                chooseKeyboard = 1;
//                break;
//            } else if (chooseKeyboard == 1) {
//                // create
//                String name;
//                String fullName;
//                String city;
//                String identificationCode;
//
//                System.out.println(tableCompaniesAction1);
//                System.out.println("Please enter all parameters for new company:");
//                System.out.println("Enter name:");
//                name = inputString();
//                System.out.println("Enter full name:");
//                fullName = inputString();
//                System.out.println("Enter city:");
//                city = inputString();
//                System.out.println("Enter identification code:");
//                identificationCode = inputString();
//
//                Company company = new Company();
//                company.setName(name);
//                company.setFullName(fullName);
//                company.setCity(city);
//                company.setIdentificationCode(identificationCode);
//
//                jdbcCompanyDaoImpl.create(company);
//
//                System.out.println("Company created successfully:");
//                System.out.println(company.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 2) {
//                // read
//                System.out.println(tableCompaniesAction2);
//                List<Company> companyList = jdbcCompanyDaoImpl.read();
//                for (Company company : companyList) {
//                    System.out.println(company.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 3) {
//                // update
//                int id;
//                Company company;
//
//                System.out.println(tableCompaniesAction3);
//                System.out.println("Please enter id for update company:");
//                System.out.println("Enter id:");
//                id = inputInt();
//                System.out.println("Current company data:");
//                company = jdbcCompanyDaoImpl.getById(id);
//                System.out.println(company.toString());
//
//                System.out.println("Enter new name:");
//                company.setName(inputString());
//                System.out.println("Enter new full name:");
//                company.setFullName(inputString());
//                System.out.println("Enter new city:");
//                company.setCity(inputString());
//                System.out.println("Enter identification code:");
//                company.setIdentificationCode(inputString());
//
//                jdbcCompanyDaoImpl.update(company);
//
//                System.out.println("Company updated successfully:");
//                System.out.println(company.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 4) {
//                // delete
//                int id;
//
//                System.out.println(tableCompaniesAction4);
//                System.out.println("Please enter id for delete company:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                jdbcCompanyDaoImpl.delete(id);
//                System.out.println("Company deleted successfully.");
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 5) {
//                // Read customers from company
//                int id;
//                Company company;
//
//                System.out.println(tableCompaniesAction5);
//                System.out.println("Please enter id company for read customers:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                System.out.println("Customers from "+ jdbcCompanyDaoImpl.getById(id).getName()+":");
//                List<Customer> customerList = jdbcCompanyDaoImpl.getCustomers(id);
//                for (Customer customer : customerList) {
//                    System.out.println(customer.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 6) {
//                // Add customer to company
//                int idCustomer;
//                int idCompany;
//                Company company;
//                Customer customer;
//
//                System.out.println(tableCompaniesAction6);
//                System.out.println("Please enter id customer and id company for add customer to company:");
//                System.out.println("Enter id customer:");
//                idCustomer = inputInt();
//                System.out.println("Enter id company:");
//                idCompany = inputInt();
//
//                jdbcCompanyDaoImpl.addCustomer(idCustomer, idCompany);
//                System.out.println("Customer: " + jdbcCustomerDaoImpl.getById(idCustomer).getName() + " was successfully added to "+
//                        jdbcCompanyDaoImpl.getById(idCompany).getName());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 7) {
//                // Delete customer from company
//                int idCustomer;
//                int idCompany;
//                Company company;
//                Customer customer;
//
//                System.out.println(tableCompaniesAction7);
//                System.out.println("Please enter id customer and id company for delete customer from company:");
//                System.out.println("Enter id customer:");
//                idCustomer = inputInt();
//                System.out.println("Enter id company:");
//                idCompany = inputInt();
//
//                jdbcCompanyDaoImpl.deleteCustomer(idCustomer, idCompany);
//                System.out.println("Customer: " + jdbcCustomerDaoImpl.getById(idCustomer).getName() + " was successfully delete from "+
//                        jdbcCompanyDaoImpl.getById(idCompany).getName());
//
//                chooseKeyboard = 1;
//                break;
//            }
//        }

    }
}

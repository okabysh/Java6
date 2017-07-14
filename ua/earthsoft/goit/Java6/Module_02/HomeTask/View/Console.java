package ua.earthsoft.goit.Java6.Module_02.HomeTask.View;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.Company;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.Customer;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc.JdbcCompanyDAO;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Model.jdbc.JdbcCustomerDAO;
import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    public void start() throws IOException {
        String mainMenu = "\n#Main menu# Please choose table: 1-Companies | 2-Customers | 3-Projects | 4-Developers | 5-Skills | 0-Exit";
        String tableCompanies = "\n#Main menu -> table: Companies#";
        String tableCompaniesAction1 = "\n#Main menu -> table: Companies -> Create new company#";
        String tableCompaniesAction2 = "\n#Main menu -> table: Companies -> Read all companies#";
        String tableCompaniesAction3 = "\n#Main menu -> table: Companies -> Update company#";
        String tableCompaniesAction4 = "\n#Main menu -> table: Companies -> Delete company#";
        String tableCompaniesAction5 = "\n#Main menu -> table: Companies -> Read customers from company#";
        String tableCompaniesAction6 = "\n#Main menu -> table: Companies -> Add customer to company#";
        String tableCompaniesAction7 = "\n#Main menu -> table: Companies -> Delete customer from company#";
        int chooseKeyboard;
        JdbcCompanyDAO jdbcCompanyDAO = new JdbcCompanyDAO();
        JdbcCustomerDAO jdbcCustomerDAO = new JdbcCustomerDAO();

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
                System.out.println("Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu");
                System.out.println("5-Read customers from company | 6-Add customer to company | 7-Delete customer from company");
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

                        System.out.println("Created successfully:");
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

                        System.out.println("Updated successfully:");
                        System.out.println(company.toString());

                        chooseKeyboard = 1;
                        break;

                    } else if (chooseKeyboard == 4) {
                        // delete
                        int id;
                        Company company;

                        System.out.println(tableCompaniesAction4);
                        System.out.println("Please enter id for delete company:");
                        System.out.println("Enter id:");
                        id = inputInt();

                        jdbcCompanyDAO.delete(id);
                        System.out.println("Deleted successfully:");

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
            }
        }
    }

}

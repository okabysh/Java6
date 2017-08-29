package ua.earthsoft.goit.Java6.module_03.home_task.view;

import ua.earthsoft.goit.Java6.module_03.home_task.model.Company;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Customer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl.JdbcCompanyDaoImpl;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl.JdbcCustomerDaoImpl;
import ua.earthsoft.goit.Java6.module_03.home_task.util.KeyboardUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class CompanyView {
    private final String tableCompanies = "\n#Main menu -> table: Companies#";
    private final String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";
    private final String addActionCompanies = "5-Read customers from company | 6-Add customer to company | 7-Delete customer from company";
    private final String tableCompaniesAction1 = "\n#Main menu -> table: Companies -> Create new company#";
    private final String tableCompaniesAction2 = "\n#Main menu -> table: Companies -> Read all companies#";
    private final String tableCompaniesAction3 = "\n#Main menu -> table: Companies -> Update company#";
    private final String tableCompaniesAction4 = "\n#Main menu -> table: Companies -> Delete company#";
    private final String tableCompaniesAction5 = "\n#Main menu -> table: Companies -> Read customers from company#";
    private final String tableCompaniesAction6 = "\n#Main menu -> table: Companies -> Add customer to company#";
    private final String tableCompaniesAction7 = "\n#Main menu -> table: Companies -> Delete customer from company#";

    JdbcCompanyDaoImpl jdbcCompanyDao = JdbcCompanyDaoImpl.getInstance();
    JdbcCustomerDaoImpl jdbcCustomerDao = JdbcCustomerDaoImpl.getInstance();
    private int chooseKeyboard;

    private final int create=1;
    private final int readAll=2;
    private final int update=3;
    private final int delete=4;
    private final int readCustomersFromCompany=5;
    private final int addCustomerToCompany=6;
    private final int deleteCustomerFromCompany=7;
    private final int returnToMainMenu=0;

    public void view() throws IOException {
        System.out.println(tableCompanies);
        System.out.println(crudAction);
        System.out.println(addActionCompanies);
        while (true) {
            chooseKeyboard = KeyboardUtil.inputInt();

            switch (chooseKeyboard) {
                case returnToMainMenu: {
                    chooseKeyboard = 1;
                    break;
                }
                case create: {
                    String name;
                    String fullName;
                    String city;
                    String identificationCode;

                    System.out.println(tableCompaniesAction1);
                    System.out.println("Please enter all parameters for new company:");
                    System.out.println("Enter name:");
                    name = KeyboardUtil.inputString();
                    System.out.println("Enter full name:");
                    fullName = KeyboardUtil.inputString();
                    System.out.println("Enter city:");
                    city = KeyboardUtil.inputString();
                    System.out.println("Enter identification code:");
                    identificationCode = KeyboardUtil.inputString();

                    Company company = new Company();
                    company.setName(name);
                    company.setFullName(fullName);
                    company.setCity(city);
                    company.setIdentificationCode(identificationCode);

                    jdbcCompanyDao.create(company);

                    System.out.println("Company created successfully:");
                    System.out.println(company.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case readAll: {
                    System.out.println(tableCompaniesAction2);
                    List<Company> companyList = jdbcCompanyDao.read();
                    for (Company company : companyList) {
                        System.out.println(company.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case update: {
                    int id;
                    Company company;

                    System.out.println(tableCompaniesAction3);
                    System.out.println("Please enter id for update company:");
                    System.out.println("Enter id:");
                    id = KeyboardUtil.inputInt();
                    System.out.println("Current company data:");
                    company = jdbcCompanyDao.getById(id);
                    System.out.println(company.toString());

                    System.out.println("Enter new name:");
                    company.setName(KeyboardUtil.inputString());
                    System.out.println("Enter new full name:");
                    company.setFullName(KeyboardUtil.inputString());
                    System.out.println("Enter new city:");
                    company.setCity(KeyboardUtil.inputString());
                    System.out.println("Enter identification code:");
                    company.setIdentificationCode(KeyboardUtil.inputString());

                    jdbcCompanyDao.update(company);

                    System.out.println("Company updated successfully:");
                    System.out.println(company.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case delete: {
                    int id;

                    System.out.println(tableCompaniesAction4);
                    System.out.println("Please enter id for delete company:");
                    System.out.println("Enter id:");
                    id = KeyboardUtil.inputInt();

                    jdbcCompanyDao.delete(id);
                    System.out.println("Company deleted successfully.");

                    chooseKeyboard = 1;
                    break;
                }
                case readCustomersFromCompany: {
                    int id;
                    Company company;

                    System.out.println(tableCompaniesAction5);
                    System.out.println("Please enter id company for read customers:");
                    System.out.println("Enter id:");
                    id = KeyboardUtil.inputInt();

                    System.out.println("Customers from "+ jdbcCompanyDao.getById(id).getName()+":");
                    List<Customer> customerList0 = jdbcCompanyDao.getCustomers(jdbcCompanyDao.getById(id));
                    List<Customer> customerList = jdbcCompanyDao.getCustomersByCompany(id);

                    chooseKeyboard = 1;
                    break;
                }
                case addCustomerToCompany: {
                    int idCustomer;
                    int idCompany;

                    System.out.println(tableCompaniesAction6);
                    System.out.println("Please enter id customer and id company for add customer to company:");
                    System.out.println("Enter id customer:");
                    idCustomer = KeyboardUtil.inputInt();
                    System.out.println("Enter id company:");
                    idCompany = KeyboardUtil.inputInt();

                    jdbcCompanyDao.addCustomer(idCustomer, idCompany);
                    System.out.println("Customer: " + jdbcCustomerDao.getById(idCustomer).getName() + " was successfully added to "+
                            jdbcCompanyDao.getById(idCompany).getName());

                    chooseKeyboard = 1;
                    break;
                }
                case deleteCustomerFromCompany: {
                    int idCustomer;
                    int idCompany;

                    System.out.println(tableCompaniesAction7);
                    System.out.println("Please enter id customer and id company for delete customer from company:");
                    System.out.println("Enter id customer:");
                    idCustomer = KeyboardUtil.inputInt();
                    System.out.println("Enter id company:");
                    idCompany = KeyboardUtil.inputInt();

                    jdbcCompanyDao.deleteCustomer(idCustomer, idCompany);
                    System.out.println("Customer: " + jdbcCustomerDao.getById(idCustomer).getName() + " was successfully delete from "+
                            jdbcCompanyDao.getById(idCompany).getName());

                    chooseKeyboard = 1;
                    break;
                }
            }
            break;
        }
    }
}

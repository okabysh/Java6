package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.*;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.*;
import ua.earthsoft.goit.Java6.module_02.home_task.util.CrudUtil;
import ua.earthsoft.goit.Java6.module_02.home_task.util.InputUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class MainView {

    private String chooseTable;
    private CrudUtil crudUtil;
    private InputUtil inputUtil = new InputUtil();
    private int company;
    private int customer;
    private int project;
    private int developer;
    private int skill;
    private int exitProgram;

    public void view() throws IOException, ParseException {

        String mainMenu = "\n#Main menu# Please choose table: 1-Companies | 2-Customers | 3-Projects | 4-Developers | 5-Skills | 0-Exit";
        String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";
        company=1; customer=2; project=3; developer=4; skill=5; exitProgram=0;

        int chooseKeyboard;
        CompanyView companyView = new CompanyView();
        CustomerView customerView = new CustomerView();
        ProjectView projectView = new ProjectView();
        DeveloperView developerView = new DeveloperView();
        SkillView skillView = new SkillView();

        System.out.println("Welcome to CrudUtil via JDBC application!");

        while (true) {
            System.out.println(mainMenu);
            chooseKeyboard = inputUtil.inputInt();
            if (chooseKeyboard == exitProgram) {
                System.out.println("\nThank you for you time!");
                System.out.println("Team Earthsoft.");
                return;
            } else if (chooseKeyboard == company) {
                companyView.view();
            } else if (chooseKeyboard == customer) {
                customerView.view();
            }  else if (chooseKeyboard == project) {
                projectView.view();
            } else if (chooseKeyboard == developer) {
                developerView.view();
            }  else if (chooseKeyboard == skill) {
                skillView.view();
            }
        }
    }
}

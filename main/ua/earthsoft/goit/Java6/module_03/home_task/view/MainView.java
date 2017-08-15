package ua.earthsoft.goit.Java6.module_03.home_task.view;

import ua.earthsoft.goit.Java6.module_03.home_task.util.KeyboardUtil;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class MainView {
    private final int company=1;
    private final int customer=2;
    private final int project=3;
    private final int developer=4;
    private final int skill=5;
    private final int exitProgram=0;
    private int chooseKeyboard;

    public void view() throws IOException, ParseException {

        final String mainMenu = "\n#Main menu# Please choose table: 1-Companies | 2-Customers | 3-Projects | 4-Developers | 5-Skills | 0-Exit";

        CompanyView companyView = new CompanyView();
        CustomerView customerView = new CustomerView();
        ProjectView projectView = new ProjectView();
        DeveloperView developerView = new DeveloperView();
        SkillView skillView = new SkillView();

        System.out.println("Welcome to CRUD via JDBC application!");

        while (true) {
            System.out.println(mainMenu);
            chooseKeyboard = KeyboardUtil.inputInt();

            switch (chooseKeyboard) {
                case exitProgram:
                    System.out.println("\nThank you for you time!");
                    System.out.println("Team Earthsoft.");
                    return;
                case company:
                    companyView.view();
                    break;
                case customer:
                    customerView.view();
                    break;
                case project:
                    projectView.view();
                    break;
                case developer:
                    developerView.view();
                    break;
                case skill:
                    skillView.view();
                    break;
                }
            }
        }
    }


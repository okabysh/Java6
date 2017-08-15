package ua.earthsoft.goit.Java6.module_03.home_task.view;

import ua.earthsoft.goit.Java6.module_03.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Project;
import ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao.impl.JdbcProjectDaoImpl;
import ua.earthsoft.goit.Java6.module_03.home_task.util.KeyboardUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class ProjectView {
    private final String tableProjects = "\n#Main menu -> table: Projects#";
    private final String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";
    private final String addActionProjects = "5-Read developers from project";
    private final String tableProjectsAction1 = "\n#Main menu -> table: Customers -> Create new project#";
    private final String tableProjectsAction2 = "\n#Main menu -> table: Customers -> Read all projects#";
    private final String tableProjectsAction3 = "\n#Main menu -> table: Customers -> Update project#";
    private final String tableProjectsAction4 = "\n#Main menu -> table: Customers -> Delete project#";
    private final String tableProjectsAction5 = "\n#Main menu -> table: Customers -> Read developers from project#";

    JdbcProjectDaoImpl jdbcProjectDao = JdbcProjectDaoImpl.getInstance();
    private int chooseKeyboard;

    private final int create=1;
    private final int readAll=2;
    private final int update=3;
    private final int delete=4;
    private final int readDevelopersFromProject=5;
    private final int returnToMainMenu=0;

    public void view() throws IOException {
        System.out.println(tableProjects);
        System.out.println(crudAction);
        System.out.println(addActionProjects);

        while (true) {
            chooseKeyboard = KeyboardUtil.inputInt();
            switch (chooseKeyboard) {
                case returnToMainMenu: {
                    chooseKeyboard = 1;
                    break;
                }
                case create: {
                    String name;
                    BigDecimal cost;

                    System.out.println(tableProjectsAction1);
                    System.out.println("Please enter all parameters for new project:");
                    System.out.println("Enter name:");
                    name = KeyboardUtil.inputString();
                    System.out.println("Enter cost:");
                    cost = KeyboardUtil.inputBigDecimal();

                    Project project = new Project();
                    project.setName(name);
                    project.setCost(cost);

                    jdbcProjectDao.create(project);

                    System.out.println("Project created successfully:");
                    System.out.println(project.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case readAll: {
                    System.out.println(tableProjectsAction2);
                    List<Project> projectList = jdbcProjectDao.read();
                    for (Project project : projectList) {
                        System.out.println(project.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case update: {
                    int id;
                    Project project;

                    System.out.println(tableProjectsAction3);
                    System.out.println("Please enter id for update project:");
                    System.out.println("Enter id:");
                    id = KeyboardUtil.inputInt();
                    System.out.println("Current project data:");
                    project = jdbcProjectDao.getById(id);
                    System.out.println(project.toString());

                    System.out.println("Enter new name:");
                    project.setName(KeyboardUtil.inputString());
                    System.out.println("Enter cost:");
                    project.setCost(KeyboardUtil.inputBigDecimal());

                    jdbcProjectDao.update(project);

                    System.out.println("Project updated successfully:");
                    System.out.println(project.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case delete: {
                    int id;

                    System.out.println(tableProjectsAction4);
                    System.out.println("Please enter id for delete project:");
                    System.out.println("Enter id:");
                    id = KeyboardUtil.inputInt();

                    jdbcProjectDao.delete(id);

                    System.out.println("Project deleted successfully.");

                    chooseKeyboard = 1;
                    break;
                }
                case readDevelopersFromProject: {
                    int id;

                    System.out.println(tableProjectsAction5);
                    System.out.println("Please enter id project for read developers:");
                    System.out.println("Enter id:");
                    id = KeyboardUtil.inputInt();

                    System.out.println("Developers from "+ jdbcProjectDao.getById(id).getName()+":");
                    List<Developer> developerList = jdbcProjectDao.getDevelopers(id);
                    for (Developer developer : developerList) {
                        System.out.println(developer.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
            }
            break;
        }
    }
}

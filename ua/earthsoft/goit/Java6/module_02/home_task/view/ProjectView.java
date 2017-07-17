package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Project;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Skill;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class ProjectView {
    //        String tableProjects = "\n#Main menu -> table: Projects#";
//        String addActionProjects = "5-Read developers from project";
//        String tableProjectsAction1 = "\n#Main menu -> table: Customers -> Create new project#";
//        String tableProjectsAction2 = "\n#Main menu -> table: Customers -> Read all projects#";
//        String tableProjectsAction3 = "\n#Main menu -> table: Customers -> Update project#";
//        String tableProjectsAction4 = "\n#Main menu -> table: Customers -> Delete project#";
//        String tableProjectsAction5 = "\n#Main menu -> table: Customers -> Read developers from project#";
    public void view() {
//        chooseTable = "projects";
//        System.out.println(tableProjects);
//        System.out.println(crudAction);
//        System.out.println(addActionProjects);
//        while (true) {
//            chooseKeyboard = inputInt();
//            if (chooseKeyboard == 0) {
//                chooseKeyboard = 1;
//                break;
//            } else if (chooseKeyboard == 1) {
//                // create
//                String name;
//                BigDecimal cost;
//
//                System.out.println(tableProjectsAction1);
//                System.out.println("Please enter all parameters for new project:");
//                System.out.println("Enter name:");
//                name = inputString();
//                System.out.println("Enter cost:");
//                cost = inputBigDecimal();
//
//                Project project = new Project();
//                project.setName(name);
//                project.setCost(cost);
//
//                jdbcProjectDaoImpl.create(project);
//
//                System.out.println("Project created successfully:");
//                System.out.println(project.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 2) {
//                // read
//                System.out.println(tableProjectsAction2);
//                List<Project> projectList = jdbcProjectDaoImpl.read();
//                for (Project project : projectList) {
//                    System.out.println(project.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 3) {
//                // update
//                int id;
//                Project project;
//
//                System.out.println(tableProjectsAction3);
//                System.out.println("Please enter id for update project:");
//                System.out.println("Enter id:");
//                id = inputInt();
//                System.out.println("Current project data:");
//                project = jdbcProjectDaoImpl.getById(id);
//                System.out.println(project.toString());
//
//                System.out.println("Enter new name:");
//                project.setName(inputString());
//                System.out.println("Enter cost:");
//                project.setCost(inputBigDecimal());
//
//                jdbcProjectDaoImpl.update(project);
//
//                System.out.println("Project updated successfully:");
//                System.out.println(project.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 4) {
//                // delete
//                int id;
//
//                System.out.println(tableProjectsAction4);
//                System.out.println("Please enter id for delete project:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                jdbcProjectDaoImpl.delete(id);
//
//                System.out.println("Project deleted successfully.");
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 5) {
//                // Read skills from project
//                int id;
//                Project project;
//
//                System.out.println(tableProjectsAction5);
//                System.out.println("Please enter id project for read skills:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                System.out.println("Skills from "+ jdbcProjectDaoImpl.getById(id).getName()+":");
//                List<Skill> skillList = jdbcProjectDaoImpl.getSkills(id);
//                for (Skill skill : skillList) {
//                    System.out.println(skill.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            }
//        }
    }
}

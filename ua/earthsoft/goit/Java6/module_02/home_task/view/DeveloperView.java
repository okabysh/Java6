package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Skill;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class DeveloperView {
    //        String tableDevelopers = "\n#Main menu -> table: Developers#";
//        String addActionDevelopers = "5-Read skills from developer | 6-Add skill to developer | 7-Delete skill from developer";
//        String tableDevelopersAction1 = "\n#Main menu -> table: Developers -> Create new developer#";
//        String tableDevelopersAction2 = "\n#Main menu -> table: Developers -> Read all developers#";
//        String tableDevelopersAction3 = "\n#Main menu -> table: Developers -> Update developer#";
//        String tableDevelopersAction4 = "\n#Main menu -> table: Developers -> Delete developer#";
//        String tableDevelopersAction5 = "\n#Main menu -> table: Developers -> Read skills from developer#";
//        String tableDevelopersAction6 = "\n#Main menu -> table: Developers -> Add skill to developer#";
//        String tableDevelopersAction7 = "\n#Main menu -> table: Developers -> Delete skill from developer#";
    public void view() {

//        chooseTable = "developers";
//        System.out.println(tableDevelopers);
//        System.out.println(crudAction);
//        System.out.println(addActionDevelopers);
//        while (true) {
//            chooseKeyboard = inputInt();
//            if (chooseKeyboard == 0) {
//                chooseKeyboard = 1;
//                break;
//            } else if (chooseKeyboard == 1) {
//                // create
//                String firstName;
//                String surName;
//                String identificationCode;
//                Date birthday;
//                String phone;
//                BigDecimal salary;
//
//                System.out.println(tableDevelopersAction1);
//                System.out.println("Please enter all parameters for new developer:");
//                System.out.println("Enter first name:");
//                firstName = inputString();
//                System.out.println("Enter sur name:");
//                surName = inputString();
//                System.out.println("Enter identification code:");
//                identificationCode = inputString();
//                System.out.println("Enter birthday:");
//                birthday = inputDate();
//                System.out.println("Enter phone:");
//                phone = inputString();
//                System.out.println("Enter salary:");
//                salary = inputBigDecimal();
//
//                Developer developer = new Developer();
//                developer.setFirstName(firstName);
//                developer.setSurName(surName);
//                developer.setIdentificationCode(identificationCode);
//                developer.setBirthday((Date) birthday);
//                developer.setPhone(phone);
//                developer.setSalary(salary);
//
//                jdbcDeveloperDaoImpl.create(developer);
//
//                System.out.println("Developer created successfully:");
//                System.out.println(developer.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 2) {
//                // read
//                System.out.println(tableDevelopersAction2);
//                List<Developer> developerList = jdbcDeveloperDaoImpl.read();
//                for (Developer developer : developerList) {
//                    System.out.println(developer.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 3) {
//                // update
//                int id;
//                Developer developer;
//
//                System.out.println(tableDevelopersAction3);
//                System.out.println("Please enter id for update developer:");
//                System.out.println("Enter id:");
//                id = inputInt();
//                System.out.println("Current developer data:");
//                developer = jdbcDeveloperDaoImpl.getById(id);
//                System.out.println(developer.toString());
//
//                System.out.println("Enter new first name:");
//                developer.setFirstName(inputString());
//                System.out.println("Enter sur name:");
//                developer.setSurName(inputString());
//                System.out.println("Enter new identification code:");
//                developer.setIdentificationCode(inputString());
//                System.out.println("Enter new bithday:");
//                developer.setBirthday((Date) inputDate());
//                System.out.println("Enter new phone:");
//                developer.setPhone(inputString());
//                System.out.println("Enter new salary:");
//                developer.setSalary(inputBigDecimal());
//
//                jdbcDeveloperDaoImpl.update(developer);
//
//                System.out.println("Developer updated successfully:");
//                System.out.println(developer.toString());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 4) {
//                // delete
//                int id;
//
//                System.out.println(tableDevelopersAction4);
//                System.out.println("Please enter id for delete developer:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                jdbcDeveloperDaoImpl.delete(id);
//
//                System.out.println("Developer deleted successfully.");
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 5) {
//                // Read skills from developer
//                int id;
//                Developer developer;
//
//                System.out.println(tableDevelopersAction5);
//                System.out.println("Please enter id developer for read skills:");
//                System.out.println("Enter id:");
//                id = inputInt();
//
//                System.out.println("Skills from "+ jdbcDeveloperDaoImpl.getById(id).getFirstName()+ jdbcDeveloperDaoImpl.getById(id).getSurName()+":");
//                List<Skill> skillList = jdbcDeveloperDaoImpl.getSkillsByDeveloper(id);
//                for (Skill skill : skillList) {
//                    System.out.println(skill.toString());
//                }
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 6) {
//                // Add skill to developer
//                int idSkill;
//                int idDeveloper;
//                Skill skill;
//                Developer developer;
//
//                System.out.println(tableDevelopersAction6);
//                System.out.println("Please enter id skill and id developer for add skill to developer:");
//                System.out.println("Enter id skill:");
//                idSkill = inputInt();
//                System.out.println("Enter id developer:");
//                idDeveloper = inputInt();
//
//                jdbcDeveloperDaoImpl.addSkillByDeveloper(idDeveloper, idSkill);
//                System.out.println("Skill: " + jdbcSkillDaoImpl.getById(idSkill).getName() + " was successfully added to "+
//                        jdbcDeveloperDaoImpl.getById(idDeveloper).getFirstName()+" "+ jdbcDeveloperDaoImpl.getById(idDeveloper).getSurName());
//
//                chooseKeyboard = 1;
//                break;
//
//            } else if (chooseKeyboard == 7) {
//                // Delete skill from developer
//                int idSkill;
//                int idDeveloper;
//                Skill skill;
//                Developer developer;
//
//                System.out.println(tableDevelopersAction7);
//                System.out.println("Please enter id skill and id developer for delete skill from developer:");
//                System.out.println("Enter id skill:");
//                idSkill = inputInt();
//                System.out.println("Enter id developer:");
//                idDeveloper = inputInt();
//
//                jdbcDeveloperDaoImpl.deleteSkillByDeveloper(idDeveloper, idSkill);
//                System.out.println("Skill: " + jdbcSkillDaoImpl.getById(idSkill).getName() + " was successfully delete from "+
//                        jdbcDeveloperDaoImpl.getById(idDeveloper).getFirstName()+" "+ jdbcDeveloperDaoImpl.getById(idDeveloper).getSurName());
//
//                chooseKeyboard = 1;
//                break;
//            }
//        }

    }
}

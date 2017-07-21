package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Skill;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.JdbcDeveloperDaoImpl;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.JdbcSkillDaoImpl;
import ua.earthsoft.goit.Java6.module_02.home_task.util.KeyboardUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class DeveloperView {
    private final String tableDevelopers = "\n#Main menu -> table: Developers#";
    private final String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";
    private final String addActionDevelopers = "5-Read skills from developer | 6-Add skill to developer | 7-Delete skill from developer";
    private final String tableDevelopersAction1 = "\n#Main menu -> table: Developers -> Create new developer#";
    private final String tableDevelopersAction2 = "\n#Main menu -> table: Developers -> Read all developers#";
    private final String tableDevelopersAction3 = "\n#Main menu -> table: Developers -> Update developer#";
    private final String tableDevelopersAction4 = "\n#Main menu -> table: Developers -> Delete developer#";
    private final String tableDevelopersAction5 = "\n#Main menu -> table: Developers -> Read skills from developer#";
    private final String tableDevelopersAction6 = "\n#Main menu -> table: Developers -> Add skill to developer#";
    private final String tableDevelopersAction7 = "\n#Main menu -> table: Developers -> Delete skill from developer#";

    private KeyboardUtil keyboardUtil = new KeyboardUtil();
    JdbcDeveloperDaoImpl jdbcDeveloperDao = JdbcDeveloperDaoImpl.getInstance();
    JdbcSkillDaoImpl jdbcSkillDao = JdbcSkillDaoImpl.getInstance();
    int chooseKeyboard;

    private final int create=1;
    private final int readAll=2;
    private final int update=3;
    private final int delete=4;
    private final int readSkillsFromDeveloper=5;
    private final int addSkillToDeveloper=6;
    private final int deleteSkillFromDeveloper=7;
    private final int returnToMainMenu=0;

    public void view() throws IOException, ParseException {
        System.out.println(tableDevelopers);
        System.out.println(crudAction);
        System.out.println(addActionDevelopers);
        while (true) {
            chooseKeyboard = keyboardUtil.inputInt();
            switch (chooseKeyboard) {
                case returnToMainMenu: {
                    chooseKeyboard = 1;
                    break;
                }
                case create: {
                    String firstName;
                    String surName;
                    String identificationCode;
                    Date birthday;
                    String phone;
                    BigDecimal salary;

                    System.out.println(tableDevelopersAction1);
                    System.out.println("Please enter all parameters for new developer:");
                    System.out.println("Enter first name:");
                    firstName = keyboardUtil.inputString();
                    System.out.println("Enter sur name:");
                    surName = keyboardUtil.inputString();
                    System.out.println("Enter identification code:");
                    identificationCode = keyboardUtil.inputString();
                    System.out.println("Enter birthday:");
                    birthday = keyboardUtil.inputDate();
                    System.out.println("Enter phone:");
                    phone = keyboardUtil.inputString();
                    System.out.println("Enter salary:");
                    salary = keyboardUtil.inputBigDecimal();

                    Developer developer = new Developer();
                    developer.setFirstName(firstName);
                    developer.setSurName(surName);
                    developer.setIdentificationCode(identificationCode);
                    developer.setBirthday((Date) birthday);
                    developer.setPhone(phone);
                    developer.setSalary(salary);

                    jdbcDeveloperDao.create(developer);

                    System.out.println("Developer created successfully:");
                    System.out.println(developer.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case readAll: {
                    System.out.println(tableDevelopersAction2);
                    List<Developer> developerList = jdbcDeveloperDao.read();
                    for (Developer developer : developerList) {
                        System.out.println(developer.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case update: {
                    int id;
                    Developer developer;

                    System.out.println(tableDevelopersAction3);
                    System.out.println("Please enter id for update developer:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();
                    System.out.println("Current developer data:");
                    developer = jdbcDeveloperDao.getById(id);
                    System.out.println(developer.toString());

                    System.out.println("Enter new first name:");
                    developer.setFirstName(keyboardUtil.inputString());
                    System.out.println("Enter sur name:");
                    developer.setSurName(keyboardUtil.inputString());
                    System.out.println("Enter new identification code:");
                    developer.setIdentificationCode(keyboardUtil.inputString());
                    System.out.println("Enter new bithday:");
                    developer.setBirthday((Date) keyboardUtil.inputDate());
                    System.out.println("Enter new phone:");
                    developer.setPhone(keyboardUtil.inputString());
                    System.out.println("Enter new salary:");
                    developer.setSalary(keyboardUtil.inputBigDecimal());

                    jdbcDeveloperDao.update(developer);

                    System.out.println("Developer updated successfully:");
                    System.out.println(developer.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case delete: {
                    int id;

                    System.out.println(tableDevelopersAction4);
                    System.out.println("Please enter id for delete developer:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();

                    jdbcDeveloperDao.delete(id);

                    System.out.println("Developer deleted successfully.");

                    chooseKeyboard = 1;
                    break;
                }
                case readSkillsFromDeveloper: {
                    int id;

                    System.out.println(tableDevelopersAction5);
                    System.out.println("Please enter id developer for read skills:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();

                    System.out.println("Skills from "+ jdbcDeveloperDao.getById(id).getFirstName()+ jdbcDeveloperDao.getById(id).getSurName()+":");
                    List<Skill> skillList = jdbcDeveloperDao.getSkillsByDeveloper(id);
                    for (Skill skill : skillList) {
                        System.out.println(skill.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case addSkillToDeveloper: {
                    int idSkill;
                    int idDeveloper;

                    System.out.println(tableDevelopersAction6);
                    System.out.println("Please enter id skill and id developer for add skill to developer:");
                    System.out.println("Enter id skill:");
                    idSkill = keyboardUtil.inputInt();
                    System.out.println("Enter id developer:");
                    idDeveloper = keyboardUtil.inputInt();

                    jdbcDeveloperDao.addSkillByDeveloper(idDeveloper, idSkill);
                    System.out.println("Skill: " + jdbcSkillDao.getById(idSkill).getName() + " was successfully added to "+
                            jdbcDeveloperDao.getById(idDeveloper).getFirstName()+" "+ jdbcDeveloperDao.getById(idDeveloper).getSurName());

                    chooseKeyboard = 1;
                    break;
                }
                case deleteSkillFromDeveloper: {
                    int idSkill;
                    int idDeveloper;

                    System.out.println(tableDevelopersAction7);
                    System.out.println("Please enter id skill and id developer for delete skill from developer:");
                    System.out.println("Enter id skill:");
                    idSkill = keyboardUtil.inputInt();
                    System.out.println("Enter id developer:");
                    idDeveloper = keyboardUtil.inputInt();

                    jdbcDeveloperDao.deleteSkillByDeveloper(idDeveloper, idSkill);
                    System.out.println("Skill: " + jdbcSkillDao.getById(idSkill).getName() + " was successfully delete from "+
                            jdbcDeveloperDao.getById(idDeveloper).getFirstName()+" "+ jdbcDeveloperDao.getById(idDeveloper).getSurName());

                    chooseKeyboard = 1;
                    break;
                }
            }
            break;
        }
    }
}

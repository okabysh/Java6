package ua.earthsoft.goit.Java6.module_02.home_task.view;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Skill;
import ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao.impl.JdbcSkillDaoImpl;
import ua.earthsoft.goit.Java6.module_02.home_task.util.KeyboardUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class SkillView {
    private final String tableSkills = "\n#Main menu -> table: Skills#";
    private final String crudAction = "Please choose an action: 1-Create | 2-Read all | 3-Update | 4-Delete | 0-Return to main menu";
    private final String tableSkillsAction1 = "\n#Main menu -> table: Skills -> Create new skill#";
    private final String tableSkillsAction2 = "\n#Main menu -> table: Skills -> Read all skills#";
    private final String tableSkillsAction3 = "\n#Main menu -> table: Skills -> Update skill#";
    private final String tableSkillsAction4 = "\n#Main menu -> table: Skills -> Delete skill#";

    private KeyboardUtil keyboardUtil = new KeyboardUtil();
    JdbcSkillDaoImpl jdbcSkillDao = JdbcSkillDaoImpl.getInstance();
    int chooseKeyboard;

    private final int create=1;
    private final int readAll=2;
    private final int update=3;
    private final int delete=4;
    private final int returnToMainMenu=0;

    public void view() throws IOException {
        System.out.println(tableSkills);
        System.out.println(crudAction);

        while (true) {
            chooseKeyboard = keyboardUtil.inputInt();
            switch (chooseKeyboard) {
                case returnToMainMenu: {
                    chooseKeyboard = 1;
                    break;
                }
                case create: {
                    String name;

                    System.out.println(tableSkillsAction1);
                    System.out.println("Please enter all parameters for new skill:");
                    System.out.println("Enter name:");
                    name = keyboardUtil.inputString();

                    Skill skill = new Skill();
                    skill.setName(name);

                    jdbcSkillDao.create(skill);

                    System.out.println("Skill created successfully:");
                    System.out.println(skill.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case readAll: {
                    System.out.println(tableSkillsAction2);
                    List<Skill> skillList = jdbcSkillDao.read();
                    for (Skill skill : skillList) {
                        System.out.println(skill.toString());
                    }

                    chooseKeyboard = 1;
                    break;
                }
                case update: {
                    int id;
                    Skill skill;

                    System.out.println(tableSkillsAction3);
                    System.out.println("Please enter id for update skill:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();
                    System.out.println("Current skill data:");
                    skill = jdbcSkillDao.getById(id);
                    System.out.println(skill.toString());

                    System.out.println("Enter new name:");
                    skill.setName(keyboardUtil.inputString());

                    jdbcSkillDao.update(skill);

                    System.out.println("Skill updated successfully:");
                    System.out.println(skill.toString());

                    chooseKeyboard = 1;
                    break;
                }
                case delete: {
                    int id;

                    System.out.println(tableSkillsAction4);
                    System.out.println("Please enter id for delete skill:");
                    System.out.println("Enter id:");
                    id = keyboardUtil.inputInt();

                    jdbcSkillDao.delete(id);

                    System.out.println("Skill deleted successfully.");

                    chooseKeyboard = 1;
                    break;
                }
            }
            break;
        }
    }
}

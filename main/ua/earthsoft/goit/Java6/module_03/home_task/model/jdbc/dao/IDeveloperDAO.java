package ua.earthsoft.goit.Java6.module_03.home_task.model.jdbc.dao;

import ua.earthsoft.goit.Java6.module_03.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_03.home_task.model.Skill;

import java.util.List;

/**
 * Created by kabysh_ol on 22.06.2017.
 */
public interface IDeveloperDAO {

    public void create(Developer developer);

    public List<Developer> read();

    public void update(Developer developer);

    public void delete(int id);

    public Developer getById(int id);

    public void addSkillByDeveloper(int developerId, int skillId);

    public void deleteSkillByDeveloper(int developerId, int skillId);

    public List<Skill> getSkillsByDeveloper(int developerId);

}

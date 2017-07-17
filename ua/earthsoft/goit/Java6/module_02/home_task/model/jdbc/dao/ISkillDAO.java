package ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Skill;

import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public interface ISkillDAO {

    public void create(Skill skill);

    public List<Skill> read();

    public void update(Skill skill);

    public void delete(int id);

    public Skill getById(int id);

}

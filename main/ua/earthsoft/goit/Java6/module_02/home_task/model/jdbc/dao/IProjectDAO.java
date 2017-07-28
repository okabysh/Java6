package ua.earthsoft.goit.Java6.module_02.home_task.model.jdbc.dao;

import ua.earthsoft.goit.Java6.module_02.home_task.model.Developer;
import ua.earthsoft.goit.Java6.module_02.home_task.model.Project;

import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public interface IProjectDAO {

    public void create(Project project);

    public List<Project> read();

    public void update(Project project);

    public void delete(int id);

    public Project getById(int id);

    public List<Developer> getDevelopers(int projectId);

}

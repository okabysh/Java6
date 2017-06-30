package earthsoft.goit.Java6.Module_02.HomeTask.Model;

import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public interface IProject {

    public void create(Project project);

    public List<Project> read();

    public void update(Project project);

    public void delete(int id);
}

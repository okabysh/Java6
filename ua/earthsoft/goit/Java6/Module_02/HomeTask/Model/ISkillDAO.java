package earthsoft.goit.Java6.Module_02.HomeTask.Model;

import java.util.List;

/**
 * Created by kabysh_ol on 30.06.2017.
 */
public interface ISkillDAO {

    public void create(Skill skill);

    public List<Skill> read();

    public void update(Skill skill);

    public void delete(int id);

}

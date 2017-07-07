package ua.earthsoft.goit.Java6.Module_02.HomeTask.Model;

import java.util.List;

/**
 * Created by kabysh_ol on 22.06.2017.
 */
public interface IDeveloperDAO {

    public void create(Developer developer);

    public List<Developer> read();

    public void update(Developer developer);

    public void delete(int id);

}

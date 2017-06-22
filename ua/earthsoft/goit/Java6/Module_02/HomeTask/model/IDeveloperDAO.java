package earthsoft.goit.Java6.Module_02.HomeTask.model;

import java.sql.Connection;

/**
 * Created by kabysh_ol on 22.06.2017.
 */
public interface IDeveloperDAO {
    public boolean create(Developer developer, Connection connection);
    //public List
}

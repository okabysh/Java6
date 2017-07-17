package ua.earthsoft.goit.Java6.module_02.home_task.drivers;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class RegisterDriver {
    public boolean register() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }
}

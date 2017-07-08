package ua.earthsoft.goit.Java6.Module_02.HomeTask.Drivers;

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

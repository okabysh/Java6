package ua.earthsoft.goit.Java6.module_02.home_task;

import ua.earthsoft.goit.Java6.module_02.home_task.drivers.RegisterDriver;
import ua.earthsoft.goit.Java6.module_02.home_task.view.MainView;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by kabysh_ol on 21.06.2017.
 */
public class Launch {

    public static void main(String[] args) throws IOException, ParseException {

        RegisterDriver registerDriver = new RegisterDriver();
        if (!registerDriver.register()) {
            System.out.println("Do not registered driver.");
            System.exit(1);
        }

        MainView mainView = new MainView();
        mainView.view();

    }

}

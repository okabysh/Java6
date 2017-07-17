package ua.earthsoft.goit.Java6.module_02.Mrachkovskiy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kabysh_ol on 19.06.2017.
 */

public class Launch {
    private static final Logger LOGGER = LoggerFactory.getLogger(Launch.class);

    public static void main(String[] args) {
        LoadDriver();
    }


    private static void LoadDriver() {
        try {
            LOGGER.info("Loading JDBC driver...");
            Class.forName("com.mysql.jdbc.Driver");
            LOGGER.info("Driver successfully loaded.");
        } catch (ClassNotFoundException e) {
            LOGGER.error("Can not find driver for My SQL Server");
            throw new RuntimeException(e);
        }
    }
}

package ua.earthsoft.goit.Java6.module_02.home_task.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;

/**
 * Created by kabysh_ol on 17.07.2017.
 */
public class KeyboardUtil {
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String inputString() throws IOException {
        return bufferedReader.readLine();
    }

    public int inputInt() throws IOException {
        int number = 0;
        try {
            number = Integer.parseInt(bufferedReader.readLine());
        }catch (NumberFormatException e){
            System.out.println("Incorrect input data! Please enter valid value (type: int).");
            inputInt();
        }
        return number;
    }

    public BigDecimal inputBigDecimal() throws IOException {
        BigDecimal number = BigDecimal.valueOf(0);
        try {
            number = BigDecimal.valueOf(Double.parseDouble(bufferedReader.readLine()));
        }catch (NumberFormatException e){
            System.out.println("Incorrect input data! Please enter valid value (type: DigDecimal).");
            inputBigDecimal();
        }
        return number;
    }

    public Date inputDate() throws IOException, ParseException {
        Date date = Date.valueOf("1900-01-01");
        try {
            date = Date.valueOf(bufferedReader.readLine());
        }catch (NumberFormatException e){
            System.out.println("Incorrect input date! Please enter valid value (type: Data[yyyy.MM.dd]).");
            inputDate();
        }
        return date;
    }
}

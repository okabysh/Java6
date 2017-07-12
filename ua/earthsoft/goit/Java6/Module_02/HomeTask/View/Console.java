package ua.earthsoft.goit.Java6.Module_02.HomeTask.View;

import ua.earthsoft.goit.Java6.Module_02.HomeTask.Other.CRUD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Oleg Kabysh on 12.07.2017.
 */
public class Console {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static String table;
    public static CRUD crud;

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static String inputLine() throws IOException {
        return bufferedReader.readLine();
    }

    public static int inputInt() throws IOException {
        int number = 0;
        try {
            number = Integer.parseInt(bufferedReader.readLine());
        }catch (NumberFormatException e){
            Console.printMessage("Incorrect input data! Please enter valid value (type: int).");
            inputInt();
        }
        return number;
    }

}

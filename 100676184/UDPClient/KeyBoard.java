import java.util.*;
import java.time.*; // not use, may be helpful
import java.text.*;

/**
 * KeyBoard class that has methods to manage input data
 * 
 * @author Ashley & Hanlin
 * @version 13/10/2015
 */

public class KeyBoard{

    private static Scanner in = new Scanner(System.in);
    
    public static String getString(String prompt)
    {
        System.out.print(prompt + " :");
        return in.nextLine();
    }

    public static double getDouble(String prompt)
    {
        double value = 0.0;
        while(true)
        {
            try
            {
                System.out.print(prompt + " ");
                value = Double.parseDouble(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid Integer");
            }
        }
        return value;  
    }

    public static int getInteger(String prompt)
    {
        Integer value = 0;
        while(true)
        {
            try
            {
                System.out.print(prompt + " ");
                value = Integer.parseInt(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid Integer");
            }
        }
        return value;  
    }

    public static LocalDate getLocalDate(String prompt)
    {
        LocalDate value = null;

        while(true)
        {
            try
            {
                System.out.println(prompt + ": in format YYYY-MM-DD");
                value = LocalDate.parse(in.nextLine());
                break;
            }
            catch(Exception e)
            {
                System.out.println("Not a valid LocalDate");
            }
        }
        return value;  
    }

    public static void println(String toPrint)
    {
        System.out.println(toPrint);
    }

}
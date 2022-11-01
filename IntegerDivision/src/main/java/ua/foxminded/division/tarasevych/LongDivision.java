package ua.foxminded.division.tarasevych;

import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LongDivision {
    static Logger logger = Logger.getLogger(LongDivision.class);

    public static void main(String... args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        PropertyConfigurator.configure(classLoader.getResource("log4j.properties "));
        logger.info("For quit write \"q or Q\" \n");
        Scanner scan = new Scanner(System.in);
        int dividend = 0;
        int divider = 0;

        while (!String.valueOf(dividend).equalsIgnoreCase("q")) {
            dividend = scan.nextInt();
            divider = scan.nextInt();
            logger.info(Division.longDivision(dividend, divider));
        }
        scan.close();
    }
}

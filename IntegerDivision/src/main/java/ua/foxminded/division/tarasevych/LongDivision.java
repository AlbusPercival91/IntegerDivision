package ua.foxminded.division.tarasevych;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LongDivision {
    static Logger logger = Logger.getLogger(LongDivision.class);

    public static void main(String... args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        PropertyConfigurator.configure(classLoader.getResource("log4j.properties "));
        logger.info("For quit type \"q or Q\" \n");
        boolean exit = false;
        Scanner scan = new Scanner(System.in);

        while (!exit) {
            try {
                while (scan.hasNext()) {
                    int dividend = scan.nextInt();
                    int divider = scan.nextInt();
                    logger.info(Division.longDivision(dividend, divider));
                    scan.reset();
                }
            } catch (InputMismatchException e) {
                if (scan.next().equalsIgnoreCase("q")) {
                    exit = true;
                    logger.error("Exit OK");

                } else {
                    logger.error("Invalid Input");
                    scan.reset();
                }
            }
        }
        scan.close();
    }
}

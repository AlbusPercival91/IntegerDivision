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
        logger.info("For quit write \"q or Q\" \n");
        
        try (Scanner scan = new Scanner(System.in)) {
            int dividend = -1;
            int divider = -1;

            try {
                while (!String.valueOf(dividend).equalsIgnoreCase("q")) {
                    dividend = scan.nextInt();
                    divider = scan.nextInt();

                    if (dividend == 0) {
                        throw new IllegalArgumentException("Dividend cannot be 0");
                    }
                    logger.info(Division.longDivision(dividend, divider));
                }
            } catch (InputMismatchException e) {
                System.exit(0);
            }
        }
    }
}

package app;

import app.frontend.windows.MainMenu;
import app.tests.MainTest;

import java.util.*;

/**
 * Main of the program, it's a menu where the user can choose the role
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class Main {
    /**
     * Open role selector menu
     *
     * @param args arguments
     */

    public static void main(String args[]) {
        if (parseArgs(args)){
            MainMenu m = new MainMenu();
            m.setVisible(true);
        }
        

    }

    private static boolean parseArgs(String[] inputArgs) {
        List<String> args = Arrays.asList(inputArgs);
        if (args.contains("-test") || args.contains("-t")) {
            return MainTest.test();
        }
        else{
            return true;
        }
    }

}

package app.backend;

import app.frontend.windows.MainMenu;

/**
 * Main of the program, it's a menu where the user can choose the role
 */
public class Main {
    /**
     * Open role selector menu
     *
     * @param args
     */

    public static void main(String args[]) {
        System.out.print("Ciao");
        MainMenu m = new MainMenu();
        m.setVisible(true);

    }
}

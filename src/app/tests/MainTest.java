package app.tests;
/**
 * this class directs the execution of the tests
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class MainTest {
    public static boolean test() {
        boolean passed = true;

        System.out.println("Restaurant Manager Test");
        System.out.println("_________________________");

        System.out.println("Test number 1:");
        if (!FrameTest.test()) {
            passed = false;
        }

        System.out.println("Test number 2:");
        if (!MenuTest.test()) {
            passed = false;
        }

        System.out.println("Test number 3:");
        if (!OrderManagerTest.test()) {
            passed = false;
        }

        System.out.println("Test number 4:");
        if (!ReceiptTest.test()) {
            passed = false;
        }
        if (passed) {
            System.out.println("ALL TEST PASSED SUCCESSFULLY");
        }
        return passed;
    }
}

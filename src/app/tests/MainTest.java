package app.tests;

public class MainTest {
    public static boolean test(){
        boolean passed=true;

        System.out.println("Restaurant Manager Test");
        System.out.println("_________________________");

        System.out.println("Test number 1:\n");
        if(!FrameTest.test()){passed=false;}

        System.out.println("Test number 2:\n");
        if(!MenuTest.test()){passed=false;}

        System.out.println("Test number 2:\n");
        if(!OrderManagerTest.test()){passed=false;}

        System.out.println("Test number 3:\n");
        if(! ReceiptTest.test()){passed=false;}

        return passed;
    }
}

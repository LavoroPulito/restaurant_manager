package app.tests;

import app.backend.OrderManager;
import app.backend.*;

import java.io.File;

/**
 * this class generates a receipt and compares the text with the expected text, then checks that there are no errors while saving the receipt
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */
public class ReceiptTest {

    public static boolean test() {
        System.out.print("Receipts Test: ");
        return ReceiptTest.checkReceiptGenerated();


    }

    private static boolean checkReceiptGenerated() {

        System.out.println("Checking Receipts..");
        String testStringReceipt = "\nTab 99999\nTest                         8.0\nTest1                        8.0\nTest2                        8.0\n\nTOTAL: 24.0€  of which VAT: 2.4€";
        OrderManager om = new OrderManager();
        om.load();
        om.add(new Order(new Dish("Test", 8.0, "", "second"), 99999, ""));
        om.add(new Order(new Dish("Test1", 8.0, "", "second"), 99999, ""));
        om.add(new Order(new Dish("Test2", 8.0, "", "second"), 99999, ""));
        Receipt receipt = new Receipt();
        receipt.addOrders(om.getRegister().get(99999));
        receipt.writeReceipt();
        if (!receipt.getReceiptText().equals(receipt.getTitle()+testStringReceipt)) {
            System.out.println("string receipt different from what expected\n"+testStringReceipt+"\n"+receipt.getReceiptText());
            return false;
        }
        System.out.println("receipt generation: Test passed\n");
        receipt.enterAmount(100);
        receipt.getTotal();
        receipt.writeEndReceipt();

        try {
            receipt.save();
            File dir = new File("Saves/Receipts");
            String[] ls = dir.list();
            if (!dir.exists() || ls.length == 0) {
                System.out.println(ls);
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        System.out.println("receipt saving: Test passed");
        return true;

    }
}

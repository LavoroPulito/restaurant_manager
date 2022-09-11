package app.tests;

import app.backend.OrderManager;
import app.backend.*;

public class ReceiptTest {
    public static boolean test() {
        System.out.print("Receipts Test: ");
        boolean passed= true;
        
        ReceiptTest.checkReceiptGenerated();

        return passed;
    }

    private static boolean checkReceiptGenerated(){

        System.out.println("Checking Receipts..");
        OrderManager om = new OrderManager();
        om.load();
        om.add(new Order(new Dish("Test",8.0,"","second"),99999,""));
        om.add(new Order(new Dish("Test1",8.0,"","second"),99999,""));
        om.add(new Order(new Dish("Test2",8.0,"","second"),99999,""));
        Receipt receipt = new Receipt();
        receipt.addOrders(om.getRegister().get(99999));
        receipt.writeRecipt();
        receipt.enterAmount(100);
        receipt.getTotal();
        receipt.writeEndReceipt();
        receipt.save();
        return true;
    }

}

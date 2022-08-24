public class ReceiptTest {
    public static void main(String[] args) {
        /*
        Merda scontrino = new Merda();
        scontrino.preCount(1);
        scontrino.getReceipt(60);

         */
        OrderManager orderManager = new OrderManager();
        orderManager.load();
        Receipt receipt = new Receipt();
        receipt.addOrders(orderManager.getRegister().get(99));
        receipt.writeRecipt();
        System.out.println(receipt.getReciptText());
        receipt.enterAmount(100);
        receipt.getTotal();
        receipt.writeEndReceipt();
        System.out.println(receipt.getReciptText());


    }

}

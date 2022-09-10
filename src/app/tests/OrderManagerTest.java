package app.tests;

import app.backend.*;

public class OrderManagerTest {


    public static boolean test() {
        boolean passed=true;
        System.out.println("Manage orders test\n");

        if(! OrderManagerTest.createTableTest()){passed=false;}
        if(! OrderManagerTest.appendToTableTest()){passed=false;}

        return passed;
    }

    private static boolean createTableTest(){
        System.out.print("Create table test: ");
        OrderManager om = new OrderManager();
        int size1=om.getTableList().size();
        om.load();
        om.add(new Order(new Dish("Test",8.0,"","second"),99999,""));
        om.save();
        om.load();
        int size2=om.getTableList().size();
        if (size1==size2){
            System.out.println("The program doesn't create new tables\n");
            return false;
        }
        om.cleanTable(99999);
        om.save();
        System.out.println("Test passed\n");
        return true;
    }

    private static boolean appendToTableTest(){
        System.out.print("Append to table test: ");
        OrderManager om = new OrderManager();
        om.load();
        om.add(new Order(new Dish("Test",8.0,"","second"),88888,""));
        om.save();
        om.load();
        om.add(new Order(new Dish("Test1",8.0,"","second"),88888,""));
       if( om.getRegister().get(88888).size()!=2){
        System.out.println("The program doesn't append new orders at tables\n");
        om.cleanTable(88888);
        om.save();
        return false;
        }
        om.cleanTable(88888);
        om.save();
        System.out.println("Test passed\n");
        return true;
    }


}

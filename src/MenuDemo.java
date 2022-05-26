
/*
classe demo per testare la classe MenuDish e la classe Dish
 */

public class MenuDemo {
    public static void main(String[] args) {
        /*
        //creo un menù e aggiungo dei piatti
        DishMenu carta = new DishMenu();
        carta.add(new Dish("pasta con tonno", 8.0, "pasta con tonno","Primo"));
        carta.add(new Dish("pasta al pesto", 10.0, "pasta con basilico e parmigiano", "Primo"));
        carta.add(new Dish("sorbetto al limone", 9.0, "tipo gelato", "Dolce"));
        carta.add(new Dish("calamari", 23.4, "calamari fritti","Secondo"));
        carta.add(new Dish("patate", 13, "patate lesse","Secondo"));
        carta.add(new Dish("pasta al sugo", 10, "pasta col pomodoro","Primo"));
        carta.add(new Dish("tiramisù", 15, "mascarpone e caffè","Dolce"));

        //stampo il menù in un dizionario ordinato per portate
        System.out.println("dizionario per portate:");
        System.out.println(carta.getMenu());
        System.out.println(" ");

        //stampo un menu come lista tutti i piatti:
        System.out.println("in array:");
        System.out.println(carta.toArrayList());
        System.out.println(" ");

        //stampo le portate dei piatti
        for (String key :
                carta.getMenu().keySet()) {
            System.out.println(key);
            System.out.println(carta.getMenu().get(key));
            System.out.println(" ");

        }
        //cambio la disponibilità
        carta.getDish("sorbetto al limone").switchAvailable();

        //creo un file Json di tutto il menù, lo stampo e lo salvo
        System.out.println(carta.toJson());
        carta.save();
        
        

        //ricreo un nuovo menù partendo dal file json salvato
        System.out.println("qua");
        carta.load();
        System.out.println("pure qua");
        //recupero un piatto tramite getDish passando una stringa e lo stampo
        Dish next_del = carta.getDish("patate", "Secondo");
        System.out.println(next_del);
        Dish getDish = carta.getDish("patate");
        System.out.println(getDish);
        //elimino il piatto recuperato
        carta.removeDish(next_del );

        //stampo il menù modificato modificato
        System.out.println("al ritorno:");
        System.out.println(carta.getMenu().toString());


        DishMenu dm = new DishMenu();
        dm.load();
        System.out.println(dm.getMenu());
        */
        DishMenu carta = new DishMenu();
        carta.load();
        System.out.println(carta.getMenu());

        carta.add(new Dish("pasta con tonno", 8.0, "pasta con tonno","Primo"));
        carta.add(new Dish("pasta al pesto", 10.0, "pasta con basilico e parmigiano", "Primo"));
        carta.add(new Dish("sorbetto al limone", 9.0, "tipo gelato", "Dolce"));
        carta.add(new Dish("calamari", 23.4, "calamari fritti","Secondo"));
        carta.add(new Dish("patate", 13, "patate lesse","Secondo"));
        carta.add(new Dish("pasta al sugo", 10, "pasta col pomodoro","Primo"));
        carta.add(new Dish("tiramisù", 15, "mascarpone e caffè","Dolce"));

        System.out.println(carta.getMenu());
        carta.save();


    }
}

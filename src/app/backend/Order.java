package app.backend;

import java.util.Objects;
/**
 * This class creates and describes an order
 * 
 * @author Armando Coppola
 * @author Niccolò Di Santo
 * @author Francesco Daprile
 * @version 1.0
 */

 public class Order {
    /**
     * Name of the dish
     */
    private String dishName;
    /**
     * Price of the dish
     */
    private double dishPrice;
    /**
     * State of the order
     */    
    private int state;
    /**
     * Table of the order
     */    
    private int table;
    /**
     * notes of the order
     */
    private String note;
    /**
     * Possible states of the order
     */
    private static String[] states = {"preparation", "ready", "delivered"};

    /**
     * Creates a new order
     * 
     * @param dish
     * @param table
     * @param note
     */
    public Order(Dish dish, int table, String note) {
        this.dishName = dish.getName();
        this.dishPrice = dish.getPrice();
        this.table = table;
        this.note = note;
        state = 0;
    }

    /**
     * Creates a new order
     * 
     * @param dishName
     * @param dishPrice
     * @param table
     * @param note
     */
    public Order(String dishName, double dishPrice, int table, String note) {
        this.dishName = dishName;
        this.dishPrice = dishPrice;
        this.table = table;
        this.note = note;
        state = 0;
    }
/**
 * return the dish price
 * @return dishPrice
 */
    public double getDishPrice() {
        return dishPrice;
    }
/**
 * return the table of the order
 * @return table
 */
    public int getTable() {
        return table;
    }

/**
 * Sets the state
 * @param state
 */
    public void setState(int state) {
        this.state = state;
    }

    //imposta automaticamente il prossimo stato, dopo l'ultimo stato ricomincia da capo
/**
 * Sets automatically the next state, after state 2 returns to 0
 */
    public void setNextState() {
        int nextState = state + 1;
        if (nextState < states.length) {
            setState(state + 1);
        } else {
            state = 0;
        }

    }
/**
 * return the dish name
 * @return dishName
 */
    public String getDishName() {
        return dishName;
    }

/**
 * return the order note
 * @return note
 */
    public String getNote() {
        return note;
    }

/**
 * return the order state
 * @return state
 */
    public String getState() {
        return states[this.state];
    }

/**
 * writes the order information in string
 * @return dishPrice
 */
    @Override
    public String toString() {
        return table+", "+dishName+": "+note;
    }

/**
 * compares this object with another, if it is an order and has the same attributes are equals
 * @return dishPrice
 */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return state == order.state && table == order.table && Objects.equals(dishName, order.dishName) && Objects.equals(note, order.note);
    }

}

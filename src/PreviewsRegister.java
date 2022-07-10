import java.util.ArrayList;

public class PreviewsRegister {
    private ArrayList<OrderPreview> previews;
    public PreviewsRegister(){
        previews = new ArrayList<>();
    }

    public void increment(OrderPreview orderPreview){
        int i= previews.indexOf(orderPreview);
        previews.get(i).increment();

    }

    public void decrement(OrderPreview orderPreview){
        int i= previews.indexOf(orderPreview);
        previews.get(i).decrement();
        if(previews.get(i).getQuantity()==0){
            previews.remove(i);
        }
    }
    public void setQuantity(OrderPreview orderPreview, int q){
        int i= previews.indexOf(orderPreview);
        previews.get(i).setQuantity(q);
    }
    public void addOrder(OrderPreview orderPreview){
        if (previews.contains(orderPreview)){
            increment(orderPreview);
        }else{
            previews.add(orderPreview);
        }
    }

    public void clear(){
        previews.clear();
    }

    public ArrayList<OrderPreview> getPreviews() {
        return previews;
    }
    public ArrayList<Order> toOrders(){
        ArrayList<Order> orders = new ArrayList<>();
        for (OrderPreview p:
        previews){
            for (int i = 0; i<p.getQuantity();i++){
                orders.add(p.toOrder());
            }
        }
        return orders;
    }
}

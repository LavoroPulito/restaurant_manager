import java.util.ArrayList;

public class PreviewsRegister {
    private ArrayList<OrderPreview> previews;
    public PreviewsRegister(){
        previews = new ArrayList<>();
    }

    public void increment(OrderPreview orderPreview){
        int i= previews.indexOf(orderPreview);
        previews.get(i).setQuantity(orderPreview.getQuantity()+1);
    }

    public void decrement(OrderPreview orderPreview){
        int i= previews.indexOf(orderPreview);
        previews.get(i).setQuantity(orderPreview.getQuantity()-1);
        if(previews.get(i).getQuantity()==0){
            previews.remove(i);
        }
    }

    public void addOrder(OrderPreview orderPreview){
        if (previews.contains(orderPreview)){
            increment(orderPreview);
        }else{
            previews.add(orderPreview);
        }
    }

    public ArrayList<OrderPreview> getPreviews() {
        return previews;
    }
}

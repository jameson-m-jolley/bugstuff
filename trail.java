public class trail extends item {
    // this is a colection class of location
    private final Node<coordinate> head;
    private int lifetime;
    private int range;


    public boolean smells(ant a){
       for(Node<coordinate> c = head; c != null;c = c.GetNext()){
            if (c.GetData().withInRange(a.getLocation(), range)){
                return true;
            }
       }
    }
    
}
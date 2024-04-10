import java.util.HashMap;

public class item {
    //this is the new way of doing it
    //private static final Node<item> ItemHead = new Node<item>();

    //depracate this it ends up removing items with the same quord
    private static HashMap<coordinate,item> items = new HashMap<coordinate,item>();
    private coordinate location;
    private int size;
    private double r,g,b;
   
    public item(){
        size =3;
        location = new coordinate();
        items.put(location, this);
        //ItemHead.addNodeAfterThis(this);
        //System.out.println(ItemHead);
    }

    public item(int x,int y){
        size =3;
        location = new coordinate(x,y);
        items.put(location, this);
        //ItemHead.addNodeAfterThis(this);
        //System.out.println(ItemHead);
    }

    public coordinate getLocation(){
        return location;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public static HashMap<coordinate,item> getItems(){
        return items;
    }
    public static void setItems( HashMap<coordinate,item> map){
        items = map;
    }
    public void update(){
       // System.err.println(this + "was updated\n");
    }
    public static void updateAll(){
        HashMap<coordinate,item> clone = (HashMap<coordinate,item>)getItems().clone();
        clone.forEach((k,v) -> v.update());
    }
    public String toString(){
        String ret=""+ this.getClass()+"::";
        ret +="location: "+ location.toString() +"\n";
        ret +="[r,g,b]: "+ "["+r+","+g+","+b+"]"+"\n";
        ret +="size: "+ size+"";
        return ret;
    }
}

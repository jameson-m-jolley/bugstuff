import javax.swing.JFrame;

/**
 * coordinate
 */
public class coordinate {
    private int x;
    private int y;
    private JFrame frame;// ref to the frame

    public static coordinate max = new coordinate(1920,1080);

    public coordinate(){
        x=0;
        y=0; 
    }
    public coordinate(int x,int y){
        this.x=x;
        this.y=y; 
    }
  
    public coordinate clone(){
        return new coordinate(this.x, this.y);
    }

    public boolean withInRange(coordinate a, int r){
        int difx = Math.abs(a.getX()-this.getX());
        int dify = Math.abs(a.getY()-this.getY());

        if (r > difx){
            if (r > dify) {
                return true;
            }
        }        
        return false;

    }

    public void setX(int x){

        if(x <= max.getX())
        this.x = x;
        else{
            while (x > max.getX()) {
                x -= max.getX();
            }
            this.x =x;
        } 
        
    }

    public void setY(int y){
        
        if(y <= max.getY())
        this.y = y;
        else{
            while (y > max.getY()) {
                y -= max.getY();
            }
            this.y =y;
        } 
    }
    
    public int getY(){
        return this.y;
    }
    
    public int getX(){
        return this.x;
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
    public boolean equals(Object obj){
        if(obj instanceof coordinate){
            coordinate Nobj = (coordinate)obj;
            if(x != Nobj.getX())
            return false;
            if(y != Nobj.getY())
            return false;

            return true;
            
        }else{
            return false;
        }
    }
    
}
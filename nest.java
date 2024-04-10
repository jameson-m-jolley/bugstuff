import java.util.Random;

public class nest extends item {
    private double food;
    
    public nest(){
        super();
        food = 100;
        setSize((int)food);
        
    }

    public nest(int x, int y){
        super(x,y);
        food = 100;
        setSize((int)getFood());
        
    }
    

    public double getFood() {
        return food;
    }
    public void setFood(double food) {
        this.food = food;
    }

    public void addFood(double x){
        food += x;
    }
    @Override
    public void update(){
        setSize((int)getFood()/6);
    }
}

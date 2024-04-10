import java.util.HashMap;
import java.util.Random;
import java.util.random.*;

/**
 * ant
 */
public class ant extends movable {
    public static Random rand = new Random(System.nanoTime());
    public static nest home = new nest(920,480);
    private double food;
    private boolean queen;
    private coordinate going;

    //makes an ant 
    public ant(){
     super();
     food = 2;   
     going = new coordinate(rand.nextInt(1920),rand.nextInt(1080));
    }
    //makes an ant 
    public ant(int x, int y){
        super(x,y);
        food = 10;   
        moveTo(x, y);
        going = new coordinate(rand.nextInt(1920),rand.nextInt(1080));
       }
   //to tell of the ant is alive 
    public boolean isAlive(){
        if(food < 0){
            return false;
        }else{
            return true;
        }
    } 
    public void setFood(double food) {
        this.food = food;
    }
    public double getFood(){
        return this.food;
    }

    public boolean isHome(){
        if(home.getLocation().equals(getLocation())){
            return true;
        }else{ 
            return false;
        }
    }

    

    private void deposit(){
        home.addFood(this.getFood()-1.0);
        this.food = 1;
    }

    private int[] randmove(){
        int[] ret = {(rand.nextInt(2)==1)?-1:1,(rand.nextInt(2)==1)?-1:1};
        return ret;
    }

    private boolean lookForFood(){
        if(food < 1) return true;
        else return false;
    }


    @Override
    public void update(){

        if(isAlive()){
            super.update();
            //System.err.println("going:"+this.going);
            food -= 0.000001;
            pathfind();
            
        }else{
            // the insect dies
            getItems().remove(getLocation());
        }
    }   

    public coordinate getGoing() {
        return going;
    }

    public void setGoing(coordinate g){

        going = g.clone();
    }
    
    


    private void pathfind(){
    // look for a trail or the smell of food 
    if(lookForFood()){
        item.getItems().forEach((k,v) -> {
            if(v instanceof food){
                food val = (food)v;
                if(this.getLocation().withInRange(k,val.getSmellStrength()+val.getSize())){
                       this.setGoing(k); 
                       if(getLocation().equals(going)){
                        setFood(getFood()+(double)val.take(1));
                       }
                   
                }
            }
       });
    } 


        int[] vec = {0,0};

        //x con
        if(getLocation().getX() == going.getX()){
            //do nothing
        }else if(getLocation().getX() > going.getX()){
            vec[0]=-1;
        }else if(getLocation().getX() < going.getX()){
            vec[0]=1;
        }

        //y con
        if (getLocation().getY() == going.getY()){
            //do nothing
        }else if(getLocation().getY() >going.getY()){
            vec[1]=-1;
        }else if(getLocation().getY() < going.getY()){
            vec[1]=1;
        }

        this.moveTo(vec[0], vec[1]);

        if(getLocation().equals(going)){
            if(lookForFood()){
                //System.err.println("fin;"+this);
                //lookes for food nearb

                
                // if canf find it set a radme location 
               
                vec[0] = rand.nextInt(1920);
                vec[1] = rand.nextInt(1080);
                this.setGoing(vec);
            }else{
                setGoing(home.getLocation());
                if(isHome()){
                    deposit();
                }
            }
        }

    }

    public void setGoing(int[] going) {
        // check if the (x,y) is valid

        if(going[0]>1920){
            going[0]-=1920;
        }
        if(going[0]<0){
            going[0]+=1920;
        }
        if(going[1]>1080){
            going[1]-=1080;
        }
        if(going[1]<0){
            going[1]+=1080;
        }
     
        this.going.setX(going[0]);
        this.going.setY(going[1]);
    }
}
public class food extends item {
    private int food;
    private int smellStrength;
    public food(int x,int y){
        super(x,y);
        food = 100;
        setSize(food); 
        smellStrength = 100;
    }

    public int getFood() {
        return food;
    }
    public void setFood(int food) {
        if (food < 0){
             throw(new IllegalArgumentException());
        }else{
            this.food = food;
            this.setSize(food);
        }
    }
    public int take(int val){
        try {
            setFood(getFood()-val);
            return val;
        } catch (Exception e) {
            return take(val-1);
        }
    }

    public void setSmellStrength(int smellStrength) {
        if(smellStrength<0){
            System.out.println("not a valid smellStr R;[0,inf) val was:"+getSmellStrength());
            setSmellStrength(smellStrength+45);
        } 
        this.smellStrength = smellStrength;
    }

    public int getSmellStrength() {
        return smellStrength;
    }
    @Override
    public void update(){
        if(smellStrength > 1) smellStrength--;
    }
}

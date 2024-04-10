public class movable extends item implements moveinterface {
    public movable(){
        super();
    };
    public movable(int x,int y){
        super(x,y);
    };

    
    public void translateY(int y){
        //updates the location of the val
        getItems().remove(getLocation());
        getLocation().setY(y+super.getLocation().getY());
        getItems().put(getLocation(),this);
       
    }
    public void translateX(int x){
       getItems().remove(getLocation());
       getLocation().setX(x+super.getLocation().getX());
       getItems().put(getLocation(),this);
    };

    @Override
    //moves by a vector
    public void moveTo(int x, int y) {
        getItems().remove(getLocation());
        getLocation().setY(y+super.getLocation().getY());
        getLocation().setX(x+super.getLocation().getX());
        getItems().put(getLocation(),this);
        
    }

}


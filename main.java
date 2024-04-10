import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.Random;
import javax.swing.Timer;


public class main extends Canvas {
    public static void main(String[] args) {

        Random rand = new Random();
        rand.setSeed(System.nanoTime());
        

        JFrame frame = new JFrame("My Ant simulation");
        Canvas canvas = new main();
        canvas.setSize(1920, 1080);
        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);
        
        
         ant car1 = new ant(rand.nextInt(1920),rand.nextInt(1080)); 
         for(int i=0; i<75;i++){
            car1 = new ant(rand.nextInt(1920),rand.nextInt(1080));
         }

         food f1 = new food(192,108);
         
         int numifiter = 0;
         Timer timer = new Timer(0, e ->{
            canvas.repaint();
            item.updateAll();
        } ); // Repaint every 10 milliseconds
        timer.start();

        //loop for the sim
        while (frame.isVisible()) {
            //System.out.println(ant.getItems());
            //canvas.getGraphics().clearRect(0,0,1920,1080);
            //canvas.paint(canvas.getGraphics());;
            //System.err.println(f1.getFood());
            if( f1.getFood() <= 5.0 ){
                timer.stop();
            }
        }
        System.err.println("simulation done");
    }

    public void paint(Graphics g) {
        item.getItems().forEach((k,v) -> {
            g.drawOval(v.getLocation().getX(), v.getLocation().getY(), 1, 1);
            g.drawOval(v.getLocation().getX()-v.getSize()/2, v.getLocation().getY()-v.getSize()/2, v.getSize(), v.getSize());
        });

    }
}

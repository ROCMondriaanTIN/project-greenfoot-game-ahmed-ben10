
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Enemy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    int frames=1;

    public Enemy() {
        super();
        setImage("spider.png");
        walkRange = 280;
        firstAct = true;
        speed = 3;
        
    }

    @Override
    public void act() {
        int x = getX();
        int y = getY();

        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = speed;
        applyVelocity();
        frames();
        if (getX() >= xMax) {
            speed *= -1;
            x = xMax;
        } else if (getX() <= xMin) {
            speed *= -1;
            x = xMin;
        }
    }
    public void frames()
    {
            if(frames==1)
            {
                setImage("spider.png");  
            }
            if(frames==2)
            {
                setImage("spider_walk1.png");  
               
            }
            if(frames==3)
            {
                setImage("spider_walk2.png");    
                frames=1;
            }
            frames++;    
    }
}

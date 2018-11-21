import java.util.*;
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class BadGuy extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private double speed=0.75;

    public BadGuy() {
        super();
        walkRange = 7000;
        firstAct = true;
        speed = 1;
    }

    @Override
    public void act() {
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int xpos=myHero.x;
        int ypos=myHero.y;
        int x= getX();
        int y = getY();
        int b=0;
        boolean dood=myHero.isDood;
        for(Actor d:getObjectsInRange (50,JumpTile.class))
        {
            
        int s=getY();
        s-=10;
        setLocation(x,s) ; 
        b=20;
        
        
        }
        
        if(dood)
        {
        setLocation((xpos+250),(ypos));   
        }
       
         
        if (firstAct) {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = 5;
        applyVelocity();
        if (getX() >= xMax) {
            speed *= -5-b;
            x = xMax;          
        } else if (getX() <= xMin) {
            speed *= -5-b;
            x = xMin;
        }
    }
}

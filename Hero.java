

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private static int gem;
    private static int x= 300;
    private static int y=200; 

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
        handleInput();
        getGemBlue();
        getPositie();
        checkpointVlag();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(x,y);
                break;
            }
        }
    }
    public void checkpointVlag()
    {
    if(isTouching(checkpoint.class))    
    {
    this.x=3547;
    y=673;
    }
    }
    
    public String getPositie()
    {
    String positiexy= "X"+this.getX() +"y:"+this.getY(); 
    return positiexy;
    }
    
    public int getGemBlue()
    {
    if(isTouching(gemBlue.class))    
    {
    removeTouching(gemBlue.class); 
    gem++;
    }  
    return gem;
    }
    public void handleInput() {
        if (Greenfoot.isKeyDown("Up")) {
            velocityY = -10;
        }

        if (Greenfoot.isKeyDown("Left")) {
            velocityX = -6;
        } else if (Greenfoot.isKeyDown("Right")) {
            velocityX = 6;
        }
    }

    public int getWidth() 
    {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}

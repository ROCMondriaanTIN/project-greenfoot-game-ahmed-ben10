
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    private int gem;

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
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                //getWorld().removeObject(this);
                setLocation(300,200);
                break;
            }
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

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}



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
    public static int x= 300;
    public static int y=200; 
    boolean inAir=true;

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
        touchingLava();
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
          
            if(((Door.class != null) && gem == 13))
            {  
                Greenfoot.setWorld(new MyWorld2());
                String actieveWereld="MyWorld2";
               
            }
       
       
    }
    public void touchingLava()
    {
       
    }
    public void checkpointVlag()
    {
    if(isTouching(Checkpoint.class))    
    {
    this.x=getX();
    this.y=getY();
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
        for (Actor Hero: getIntersectingObjects(Tile.class)){
        if (Greenfoot.isKeyDown("Up")) {
            inAir=true;
            velocityY = -15;
  
        }
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

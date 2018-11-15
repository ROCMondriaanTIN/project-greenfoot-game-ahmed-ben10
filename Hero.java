//

import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {

    private final double gravity;
    private final double acc;
    private final double drag;
    public  int gem=0;
    public  int x= 159;
    public  int y=913; 
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
        getGemBlue();
        level2();
        // getPositie();
        checkpointVlag();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        //for (Actor enemy : getIntersectingObjects(Enemy.class)) {
           // if (enemy != null) {
                //getWorld().removeObject(this);
                //setLocation(x,y);
                //break;
           // }
            // }
          for (Actor lavaTile : getObjectsInRange(84, LavaTile.class)) {
            if (lavaTile != null && lavaTile instanceof LavaTile ) {
               // getWorld().removeObject(this);
                setLocation(x,y);
                break;
            }
            }
            
       
      
    }
    public boolean level2()
    {
    boolean b=false;
    for(Actor door:getIntersectingObjects(Door.class)) 
       {
        if(((door!=null)) && (gem == 13))
            {  
                Greenfoot.setWorld(new MyWorld2());
                String actieveWereld="MyWorld2";   
                b=true;
                break;
            }   
            
        }  
   return b;      
    }
    public void checkpointVlag()
    {
    if(isTouching(Checkpoint.class))    
    {
    x=getX();
    y=getY();
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
            velocityY = -17;
  
        }
        else inAir=false;
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

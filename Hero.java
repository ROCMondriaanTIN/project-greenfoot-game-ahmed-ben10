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
    boolean key=false;

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
        key();
        touchingSchatkist();
        level2();
        removeBadGuy();
        // getPositie();
        checkpointVlag();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
        
          for (Actor lavaTile : getObjectsInRange(84, LavaTile.class)) {
            if (lavaTile != null && lavaTile instanceof LavaTile ) {
                setLocation(x,y);
                break;
            }
            }
            
       
      
    }
    
    public void touchingSchatkist()
    {
        if(isTouching(Schatkist.class)) 
        {
            removeTouching(Schatkist.class);
        }
    }
    public void removeBadGuy()
    {
        if(isTouching(BadGuy.class)) 
        {
            removeTouching(BadGuy.class);  
            this.getWorld().addObject(new Schatkist(),5809,673);
            return;
        }
    }
    
    public void level2()
    {
    
    for(Actor door:getIntersectingObjects(Door.class)) 
       {
        if(key==true)
        {   
            if(door!=null)
            {  
                
                  if(gem == 13)
                 {
                   
                   if(BadGuy.class !=null)
                   {
                       if(Schatkist.class!=null)
                       {
                       Greenfoot.setWorld(new MyWorld2());
                       String actieveWereld="MyWorld2";  
                       return;
                    }
                   }
                 } 
             }
                 
        }
        break;    
        }  
                
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
    
    public boolean key()
    {
    
    if(isTouching(Key.class))    
        {
        removeTouching(Key.class);
        key=true;
        }  
        return key;
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

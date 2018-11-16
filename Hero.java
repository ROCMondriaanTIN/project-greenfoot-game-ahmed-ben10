

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
    private int frame =1;
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
        lava();
        spikes();
        bomb();
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
    }
            public void lava()
            {
            for (Actor lavaTile : getObjectsInRange(50, LavaTile.class)) {
            if (lavaTile != null && lavaTile instanceof LavaTile ) {
               // getWorld().removeObject(this);
                setLocation(x,y);
                break;
            }
            }
        }
    
            public void spikes()
            {
             for (Actor SpikesTile : getObjectsInRange(50, SpikesTile.class)) {
            if (SpikesTile != null && SpikesTile instanceof SpikesTile ) {
                setLocation(x,y);
                break;
            }
            }
        }
       
         public void bomb()
            {
             for (Actor BombTile : getObjectsInRange(50, BombTile.class)) {
            if (BombTile != null && BombTile instanceof BombTile ) {
                setLocation(x,y);
                break;
            }
            }
        }
    
    public void touchingSchatkist()
    {
        if(key==true)
        {
            if(isTouching(Schatkist.class)) 
            {
                removeTouching(Schatkist.class);
                return;
            }
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
        if(isTouching(gemBlueTile.class))    
        {
        removeTouching(gemBlueTile.class); 
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
        if (Greenfoot.isKeyDown("Space")) {
            inAir=true;
            velocityY = -13;
  
        }
        else inAir=false;
    }
        if (Greenfoot.isKeyDown("Left")) {
            velocityX = -6;
        } else if (Greenfoot.isKeyDown("Right")) {
            velocityX = 6;
            frames();
        }
    }

public void frames()
{
        
        if(frame==1)
        {
        setImage("p1_walk01.png");

        }
        if(frame==2)
        {
        setImage("p1_walk02.png");
        }
        if(frame==3)
        {
        setImage("p1_walk03.png");
        }
        
        if(frame==4)
        {
        setImage("p1_walk04.png");
        
        }

        if(frame==5)
        {
        setImage("p1_walk05.png");
        
        }
        if(frame==6)
        {
        setImage("p1_walk06.png");
        
        }
        if(frame==7)
        {
        setImage("p1_walk07.png");
        
        }
        
        if(frame==8)
        {
        setImage("p1_walk08.png");
        }
        
        if(frame==9)
        {
        setImage("p1_walk09.png");
        
        }
        
        if(frame==10)
        {
        setImage("p1_walk10.png");
        }
        
        if(frame==11)
        {
        setImage("p1_walk11.png");
        frame=1;
        return ;
        }
        frame++;
}   

 public int getWidth() 
    {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}


   
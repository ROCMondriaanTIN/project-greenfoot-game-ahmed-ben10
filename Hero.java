

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
    private int snelheid;
    boolean inAir=true;
    boolean key=false;
    boolean level2=false;
    boolean schatkist=false;
    boolean isDood;

    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
        isDood=false;
        handleInput();
        boostSnelheid();
        lava();
        spikes();
        bomb();
        getGemBlue();
        key();
        touchingSchatkist();
        removeBadGuy();
        level2();
        // getPositie();
        checkpointVlag();
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();
    }

            public int boostSnelheid()
            {
            if(isTouching(Boost.class))    
            {
            removeTouching(Boost.class);
            snelheid+=3;
            
            }
            return snelheid;
            } 
            
            public void lava()
            {
            for (Actor lavaTile : getObjectsInRange(50, LavaTile.class)) {
            if (lavaTile != null && lavaTile instanceof LavaTile ) {
               // getWorld().removeObject(this);
                setLocation(x,y);
                isDood=true;
                break;
            }
            }
        }
    
            public void spikes()
            {
             for (Actor SpikesTile : getObjectsInRange(50, SpikesTile.class)) {
            if (SpikesTile != null && SpikesTile instanceof SpikesTile ) {
                setLocation(x,y);
                isDood=true;
                break;
            }
            }
        }
       
         public void bomb()
            {
             for (Actor BombTile : getObjectsInRange(50, BombTile.class)) {
            if (BombTile != null && BombTile instanceof BombTile ) {
                setLocation(x,y);
                isDood=true;
                break;
            }
            }
        }
    
    public boolean touchingSchatkist()
    {
        if(key==true)
        {
            if(isTouching(Schatkist.class)) 
            {
                removeTouching(Schatkist.class);
                 schatkist=true;
            }
            
        }
        return schatkist;
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
                        if(schatkist==true)
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
         //Deur van level2 naar Level 3
        for(Actor door:getIntersectingObjects(Door.class)) 
        {
             if(key==true)
             {   
                 if(door!=null)
                 {  
                     
                       if(gem == 18)
                      {
                        
                        if(BadGuy.class != null)
                        { 
                            if(schatkist==true)
                            {
                            Greenfoot.setWorld(new MyWorld3());
                            String actieveWereld="MyWorld3";  
                            return;
                           }
                        }
                      } 
                  }
                      
             }
           
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
        for (Actor Hero: getIntersectingObjects(JumpTile.class)){
       if (Greenfoot.isKeyDown("UP")) {
            inAir=true;
            velocityY = -15;
  
        }
        else inAir=false;
    }
        if (Greenfoot.isKeyDown("Left")) {
            velocityX = -6.75-snelheid;
        } else if (Greenfoot.isKeyDown("Right")) {
            velocityX = 6.75+snelheid;
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


   
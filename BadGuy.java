
import java.util.*;
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class BadGuy extends Mover 
{
    int frames=1;
    private double speed=0.75;
    boolean atEdge;
    public String actieveWereld="";

    public BadGuy(String actieveWereld) 
    {
        super();
        setImage("flyFly1.png");
        speed = 1;
        this.actieveWereld=actieveWereld;
 
    }

    @Override
    public void act() 
    {
        List<Hero> heroList = this.getWorld().getObjects(Hero.class);
        Hero myHero = heroList.get(0);
        int xpos=myHero.x;
        int ypos=myHero.y;
        int x= getX();
        int y = getY();
        int b=0;
        boolean dood=myHero.isDood;
        up(); 
        frames();
        atEdge();
         //down();
        if(dood)
        {
            setLocation((xpos+300),(ypos));  
            atEdge=false;
        }
        
        if(actieveWereld=="MyWorld4")
        {    
            velocityX = 5;
	}
	else
	{
	    velocityX = 4;	
	}
        applyVelocity();
       
    }

    public boolean atEdge()
    {
        if(actieveWereld=="MyWorld1")
        {
            if(getX()>6095)
            {
               atEdge=true;
            }
        }

        if(actieveWereld =="MyWorld2")
        {
            if(getX()>6157)
            {
                atEdge=true;
            }
       }

       if(actieveWereld =="MyWorld3")
        {
            if(getX()>6034)
            {    
                atEdge=true;    
            }
        }

        if(actieveWereld =="MyWorld4")
        {
            if(getX()>5786)
            {
                atEdge=true; 
            }
        }
        return atEdge;
    }

    public void frames()
    {    
              if(frames==1)
            { 
                setImage("BadGuy.png");    
            }

            if(frames==2)
            {
                setImage("flyFly1.png");    
            }
            if(frames==3)
            {
                setImage("flyFly2.png");    
                frames=1;
            }
            frames++;    
    }

    public void up()
    {       
            if(actieveWereld=="MyWorld2"||actieveWereld=="MyWorld3"||actieveWereld=="MyWorld4")
            {
                for(Actor d:getObjectsInRange (70,JumpTile.class))
                    {    
                        int s=getY();
                        s-=6;
                        int x= getX();
                        int y = getY();
                        setLocation(x,s) ; 
                    }  
                }
            else
            {    
                for(Actor d:getObjectsInRange (70,JumpTile.class))
                {    
                    int s=getY();
                    s-=10;
                    int x= getX();
                    int y = getY();
                    setLocation(x,s) ; 
                } 
            }
    
    }
        
    
}


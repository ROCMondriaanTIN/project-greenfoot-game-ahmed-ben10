import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends Mover
{
    int frame=10;
    boolean newCheckpoint=false;
    public Checkpoint ()
    {
    setImage("flagBlue.png");
    }
    public void act() 
    {
        applyVelocity();
        frames();
    }  
    public void frames()
    {
        if(frame==10)
        {
            setImage("flagBlueHanging.png");
        }
        if(isTouching(Hero.class))
        {
        newCheckpoint=true; 
        frame=1;  
        }
        if(newCheckpoint==true)
        {
            
             if(frame==1)
            {
                setImage("flagBlue.png");
            }
             if(frame==2)
            {
                setImage("flagBlue2.png");
                frame=1;
                Greenfoot.delay(1);
                return;
            }
            frame++;
        }
    }
}

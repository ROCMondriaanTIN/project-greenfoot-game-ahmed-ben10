import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Mover
{
    GreenfootSound start = new GreenfootSound("startScherm.wav");
    public StartButton()
    {
        setImage("buttonstartgame.png");
    }
    public void act() 
    {
        applyVelocity();
        if(!start.isPlaying())
        {
            start.playLoop();
        }
        
        if(Greenfoot.mouseClicked(this))
        { 
            start.stop();
            Greenfoot.setWorld(new MyWorld());
            return;    
        }
        
        
        
    }    
}

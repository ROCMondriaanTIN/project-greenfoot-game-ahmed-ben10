import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpButton extends Mover
{
    public HelpButton()
    {
        setImage("help.png");       
    }
    public void act() 
    {
        applyVelocity();
        
        if(Greenfoot.mouseClicked(this))
        { 
            Greenfoot.setWorld(new HelpWorld());            
            return;    
        }
    }    
}

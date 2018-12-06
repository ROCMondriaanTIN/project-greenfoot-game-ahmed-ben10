import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Mover
{
    public StartButton()
    {
        setImage("buttonstartgame.png");
    }
    public void act() 
    {
        applyVelocity();
        if(Greenfoot.mouseClicked(this))
        { 
        Greenfoot.setWorld(new MyWorld()); 
        return;    
        }
    }    
}

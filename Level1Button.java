import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1Button extends Mover
{
    public Level1Button()
    {
    setImage("startButton.png");  
    getImage().scale(410,214);
    }
    public void act() 
    {
        applyVelocity();
        if(Greenfoot.mouseClicked(this))
        { 
        Greenfoot.setWorld(new  MyWorld()); 
        return;    
        }
    }    
}

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rules here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rules extends Mover
{
    public Rules()
    {
    setImage("rules.png");    
    }
    public void act() 
    {
        applyVelocity();
        applyVelocity();
        if(Greenfoot.mouseClicked(this))
        { 
        Greenfoot.setWorld(new RulesWorld()); 
        return;    
        }
        
    }    
}
